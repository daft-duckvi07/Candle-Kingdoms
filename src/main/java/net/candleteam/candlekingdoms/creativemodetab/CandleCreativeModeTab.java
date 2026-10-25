package net.candleteam.candlekingdoms.creativemodetab;

import net.candleteam.candlekingdoms.CandleKingdoms;
import net.candleteam.candlekingdoms.Block.ModBlocks;
import net.candleteam.candlekingdoms.Item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class CandleCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CandleKingdoms.MOD_ID);


    public static final Supplier<CreativeModeTab> CANDLE_KINGDOMS_TAB = CREATIVE_MODE_TABS.register("candle_kingdoms_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.HMMM.get()))
                    .title(Component.translatable("creativetab.candlekingdoms.candlekingdoms_items"))
                    .withTabsBefore(CreativeModeTabs.INGREDIENTS)
                    .displayItems((itemDisplayParameters, output) -> {



                        output.accept(ModBlocks.UTKA_BLOCK);
                        output.accept(ModBlocks.TOWN_BLOCK);
                        output.accept(ModBlocks.ARMY_BLOCK);
//                        output.accept(ModItems.RAW_AZURITE);


                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
