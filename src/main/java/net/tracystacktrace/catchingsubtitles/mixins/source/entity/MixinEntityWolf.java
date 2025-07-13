package net.tracystacktrace.catchingsubtitles.mixins.source.entity;

import net.minecraft.common.entity.animals.EntityWolf;
import net.tracystacktrace.catchingsubtitles.subtitle.SourceIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityWolf.class)
public class MixinEntityWolf {
    @Inject(method = "onUpdate", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundAtEntity(Lnet/minecraft/common/entity/Entity;Ljava/lang/String;FF)V"))
    private void catchingsubtitles$specifySource(CallbackInfo ci) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_WOLF_SHAKE);
    }
}
