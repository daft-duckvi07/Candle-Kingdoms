package net.candleteam.candlekingdoms.dataskum;

import net.candleteam.candlekingdoms.Block.ModBlocks;
import net.candleteam.candlekingdoms.CandleKingdoms;
import net.candleteam.candlekingdoms.Item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.neoforged.fml.common.Mod;

public class CandleModelProvider extends ModelProvider {
    public CandleModelProvider(PackOutput output) {
        super(output, CandleKingdoms.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.AZURITE.get(), ModelTemplates.FLAT_ITEM);


        /* BLOCKS */
        blockModels.createTrivialCube(ModBlocks.UTKA_BLOCK.get());
        blockModels.createNonTemplateModelBlock(ModBlocks.TOWN_BLOCK.get());
        blockModels.createNonTemplateModelBlock(ModBlocks.ARMY_BLOCK.get());


    }
}
