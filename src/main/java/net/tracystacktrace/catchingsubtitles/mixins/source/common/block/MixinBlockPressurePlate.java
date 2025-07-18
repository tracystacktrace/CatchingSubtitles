package net.tracystacktrace.catchingsubtitles.mixins.source.common.block;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.common.block.children.BlockPressurePlate;
import net.minecraft.common.world.World;
import net.tracystacktrace.catchingsubtitles.subtitle.SourceIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockPressurePlate.class)
public class MixinBlockPressurePlate {
    @Inject(method = "setStateIfMobInteractsWithPlate", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundEffect(DDDLjava/lang/String;FF)V"))
    private void catchingsubtitles$specifySource(
            World world, int x, int y, int z,
            CallbackInfo ci,
            @Local(name = "powered") boolean powered,
            @Local(name = "triggered") boolean triggered
    ) {
        SourceIdentifier.setSource(
                triggered && !powered ? SourceIdentifier.SOURCE_ACTIVATE_PLATE : SourceIdentifier.SOURCE_RESTORE_PLATE
        );
    }
}
