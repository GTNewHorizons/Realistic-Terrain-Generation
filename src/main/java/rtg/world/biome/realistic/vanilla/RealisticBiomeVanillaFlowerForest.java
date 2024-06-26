package rtg.world.biome.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

import rtg.api.biome.BiomeConfig;
import rtg.api.biome.vanilla.config.BiomeConfigVanillaFlowerForest;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.biome.deco.DecoFallenTree;
import rtg.world.biome.deco.DecoFallenTree.LogCondition;
import rtg.world.biome.deco.DecoFlowersRTG;
import rtg.world.biome.deco.DecoFlowersRTG.HeightType;
import rtg.world.biome.deco.DecoGrass;
import rtg.world.biome.deco.DecoShrub;
import rtg.world.biome.deco.DecoTree;
import rtg.world.biome.deco.DecoTree.TreeCondition;
import rtg.world.biome.deco.DecoTree.TreeType;
import rtg.world.biome.deco.collection.DecoCollectionSmallPineTreesForest;
import rtg.world.biome.deco.helper.DecoHelper5050;
import rtg.world.gen.feature.tree.rtg.TreeRTG;
import rtg.world.gen.feature.tree.rtg.TreeRTGPinusPonderosa;
import rtg.world.gen.surface.vanilla.SurfaceVanillaFlowerForest;
import rtg.world.gen.terrain.vanilla.TerrainVanillaFlowerForest;

public class RealisticBiomeVanillaFlowerForest extends RealisticBiomeVanillaBase {

    public static BiomeGenBase standardBiome = BiomeGenBase.forest;
    public static BiomeGenBase mutationBiome = BiomeGenBase.getBiome(standardBiome.biomeID + MUTATION_ADDEND);

    public static Block topBlock = mutationBiome.topBlock;
    public static Block fillerBlock = mutationBiome.fillerBlock;

