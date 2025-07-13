package net.tracystacktrace.catchingsubtitles.mixins.source.client;

import net.minecraft.client.Minecraft;
import net.tracystacktrace.catchingsubtitles.subtitle.SourceIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Inject(method = "clickMiddleMouseButton", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundAtEntity(Lnet/minecraft/common/entity/Entity;Ljava/lang/String;FF)V"
    ))
    private void catchingsubtitles$injectSourceData7(CallbackInfo ci) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_MIDDLE_CLICK);
    }
}
