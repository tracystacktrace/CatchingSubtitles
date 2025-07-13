package net.tracystacktrace.catchingsubtitles.mixins.source.common.block;

import net.minecraft.common.block.children.BlockFenceGate;
import net.minecraft.common.entity.player.EntityPlayer;
import net.minecraft.common.world.World;
import net.tracystacktrace.catchingsubtitles.CatchingSubtitles;
import net.tracystacktrace.catchingsubtitles.subtitle.SubtitleSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockFenceGate.class)
public class MixinBlockFenceGate {
    @Inject(method = "blockActivated", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundForClient(Lnet/minecraft/common/entity/player/EntityPlayer;IDDDI)V"))
    private void catchingsubtitles$specifySource0(World world, int x, int y, int z, EntityPlayer player, CallbackInfoReturnable<Boolean> cir) {
        CatchingSubtitles.SYSTEM.setSource(SubtitleSystem.SOURCE_ACTIVATE_GATE);
    }

    @Inject(method = "onNeighborBlockChange", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundForClient(Lnet/minecraft/common/entity/player/EntityPlayer;IDDDI)V"))
    private void catchingsubtitles$specifySource1(World world, int x, int y, int z, int arg5, CallbackInfo ci) {
        CatchingSubtitles.SYSTEM.setSource(SubtitleSystem.SOURCE_ACTIVATE_GATE);
    }
}
