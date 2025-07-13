package net.tracystacktrace.catchingsubtitles.mixins.source.client;

import net.minecraft.client.player.PlayerControllerSP;
import net.tracystacktrace.catchingsubtitles.subtitle.SourceIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerControllerSP.class)
public class MixinPlayerControllerSP {
    @Inject(method = "sendBlockRemoving", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/sound/SoundManager;playSound(Ljava/lang/String;FFFFF)V"
    ))
    private void catchingsubtitles$injectSourceData4(int x, int y, int z, int facing, CallbackInfo ci) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_BLOCK_BREAKING);
    }
}
