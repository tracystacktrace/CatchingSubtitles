package net.tracystacktrace.catchingsubtitles.mixins.source.entity;

import net.minecraft.common.entity.monsters.EntitySlime;
import net.minecraft.common.entity.player.EntityPlayer;
import net.tracystacktrace.catchingsubtitles.subtitle.SourceIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntitySlime.class)
public class MixinEntitySlime {
    @Inject(method = "updatePlayerActionState", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundAtEntity(Lnet/minecraft/common/entity/Entity;Ljava/lang/String;FF)V"))
    private void catchingsubtitles$specifySource0(CallbackInfo ci) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_SLIME_JUMP);
    }

    @Inject(method = "onCollideWithPlayer", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundAtEntity(Lnet/minecraft/common/entity/Entity;Ljava/lang/String;FF)V"))
    private void catchingsubtitles$specifySource1(EntityPlayer player, CallbackInfo ci) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_SLIME_ATTACK);
    }

    @Inject(method = "getHurtSound", at = @At("HEAD"))
    private void catchingsubtitles$specifySource2(CallbackInfoReturnable<String> cir) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_SLIME_HURT);
    }

    @Inject(method = "getDeathSound", at = @At("HEAD"))
    private void catchingsubtitles$specifySource3(CallbackInfoReturnable<String> cir) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_SLIME_DEATH);
    }
}
