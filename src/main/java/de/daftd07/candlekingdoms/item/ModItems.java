package de.daftd07.candlekingdoms.item;

import de.daftd07.candlekingdoms.CandleKingdoms;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CandleKingdoms.MOD_ID);

    public static final DeferredItem<Item> IDK = ITEMS.register("idk",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
