package rbasamoyai.createbigcannons;

import com.simibubi.create.content.AllSections;
import com.simibubi.create.foundation.block.BlockStressDefaults;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.builders.BlockBuilder;
import com.simibubi.create.repack.registrate.util.entry.BlockEntry;
import com.simibubi.create.repack.registrate.util.nullness.NonNullFunction;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import rbasamoyai.createbigcannons.cannonloading.CannonLoaderBlock;
import rbasamoyai.createbigcannons.cannonloading.RamHeadBlock;
import rbasamoyai.createbigcannons.cannonloading.WormHeadBlock;
import rbasamoyai.createbigcannons.cannonmount.CannonMountBlock;
import rbasamoyai.createbigcannons.cannonmount.YawControllerBlock;
import rbasamoyai.createbigcannons.cannons.CannonBarrelBlock;
import rbasamoyai.createbigcannons.cannons.CannonChamberBlock;
import rbasamoyai.createbigcannons.cannons.CannonMaterial;
import rbasamoyai.createbigcannons.cannons.cannonend.CannonEndBlock;
import rbasamoyai.createbigcannons.cannons.cannonend.SlidingBreechBlock;
import rbasamoyai.createbigcannons.datagen.CBCBuilderTransformers;
import rbasamoyai.createbigcannons.munitions.PowderChargeBlock;
import rbasamoyai.createbigcannons.munitions.grapeshot.GrapeshotBlock;
import rbasamoyai.createbigcannons.munitions.heshell.HEShellBlock;
import rbasamoyai.createbigcannons.munitions.shot.SolidShotBlock;
import rbasamoyai.createbigcannons.munitions.shrapnel.ShrapnelShellBlock;

public class CBCBlocks {

	private static final CreateRegistrate REGISTRATE = CreateBigCannons.registrate()
			.creativeModeTab(() -> ModGroup.GROUP);
	
	static {
		REGISTRATE.startSection(AllSections.KINETICS);
	}
	
	//////// Cast Iron cannon blocks ////////
	
	public static final BlockEntry<CannonBarrelBlock> CAST_IRON_CANNON_BARREL = REGISTRATE
			.block("cast_iron_cannon_barrel", p -> new CannonBarrelBlock(p, CannonMaterial.CAST_IRON))
			.transform(castIron())
			.transform(CBCBuilderTransformers.cannonBarrel("cannon_barrel/cast_iron"))
			.simpleItem()
			.register();
	
	public static final BlockEntry<CannonChamberBlock> CAST_IRON_CANNON_CHAMBER = REGISTRATE
			.block("cast_iron_cannon_chamber", p -> new CannonChamberBlock(p, CannonMaterial.CAST_IRON))
			.transform(castIron())
			.transform(CBCBuilderTransformers.cannonChamber("cannon_chamber/cast_iron"))
			.simpleItem()
			.register();
	
	public static final BlockEntry<CannonEndBlock> CAST_IRON_CANNON_END = REGISTRATE
			.block("cast_iron_cannon_end", p -> new CannonEndBlock(p, CannonMaterial.CAST_IRON))
			.transform(castIron())
			.transform(CBCBuilderTransformers.cannonEnd("cannon_end/cast_iron"))
			.simpleItem()
			.register();
	
	public static final BlockEntry<SlidingBreechBlock> CAST_IRON_SLIDING_BREECH = REGISTRATE
			.block("cast_iron_sliding_breech", p -> new SlidingBreechBlock(p, CannonMaterial.CAST_IRON))
			.transform(castIron())
			.transform(CBCBuilderTransformers.slidingBreech("sliding_breech/cast_iron"))
			.transform(BlockStressDefaults.setImpact(16.0d))
			.register();
	
	//////// Bronze cannon blocks ////////
	
	public static final BlockEntry<CannonBarrelBlock> BRONZE_CANNON_BARREL = REGISTRATE
			.block("bronze_cannon_barrel", p -> new CannonBarrelBlock(p, CannonMaterial.BRONZE))
			.transform(castIron())
			.transform(CBCBuilderTransformers.cannonBarrel("cannon_barrel/bronze"))
			.simpleItem()
			.register();
	
	public static final BlockEntry<CannonChamberBlock> BRONZE_CANNON_CHAMBER = REGISTRATE
			.block("bronze_cannon_chamber", p -> new CannonChamberBlock(p, CannonMaterial.BRONZE))
			.transform(castIron())
			.transform(CBCBuilderTransformers.cannonChamber("cannon_chamber/bronze"))
			.simpleItem()
			.register();
	
	public static final BlockEntry<CannonEndBlock> BRONZE_CANNON_END = REGISTRATE
			.block("bronze_cannon_end", p -> new CannonEndBlock(p, CannonMaterial.BRONZE))
			.transform(castIron())
			.transform(CBCBuilderTransformers.cannonEnd("cannon_end/bronze"))
			.simpleItem()
			.register();
	
	public static final BlockEntry<SlidingBreechBlock> BRONZE_SLIDING_BREECH = REGISTRATE
			.block("bronze_sliding_breech", p -> new SlidingBreechBlock(p, CannonMaterial.BRONZE))
			.transform(castIron())
			.transform(CBCBuilderTransformers.slidingBreech("sliding_breech/bronze"))
			.transform(BlockStressDefaults.setImpact(12.0d))
			.register();
	
	//////// Other blocks ////////
	
