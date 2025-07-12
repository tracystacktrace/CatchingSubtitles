package net.tracystacktrace.catchingsubtitles.mixins;

import net.minecraft.client.sound.SoundManager;
import net.tracystacktrace.catchingsubtitles.CatchingSubtitles;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SoundManager.class)
public class MixinSoundManager {

    @Inject(method = "playSound", at = @At(
            value = "INVOKE",
            target = "Lpaulscode/sound/SoundSystem;play(Ljava/lang/String;)V",
            shift = At.Shift.AFTER
    ))
    private void catchingsubtitles$inject_0(String arg1, float arg2, float arg3, float arg4, float arg5, float arg6, CallbackInfo ci) {
        CatchingSubtitles.SYSTEM.addSubtitle(arg1, arg2, arg3, arg4);
    }

    @Inject(method = "playSoundFX", at = @At(
            value = "INVOKE",
            target = "Lpaulscode/sound/SoundSystem;play(Ljava/lang/String;)V",
            shift = At.Shift.AFTER
    ))
    private void catchingsubtitles$inject_1(String arg1, float arg2, float arg3, CallbackInfo ci) {
        CatchingSubtitles.SYSTEM.addSubtitle(arg1);
    }

}
