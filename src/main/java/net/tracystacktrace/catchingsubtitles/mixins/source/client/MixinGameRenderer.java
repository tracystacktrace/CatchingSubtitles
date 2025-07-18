package net.tracystacktrace.catchingsubtitles.mixins.source.client;

import net.minecraft.client.renderer.world.GameRenderer;
import net.tracystacktrace.catchingsubtitles.subtitle.SourceIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class MixinGameRenderer {
    @Inject(method = "addRainParticles", at = @At(value = "INVOKE", target = "Lnet/minecraft/common/world/World;playSoundEffect(DDDLjava/lang/String;FF)V"))
    private void catchingsubtitles$injectSourceData6(CallbackInfo ci) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_AMBIENT_RAIN);
    }

}
