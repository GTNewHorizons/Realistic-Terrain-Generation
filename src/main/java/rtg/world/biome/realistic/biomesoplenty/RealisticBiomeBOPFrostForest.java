package rtg.world.biome.realistic.biomesoplenty;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

import biomesoplenty.api.content.BOPCBiomes;
import rtg.api.biome.BiomeConfig;
import rtg.api.biome.biomesoplenty.config.BiomeConfigBOPFrostForest;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.biome.deco.DecoBoulder;
import rtg.world.biome.deco.DecoFallenTree;
import rtg.world.biome.deco.DecoFallenTree.LogCondition;
import rtg.world.biome.deco.helper.DecoHelper5050;
import rtg.world.gen.surface.biomesoplenty.SurfaceBOPFrostForest;
import rtg.world.gen.terrain.biomesoplenty.TerrainBOPFrostForest;

public class RealisticBiomeBOPFrostForest extends RealisticBiomeBOPBase {

    public static BiomeGenBase bopBiome = BOPCBiomes.frostForest;

    public static Block topBlock = bopBiome.topBlock;
    public static Block fillerBlock = bopBiome.fillerBlock;

    public RealisticBiomeBOPFrostForest(BiomeConfig config) {
        super(
            config,
            bopBiome,
            BiomeGenBase.frozenRiver,
            new TerrainBOPFrostForest(58f, 69f, 28f),
            new SurfaceBOPFrostForest(
                config,
                topBlock, // Block top
                (byte) 0, // byte topByte
                fillerBlock, // Block filler,
                (byte) 0, // byte fillerByte
                topBlock, // Block mixTop,
                (byte) 0, // byte mixTopByte,
                fillerBlock, // Block mixFill,
                (byte) 0, // byte mixFillByte,
                80f, // float mixWidth,
                -0.15f, // float mixHeight,
                10f, // float smallWidth,
                0.5f // float smallStrength
            ));

        DecoBoulder decoBoulder1 = new DecoBoulder();
        decoBoulder1.boulderBlock = Blocks.cobblestone;
        decoBoulder1.maxY = 80;
        decoBoulder1.chance = 14;
        decoBoulder1.strengthFactor = 1f;
        DecoBoulder decoBoulder2 = new DecoBoulder();
        decoBoulder2.boulderBlock = Blocks.cobblestone;
        decoBoulder2.maxY = 80;
        decoBoulder2.chance = 14;
        decoBoulder2.strengthFactor = 1f;
        DecoHelper5050 decoHelper5050 = new DecoHelper5050(decoBoulder1, decoBoulder2);
        this.addDeco(decoHelper5050);

        DecoFallenTree decoFallenTree = new DecoFallenTree();
        decoFallenTree.distribution.noiseDivisor = 100f;
        decoFallenTree.distribution.noiseFactor = 6f;
        decoFallenTree.distribution.noiseAddend = 0.8f;
        decoFallenTree.logCondition = LogCondition.NOISE_GREATER_AND_RANDOM_CHANCE;
        decoFallenTree.logConditionNoise = 0f;
        decoFallenTree.logConditionChance = 12;
        decoFallenTree.logBlock = Blocks.log;
        decoFallenTree.logMeta = (byte) 0;
        decoFallenTree.leavesBlock = Blocks.leaves;
        decoFallenTree.leavesMeta = (byte) -1;
        decoFallenTree.minSize = 3;
        decoFallenTree.maxSize = 5;
        this.addDeco(decoFallenTree, this.config._boolean(BiomeConfigBOPFrostForest.decorationLogsId));

        DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
        this.addDeco(decoBaseBiomeDecorations);
    }
}
