package rtg.reference;

import javax.annotation.Nonnull;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiErrorScreen;

import cpw.mods.fml.client.CustomModLoadingErrorDisplayException;

public class IncompatibleModException extends CustomModLoadingErrorDisplayException {

    private String REASON = null;
    private final String RESTART = "Please remove the mod and restart the game.";

    public IncompatibleModException(@Nonnull String reason) {
        super(reason, new RuntimeException());
        this.REASON = reason;
    }

    @Override
    public void initGui(GuiErrorScreen errorScreen, FontRenderer fontRenderer) {
        Minecraft.getMinecraft()
            .displayGuiScreen(new GuiErrorScreen(this.REASON, RESTART) {

                @Override
                public void initGui() {
                    this.buttonList.add(new GuiButton(0, this.width / 2 - 100, 140, "Close Game"));
                }

                @Override
                public void onGuiClosed() {
                    Minecraft.getMinecraft()
                        .shutdown();
                }
            });
    }

    @Override
    public void drawScreen(GuiErrorScreen errorScreen, FontRenderer fontRenderer, int mouseRelX, int mouseRelY,
        float tickTime) {}

}
