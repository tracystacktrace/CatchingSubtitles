package net.tracystacktrace.catchingsubtitles.mixins.source.common.block;

import net.minecraft.common.block.children.BlockDoor;
import net.minecraft.common.entity.player.EntityPlayer;
import net.minecraft.common.world.World;
import net.tracystacktrace.catchingsubtitles.CatchingSubtitles;
import net.tracystacktrace.catchingsubtitles.subtitle.SubtitleSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockDoor.class)
public class MixinBlockDoor {
    @Inject(method = "blockActivated", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundForClient(Lnet/minecraft/common/entity/player/EntityPlayer;IDDDI)V"))
    private void catchingsubtitles$specifySource0(World world, int x, int y, int z, EntityPlayer player, CallbackInfoReturnable<Boolean> cir) {
        CatchingSubtitles.SYSTEM.setSource(SubtitleSystem.SOURCE_ACTIVATE_DOOR);
    }

    @Inject(method = "onPoweredBlockChange", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundForClient(Lnet/minecraft/common/entity/player/EntityPlayer;IDDDI)V"))
    private void catchingsubtitles$specifySource1(World world, int x, int y, int z, boolean powered, CallbackInfo ci) {
        CatchingSubtitles.SYSTEM.setSource(SubtitleSystem.SOURCE_ACTIVATE_DOOR);
    }
}
