package net.candleteam.candlekingdoms;

import net.candleteam.candlekingdoms.keymapping.ModKeyMappings;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

import static net.candleteam.candlekingdoms.keymapping.ModKeyMappings.CANDLE_KINGDOMS_CATEGORY;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = CandleKingdoms.MOD_ID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = CandleKingdoms.MOD_ID, value = Dist.CLIENT)
public class CandleKingdomsClient {
    public CandleKingdomsClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

        ModKeyMappings.register();
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        CandleKingdoms.LOGGER.info("HELLO FROM CLIENT SETUP");
        CandleKingdoms.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    @SubscribeEvent
    public static void  registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.registerCategory(CANDLE_KINGDOMS_CATEGORY);
        event.register(ModKeyMappings.PRESS_MOVE.get());
    }

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        if (ModKeyMappings.PRESS_MOVE.get().consumeClick()) {
            //CHANGE LATER (SERVER-SIDE)
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("Move button pressed."));
        }
    }
}