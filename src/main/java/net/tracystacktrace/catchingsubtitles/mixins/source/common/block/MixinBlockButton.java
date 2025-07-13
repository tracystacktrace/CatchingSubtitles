package net.tracystacktrace.catchingsubtitles.mixins.source.common.block;

import net.minecraft.common.block.children.BlockButton;
import net.minecraft.common.entity.player.EntityPlayer;
import net.minecraft.common.world.World;
import net.tracystacktrace.catchingsubtitles.subtitle.SourceIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(BlockButton.class)
public class MixinBlockButton {
    @Inject(method = "blockActivated", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundEffect(DDDLjava/lang/String;FF)V"))
    private void catchingsubtitles$specifySource0(World world, int x, int y, int z, EntityPlayer player, CallbackInfoReturnable<Boolean> cir) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_ACTIVATE_BUTTON);
    }

    @Inject(method = "updateTick", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundEffect(DDDLjava/lang/String;FF)V"))
    private void catchingsubtitles$specifySource1(World world, int x, int y, int z, Random random, CallbackInfo ci) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_RESTORE_BUTTON);
    }
}
