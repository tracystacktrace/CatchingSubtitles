package net.tracystacktrace.catchingsubtitles.mixins.source.entity;

import net.minecraft.common.entity.animals.EntityFox;
import net.tracystacktrace.catchingsubtitles.helper.FoxStatusSource;
import net.tracystacktrace.catchingsubtitles.subtitle.SourceIdentifier;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityFox.class)
public class MixinEntityFox {
    @Inject(method = "onUpdate", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundAtEntity(Lnet/minecraft/common/entity/Entity;Ljava/lang/String;FF)V"))
    private void catchingsubtitles$specifySource0(CallbackInfo ci) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_FOX_SHAKE);
    }

    @Inject(method = "getLivingSound", at = @At("RETURN"))
    private void catchingsubtitles$specifySource1(CallbackInfoReturnable<String> cir) {
        FoxStatusSource.setFoxSoundSource(cir.getReturnValue());
    }

    @Inject(method = "getHurtSound", at = @At("RETURN"))
    private void catchingsubtitles$specifySource2(CallbackInfoReturnable<String> cir) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_FOX_HURT);
    }

    @Inject(method = "getDeathSound", at = @At("RETURN"))
    private void catchingsubtitles$specifySource3(CallbackInfoReturnable<String> cir) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_FOX_DEATH);
    }
}
