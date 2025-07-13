package net.tracystacktrace.catchingsubtitles.mixins.source.common.block;

import net.minecraft.common.block.children.BlockSlime;
import net.minecraft.common.entity.Entity;
import net.minecraft.common.world.World;
import net.tracystacktrace.catchingsubtitles.subtitle.SourceIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockSlime.class)
public class MixinBlockSlime {
    @Inject(method = "onFallenUpon", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundAtEntity(Lnet/minecraft/common/entity/Entity;Ljava/lang/String;FF)V"))
    private void catchingsubtitles$specifySource(World world, int x, int y, int z, Entity entity, float fallDistance, CallbackInfo ci) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_INTERACT_SLIME);
    }
}
