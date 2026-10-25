package net.candleteam.candlekingdoms;

import net.candleteam.candlekingdoms.Block.ModBlocks;
import net.candleteam.candlekingdoms.BlockEntity.ModBlockEntities;
import net.candleteam.candlekingdoms.creativemodetab.CandleCreativeModeTab;
import net.candleteam.candlekingdoms.Item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CandleKingdoms.MOD_ID)
public class CandleKingdoms {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "candlekingdoms";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public CandleKingdoms(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        CandleCreativeModeTab.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITY_TYPES.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
        // Register the item to a creative tab
       // modEventBus.addListener(this::addCreative);
        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    /* дОдає предмет (у цьому випадку сирий азуріт) до вкладки інгридієнти
       додає блок (у цьому випадку утка блок) до вкладки блоки для будівництва

       в цілому це не потрібно в нашому моді, але на випадок якщо треба буде
       то ось готовий приклад

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.RAW_AZURITE);
        }

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.UTKA_BLOCK);
        }
    }

    */


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}