package net.candleteam.candlekingdoms.BlockEntity.EBlocks;

import net.candleteam.candlekingdoms.BlockEntity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class CandleTownBlockEntity extends BlockEntity {

    private String customName = "";

    public CandleTownBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CANDLE_TOWN.get(), pos, state);
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String name) {
        this.customName = name;
        setChanged();
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putString("CustomName", customName);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        customName = input.getStringOr("CustomName", "");
    }
}
