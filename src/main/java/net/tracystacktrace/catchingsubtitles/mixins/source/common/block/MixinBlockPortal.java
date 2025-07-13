package net.tracystacktrace.catchingsubtitles.mixins.source.common.block;

import net.minecraft.common.block.children.BlockPortal;
import net.minecraft.common.world.World;
import net.tracystacktrace.catchingsubtitles.CatchingSubtitles;
import net.tracystacktrace.catchingsubtitles.subtitle.SubtitleSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(BlockPortal.class)
public class MixinBlockPortal {
    @Inject(method = "randomDisplayTick", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundEffect(DDDLjava/lang/String;FF)V"))
    private void catchingsubtitles$specifySource(World world, int x, int y, int z, Random random, CallbackInfo ci) {
        CatchingSubtitles.SYSTEM.setSource(SubtitleSystem.SOURCE_AMBIENT_PORTAL);
    }
}
