package net.tracystacktrace.catchingsubtitles.mixins.source.entity;

import net.minecraft.common.entity.monsters.EntityStroldian;
import net.tracystacktrace.catchingsubtitles.subtitle.SourceIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityStroldian.class)
public class MixinEntityStroldian {
    @Inject(method = "onLivingUpdate", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundAtEntity(Lnet/minecraft/common/entity/Entity;Ljava/lang/String;FF)V"))
    private void catchingsubtitles$specifySource0(CallbackInfo ci) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_STROLDIAN_IDLE);
    }

    @Inject(method = "getLivingSound", at = @At("HEAD"))
    private void catchingsubtitles$specifySource1(CallbackInfoReturnable<String> cir) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_STROLDIAN_IDLE);
    }

    @Inject(method = "getHurtSound", at = @At("HEAD"))
    private void catchingsubtitles$specifySource2(CallbackInfoReturnable<String> cir) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_STROLDIAN_HURT);
    }

    @Inject(method = "getDeathSound", at = @At("HEAD"))
    private void catchingsubtitles$specifySource3(CallbackInfoReturnable<String> cir) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_STROLDIAN_DEATH);
    }
}
