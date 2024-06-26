package rtg.world.biome.realistic.biomesoplenty;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

import biomesoplenty.api.content.BOPCBiomes;
import biomesoplenty.api.content.BOPCBlocks;
import rtg.api.biome.BiomeConfig;
import rtg.api.biome.biomesoplenty.config.BiomeConfigBOPOasis;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.biome.deco.DecoFallenTree;
import rtg.world.biome.deco.DecoFallenTree.LogCondition;
import rtg.world.gen.surface.biomesoplenty.SurfaceBOPOasis;
import rtg.world.gen.terrain.biomesoplenty.TerrainBOPOasis;

public class RealisticBiomeBOPOasis extends RealisticBiomeBOPBase {

    public static BiomeGenBase bopBiome = BOPCBiomes.oasis;

    public static Block topBlock = bopBiome.topBlock;
    public static Block fillerBlock = bopBiome.fillerBlock;

    public RealisticBiomeBOPOasis(BiomeConfig config) {
        super(
            config,
            bopBiome,
            BiomeGenBase.river,
            new TerrainBOPOasis(),
            new SurfaceBOPOasis(
                config,
                topBlock, // Block top
                (byte) 0, // byte topByte
                fillerBlock, // Block filler,
                (byte) 0, // byte fillerByte
                Blocks.sand, // Block mixTop,
                (byte) 0, // byte mixTopByte,
                Blocks.sandstone, // Block mixFill,
                (byte) 0, // byte mixFillByte,
                40f, // float mixWidth,
                -0.15f, // float mixHeight,
                10f, // float smallWidth,
                0.5f // float smallStrength
            ));

        DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
        this.addDeco(decoBaseBiomeDecorations);

        DecoFallenTree decoFallenTree = new DecoFallenTree();
        decoFallenTree.distribution.noiseDivisor = 80f;
        decoFallenTree.distribution.noiseFactor = 60f;
        decoFallenTree.distribution.noiseAddend = -15f;
        decoFallenTree.logCondition = LogCondition.RANDOM_CHANCE;
        decoFallenTree.logConditionChance = 16;
        decoFallenTree.logBlock = BOPCBlocks.logs2;
        decoFallenTree.logMeta = (byte) 3;
        decoFallenTree.leavesBlock = Blocks.leaves;
        decoFallenTree.leavesMeta = (byte) -1;
        decoFallenTree.minSize = 3;
        decoFallenTree.maxSize = 5;
        this.addDeco(decoFallenTree, this.config._boolean(BiomeConfigBOPOasis.decorationLogsId));
    }
}
