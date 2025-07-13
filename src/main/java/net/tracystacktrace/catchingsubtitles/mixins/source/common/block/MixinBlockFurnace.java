package net.tracystacktrace.catchingsubtitles.mixins.source.common.block;

import net.minecraft.common.block.children.BlockFurnace;
import net.minecraft.common.world.World;
import net.tracystacktrace.catchingsubtitles.subtitle.SourceIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(BlockFurnace.class)
public class MixinBlockFurnace {
    @Inject(method = "randomDisplayTick", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundEffect(DDDLjava/lang/String;FF)V"))
    private void catchingsubtitles$specifySource(World world, int x, int y, int z, Random random, CallbackInfo ci) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_AMBIENT_FURNACE);
    }
}
