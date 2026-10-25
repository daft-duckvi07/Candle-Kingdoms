package net.candleteam.candlekingdoms.BlockEntity;

import net.candleteam.candlekingdoms.Block.ModBlocks;
import net.candleteam.candlekingdoms.BlockEntity.EBlocks.CandleTownBlockEntity;
import net.candleteam.candlekingdoms.CandleKingdoms;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(
                    net.minecraft.core.registries.Registries.BLOCK_ENTITY_TYPE,
                    CandleKingdoms.MOD_ID
            );

    public static final Supplier<BlockEntityType<CandleTownBlockEntity>>
            CANDLE_TOWN = BLOCK_ENTITY_TYPES.register(
            "named_candle",
            () -> new BlockEntityType<>(
                    CandleTownBlockEntity::new,
                    false,
                    ModBlocks.CANDLE_TOWN.get()
            )
    );

    private ModBlockEntities() {}
}