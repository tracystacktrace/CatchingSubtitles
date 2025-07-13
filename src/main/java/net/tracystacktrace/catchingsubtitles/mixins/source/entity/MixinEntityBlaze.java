package net.tracystacktrace.catchingsubtitles.mixins.source.entity;

import net.minecraft.common.entity.monsters.EntityBlaze;
import net.tracystacktrace.catchingsubtitles.subtitle.SourceIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityBlaze.class)
public class MixinEntityBlaze {
    @Inject(method = "onLivingUpdate", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/entity/monsters/EntityMonster;onLivingUpdate()V"))
    private void catchingsubtitles$specifySource(CallbackInfo ci) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_BLAZE_IDLE);
    }
}
