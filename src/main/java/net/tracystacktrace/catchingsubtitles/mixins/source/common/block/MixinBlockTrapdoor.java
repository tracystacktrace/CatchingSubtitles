package net.tracystacktrace.catchingsubtitles.mixins.source.common.block;

import net.minecraft.common.block.children.BlockTrapdoor;
import net.minecraft.common.entity.player.EntityPlayer;
import net.minecraft.common.world.World;
import net.tracystacktrace.catchingsubtitles.subtitle.SourceIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockTrapdoor.class)
public class MixinBlockTrapdoor {
    @Inject(method = "blockActivated", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundForClient(Lnet/minecraft/common/entity/player/EntityPlayer;IDDDI)V"))
    private void catchingsubtitles$specifySource0(World world, int x, int y, int z, EntityPlayer player, CallbackInfoReturnable<Boolean> cir) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_ACTIVATE_TRAPDOOR);
    }

    @Inject(method = "onPoweredBlockChange", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundForClient(Lnet/minecraft/common/entity/player/EntityPlayer;IDDDI)V"))
    private void catchingsubtitles$specifySource1(World world, int x, int y, int z, boolean arg5, CallbackInfo ci) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_ACTIVATE_TRAPDOOR);
    }
}