    public RealisticBiomeVanillaFlowerForest(BiomeConfig config) {

        super(
            config,
            mutationBiome,
            BiomeGenBase.river,
            new TerrainVanillaFlowerForest(),
            new SurfaceVanillaFlowerForest(
                config,
                Blocks.grass,
                Blocks.dirt,
                false,
                null,
                0f,
                1.5f,
                60f,
                65f,
                1.5f,
                Blocks.grass,
                0.05f));

        /**
         * ##################################################
         * # DECORATIONS (ORDER MATTERS)
         * ##################################################
         */

        // First, let's get a few shrubs in to break things up a bit.
        DecoShrub decoShrub = new DecoShrub();
        decoShrub.maxY = 110;
        decoShrub.strengthFactor = 4f;
        decoShrub.chance = 3;
        this.addDeco(decoShrub);

        // Flowers are the most aesthetically important feature of this biome, so let's add those next.
        DecoFlowersRTG decoFlowers1 = new DecoFlowersRTG();
        decoFlowers1.flowers = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // Only colourful 1-block-tall flowers.
        decoFlowers1.strengthFactor = 12f; // Lots and lots of flowers!
        decoFlowers1.heightType = HeightType.GET_HEIGHT_VALUE; // We're only bothered about surface flowers here.
        this.addDeco(decoFlowers1);

        DecoFlowersRTG decoFlowers2 = new DecoFlowersRTG();
        decoFlowers2.flowers = new int[] { 10, 11, 14, 15 }; // Only 2-block-tall flowers.
        decoFlowers2.strengthFactor = 2f; // Not as many of these.
        decoFlowers2.chance = 3;
        decoFlowers2.heightType = HeightType.GET_HEIGHT_VALUE; // We're only bothered about surface flowers here.
        this.addDeco(decoFlowers2);

        // Trees first.

        TreeRTG ponderosaOakTree = new TreeRTGPinusPonderosa();
        ponderosaOakTree.logBlock = Blocks.log;
        ponderosaOakTree.logMeta = (byte) 0;
        ponderosaOakTree.leavesBlock = Blocks.leaves;
        ponderosaOakTree.leavesMeta = (byte) 0;
        ponderosaOakTree.minTrunkSize = 11;
        ponderosaOakTree.maxTrunkSize = 21;
        ponderosaOakTree.minCrownSize = 15;
        ponderosaOakTree.maxCrownSize = 29;
        this.addTree(ponderosaOakTree);

        DecoTree oakPines = new DecoTree(ponderosaOakTree);
        oakPines.strengthNoiseFactorForLoops = true;
        oakPines.treeType = TreeType.RTG_TREE;
        oakPines.distribution.noiseDivisor = 80f;
        oakPines.distribution.noiseFactor = 60f;
        oakPines.distribution.noiseAddend = -15f;
        oakPines.treeCondition = TreeCondition.ALWAYS_GENERATE;
        oakPines.treeConditionNoise = 0f;
        oakPines.treeConditionChance = 1;
        oakPines.maxY = 140;

        TreeRTG ponderosaSpruceTree = new TreeRTGPinusPonderosa();
        ponderosaSpruceTree.logBlock = Blocks.log;
        ponderosaSpruceTree.logMeta = (byte) 1;
        ponderosaSpruceTree.leavesBlock = Blocks.leaves;
        ponderosaSpruceTree.leavesMeta = (byte) 1;
        ponderosaSpruceTree.minTrunkSize = 11;
        ponderosaSpruceTree.maxTrunkSize = 21;
        ponderosaSpruceTree.minCrownSize = 15;
        ponderosaSpruceTree.maxCrownSize = 29;
        this.addTree(ponderosaSpruceTree);

        DecoTree sprucePines = new DecoTree(ponderosaSpruceTree);
        sprucePines.strengthNoiseFactorForLoops = true;
        sprucePines.treeType = TreeType.RTG_TREE;
        sprucePines.distribution.noiseDivisor = 80f;
        sprucePines.distribution.noiseFactor = 60f;
        sprucePines.distribution.noiseAddend = -15f;
        sprucePines.treeCondition = TreeCondition.ALWAYS_GENERATE;
        sprucePines.treeConditionNoise = 0f;
        sprucePines.treeConditionChance = 1;
        sprucePines.maxY = 140;

        DecoHelper5050 decoPines = new DecoHelper5050(oakPines, sprucePines);
        this.addDeco(decoPines);

        // More trees.
        this.addDecoCollection(new DecoCollectionSmallPineTreesForest());

        // Not much free space left, so let's give some space to the base biome.
        DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
        decoBaseBiomeDecorations.notEqualsZeroChance = 4;
        this.addDeco(decoBaseBiomeDecorations);

        // Add some fallen trees of the oak and spruce variety (50/50 distribution).
        DecoFallenTree decoFallenOak = new DecoFallenTree();
        decoFallenOak.logCondition = LogCondition.RANDOM_CHANCE;
        decoFallenOak.logConditionChance = 8;
        decoFallenOak.maxY = 100;
        decoFallenOak.logBlock = Blocks.log;
        decoFallenOak.logMeta = (byte) 0;
        decoFallenOak.leavesBlock = Blocks.leaves;
        decoFallenOak.leavesMeta = (byte) -1;
        decoFallenOak.minSize = 3;
        decoFallenOak.maxSize = 6;
        DecoFallenTree decoFallenSpruce = new DecoFallenTree();
        decoFallenSpruce.logCondition = LogCondition.RANDOM_CHANCE;
        decoFallenSpruce.logConditionChance = 8;
        decoFallenSpruce.maxY = 100;
        decoFallenSpruce.logBlock = Blocks.log;
        decoFallenSpruce.logMeta = (byte) 1;
        decoFallenSpruce.leavesBlock = Blocks.leaves;
        decoFallenSpruce.leavesMeta = (byte) -1;
        decoFallenSpruce.minSize = 3;
        decoFallenSpruce.maxSize = 6;
        DecoHelper5050 decoFallenTree = new DecoHelper5050(decoFallenOak, decoFallenSpruce);
        this.addDeco(decoFallenTree, this.config._boolean(BiomeConfigVanillaFlowerForest.decorationLogsId));

        // Grass filler.
        DecoGrass decoGrass = new DecoGrass();
        decoGrass.maxY = 128;
        decoGrass.strengthFactor = 24f;
        this.addDeco(decoGrass);
    }
}
