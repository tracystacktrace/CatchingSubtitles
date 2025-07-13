package net.tracystacktrace.catchingsubtitles.mixins.source.client;

import net.minecraft.client.player.PlayerControllerMP;
import net.tracystacktrace.catchingsubtitles.CatchingSubtitles;
import net.tracystacktrace.catchingsubtitles.subtitle.SubtitleSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerControllerMP.class)
public class MixinPlayerControllerMP {
    @Inject(method = "sendBlockRemoving", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/sound/SoundManager;playSound(Ljava/lang/String;FFFFF)V"
    ))
    private void catchingsubtitles$injectSourceData5(int x, int y, int z, int facing, CallbackInfo ci) {
        CatchingSubtitles.SYSTEM.setSource(SubtitleSystem.SOURCE_BLOCK_BREAKING);
    }
}
