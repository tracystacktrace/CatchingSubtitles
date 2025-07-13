package net.tracystacktrace.catchingsubtitles.mixins.source.entity;

import net.minecraft.common.entity.Entity;
import net.minecraft.common.entity.EntityLiving;
import net.minecraft.common.world.World;
import net.tracystacktrace.catchingsubtitles.subtitle.SourceIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityLiving.class)
public abstract class MixinEntityLiving {
    @Shadow protected abstract float getSoundPitch();

    @Inject(method = "fall", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundFromEntityMultiplayer(Lnet/minecraft/common/entity/Entity;Ljava/lang/String;FF)V"))
    private void catchingsubtitles$specifySource0(float distance, CallbackInfo ci) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_ENTITY_FALL);
    }

    @Redirect(method = "attackEntityFrom", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundAtEntity(Lnet/minecraft/common/entity/Entity;Ljava/lang/String;FF)V"))
    private void catchingsubtitles$specifySource1(World instance, Entity entity, String sound, float volume, float pitch) {
        if(sound.equals("randon.fizz") && pitch == getSoundPitch() * 1.5F) {
            SourceIdentifier.setSource(SourceIdentifier.SOURCE_ENTITY_BURN);
        }
        instance.playSoundAtEntity(entity, sound, volume, pitch);
    }
}
