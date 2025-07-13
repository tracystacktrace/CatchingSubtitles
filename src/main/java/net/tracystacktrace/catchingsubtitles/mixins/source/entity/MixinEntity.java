package net.tracystacktrace.catchingsubtitles.mixins.source.entity;

import net.minecraft.common.entity.Entity;
import net.tracystacktrace.catchingsubtitles.subtitle.SourceIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class MixinEntity {
    @Inject(method = "onEntityUpdate", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundAtEntity(Lnet/minecraft/common/entity/Entity;Ljava/lang/String;FF)V"))
    private void catchingsubtitles$specifySource0(CallbackInfo ci) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_ENTITY_WATER_SPLASH);
    }

    @Inject(method = "moveEntity", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/entity/Entity;playSound(Ljava/lang/String;FF)V"))
    private void catchingsubtitles$specifySource1(double x, double y, double z, CallbackInfo ci) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_ENTITY_SWIM);
    }

    @Inject(method = "moveEntity", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundAtEntity(Lnet/minecraft/common/entity/Entity;Ljava/lang/String;FF)V"))
    private void catchingsubtitles$specifySource2(double x, double y, double z, CallbackInfo ci) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_ENTITY_EXTINGUISHED);
    }

    @Inject(method = "playStepSound", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundFromEntityMultiplayer(Lnet/minecraft/common/entity/Entity;Ljava/lang/String;FF)V"))
    private void catchingsubtitles$specifySource3(int x, int y, int z, int id, CallbackInfo ci) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_ENTITY_WALK);
    }
}
