package de.daftd07.candlekingdoms;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = CandleKingdoms.MOD_ID, dist = Dist.CLIENT)

@EventBusSubscriber(modid = CandleKingdoms.MOD_ID, value = Dist.CLIENT)
public class CandleKingdomsClient {
    public CandleKingdomsClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        CandleKingdoms.LOGGER.info("CL S.V., N.TS.S., R.K.G., O,SH!");;
    }
}
