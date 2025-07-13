package net.tracystacktrace.catchingsubtitles.mixins.source.client;

import net.minecraft.client.player.PlayerController;
import net.minecraft.common.entity.player.EntityPlayer;
import net.minecraft.common.world.World;
import net.tracystacktrace.catchingsubtitles.CatchingSubtitles;
import net.tracystacktrace.catchingsubtitles.subtitle.SubtitleSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerController.class)
public class MixinPlayerController {
    @Inject(method = "extinguishFire", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundForClient(Lnet/minecraft/common/entity/player/EntityPlayer;IDDDI)V"
    ))
    private static void catchingsubtitles$injectSourceData3(EntityPlayer thePlayer, int xCoord, int yCoord, int zCoord, int blockFace, World world, CallbackInfoReturnable<Boolean> cir) {
        CatchingSubtitles.SYSTEM.setSource(SubtitleSystem.SOURCE_FIRE_EXTINGUISH);
    }
}
