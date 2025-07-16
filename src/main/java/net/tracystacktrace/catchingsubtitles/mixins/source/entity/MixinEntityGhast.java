package net.tracystacktrace.catchingsubtitles.mixins.source.entity;

import net.minecraft.common.entity.Entity;
import net.minecraft.common.entity.monsters.EntityGhast;
import net.minecraft.common.world.World;
import net.tracystacktrace.catchingsubtitles.subtitle.SourceIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityGhast.class)
public class MixinEntityGhast {
    @Redirect(method = "updatePlayerActionState", at = @At(value = "INVOKE", target = "Lnet/minecraft/common/world/World;playSoundAtEntity(Lnet/minecraft/common/entity/Entity;Ljava/lang/String;FF)V"))
    private void catchingsubtitles$specifySource0(World instance, Entity entity, String sound, float volume, float pitch) {
        if(sound.equals("mob.ghast.charge")) {
            SourceIdentifier.setSource(SourceIdentifier.SOURCE_GHAST_CHARGE);
        } else {
            SourceIdentifier.setSource(SourceIdentifier.SOURCE_GHAST_FIREBALL);
        }

        instance.playSoundAtEntity(entity, sound, volume, pitch);
    }

    @Inject(method = "getLivingSound", at = @At("HEAD"))
    private void catchingsubtitles$specifySource1(CallbackInfoReturnable<String> cir) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_GHAST_IDLE);
    }

    @Inject(method = "getHurtSound", at = @At("HEAD"))
    private void catchingsubtitles$specifySource2(CallbackInfoReturnable<String> cir) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_GHAST_HURT);
    }

    @Inject(method = "getDeathSound", at = @At("HEAD"))
    private void catchingsubtitles$specifySource3(CallbackInfoReturnable<String> cir) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_GHAST_DEATH);
    }
}
