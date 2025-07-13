package net.tracystacktrace.catchingsubtitles.mixins.source.client;

import net.minecraft.client.player.EntityPlayerSP;
import net.tracystacktrace.catchingsubtitles.subtitle.SourceIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayerSP.class)
public class MixinEntityPlayerSP {

    @Inject(method = "onLivingUpdate", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/sound/SoundManager;playSoundFX(Ljava/lang/String;FF)V"
    ))
    private void catchingsubtitles$injectSourceData1(CallbackInfo ci) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_PORTAL_INTERACTION);
    }

    @Inject(method = "tickCloudBoots", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundAtEntity(Lnet/minecraft/common/entity/Entity;Ljava/lang/String;FF)V"
    ))
    private void catchingsubtitles$injectSourceData2(CallbackInfo ci) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_CLOUD_BOOTS);
    }

}