	public static final BlockEntry<CannonLoaderBlock> CANNON_LOADER = REGISTRATE
			.block("cannon_loader", CannonLoaderBlock::new)
			.properties(p -> p.color(MaterialColor.PODZOL))
			.transform(axeOrPickaxe())
			.transform(CBCBuilderTransformers.cannonLoader())
			.transform(BlockStressDefaults.setImpact(8.0d))
			.register();
	
	public static final BlockEntry<RamHeadBlock> RAM_HEAD = REGISTRATE
			.block("ram_head", RamHeadBlock::new)
			.initialProperties(() -> Blocks.PISTON_HEAD)
			.properties(p -> p.sound(SoundType.WOOD))
			.transform(CBCBuilderTransformers.ramHead())
			.transform(axeOrPickaxe())
			.simpleItem()
			.register();
	
	public static final BlockEntry<WormHeadBlock> WORM_HEAD = REGISTRATE
			.block("worm_head", WormHeadBlock::new)
			.initialProperties(() -> Blocks.PISTON_HEAD)
			.properties(p -> p.sound(SoundType.METAL))
			.transform(CBCBuilderTransformers.wormHead())
			.transform(axeOrPickaxe())
			.simpleItem()
			.register();
	
	static {
		REGISTRATE.startSection(AllSections.LOGISTICS);
	}
	
	//////// Projectiles ////////
	
	public static final BlockEntry<SolidShotBlock> SOLID_SHOT = REGISTRATE
			.block("solid_shot", SolidShotBlock::new)
			.initialProperties(Material.METAL)
			.properties(p -> p.strength(2.0f, 3.0f))
			.properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
			.transform(axeOrPickaxe())
			.transform(CBCBuilderTransformers.projectile("projectile/solid_shot"))
			.simpleItem()
			.register();
	
	public static final BlockEntry<HEShellBlock> HE_SHELL = REGISTRATE
			.block("he_shell", HEShellBlock::new)
			.transform(shell(MaterialColor.COLOR_RED))
			.transform(axeOrPickaxe())
			.transform(CBCBuilderTransformers.projectile("projectile/he_shell"))
			.lang("High Explosive (HE) Shell")
			.simpleItem()
			.register();
	
	public static final BlockEntry<ShrapnelShellBlock> SHRAPNEL_SHELL = REGISTRATE
			.block("shrapnel_shell", ShrapnelShellBlock::new)
			.transform(shell(MaterialColor.COLOR_GREEN))
			.transform(axeOrPickaxe())
			.transform(CBCBuilderTransformers.projectile("projectile/shrapnel_shell"))
			.simpleItem()
			.register();
	
	public static final BlockEntry<GrapeshotBlock> BAG_OF_GRAPESHOT = REGISTRATE
			.block("bag_of_grapeshot", GrapeshotBlock::new)
			.initialProperties(Material.METAL, MaterialColor.WOOL)
			.properties(p -> p.sound(SoundType.WOOL))
			.transform(CBCBuilderTransformers.projectile("projectile/grapeshot"))
			.lang("Bag of Grapeshot")
			.simpleItem()
			.register();
	
	public static final BlockEntry<PowderChargeBlock> POWDER_CHARGE = REGISTRATE
			.block("powder_charge", PowderChargeBlock::new)
			.initialProperties(() -> Blocks.TNT)
			.properties(p -> p.sound(SoundType.WOOL))
			.transform(CBCBuilderTransformers.powderCharge())
			.simpleItem()
			.register();
	
	static {
		REGISTRATE.startSection(AllSections.KINETICS);
	}
	
	public static final BlockEntry<CannonMountBlock> CANNON_MOUNT = REGISTRATE
			.block("cannon_mount", CannonMountBlock::new)
			.properties(p -> p.color(MaterialColor.PODZOL))
			.properties(p -> p.isRedstoneConductor(CBCBlocks::never))
			.transform(axeOrPickaxe())
			.transform(CBCBuilderTransformers.cannonMount())
			.register();
	
	public static final BlockEntry<YawControllerBlock> YAW_CONTROLLER = REGISTRATE
			.block("yaw_controller", YawControllerBlock::new)
			.properties(p -> p.color(MaterialColor.PODZOL))
			.transform(axeOrPickaxe())
			.transform(CBCBuilderTransformers.yawController())
			.register();
	
	private static <T extends Block, P> NonNullFunction<BlockBuilder<T, P>, BlockBuilder<T, P>> castIron() {
		return b -> b.initialProperties(Material.METAL)
				.properties(p -> p.strength(5.0f, 6.0f))
				.properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
				.properties(p -> p.requiresCorrectToolForDrops())
				.tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.tag(BlockTags.NEEDS_IRON_TOOL);
	}
	
	private static <T extends Block, P> NonNullFunction<BlockBuilder<T, P>, BlockBuilder<T, P>> shell(MaterialColor color) {
		return b -> b.initialProperties(Material.EXPLOSIVE, color)
				.properties(p -> p.strength(2.0f, 3.0f))
				.properties(p -> p.sound(SoundType.STONE));
	}
	
	private static <T extends Block, P> NonNullFunction<BlockBuilder<T, P>, BlockBuilder<T, P>> axeOrPickaxe() {
		return b -> b.tag(BlockTags.MINEABLE_WITH_AXE)
				.tag(BlockTags.MINEABLE_WITH_PICKAXE);
	}
	
	private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos) { return false; }
	
	public static void register() {}
	
}
