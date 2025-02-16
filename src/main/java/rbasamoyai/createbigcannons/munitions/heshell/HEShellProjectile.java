package rbasamoyai.createbigcannons.munitions.heshell;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import rbasamoyai.createbigcannons.CBCBlocks;
import rbasamoyai.createbigcannons.munitions.FuzedCannonProjectile;

public class HEShellProjectile extends FuzedCannonProjectile {

	public HEShellProjectile(EntityType<? extends HEShellProjectile> type, Level level) {
		super(type, level);
		this.setBreakthroughPower((byte) 2);
	}
	
	@Override
	protected void detonate() {
		this.level.explode(null, this.getX(), this.getY(), this.getZ(), 6, Explosion.BlockInteraction.DESTROY);
		this.discard();
	}

	@Override
	public BlockState getRenderedBlockState() {
		return CBCBlocks.HE_SHELL.getDefaultState().setValue(BlockStateProperties.FACING, Direction.NORTH);
	}

}
