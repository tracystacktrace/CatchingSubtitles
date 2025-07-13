package net.tracystacktrace.catchingsubtitles.mixins.source.common.block;

import net.minecraft.common.block.children.BlockLever;
import net.minecraft.common.entity.player.EntityPlayer;
import net.minecraft.common.world.World;
import net.tracystacktrace.catchingsubtitles.subtitle.SourceIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockLever.class)
public class MixinBlockLever {
    @Inject(method = "blockActivated", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/world/World;playSoundEffect(DDDLjava/lang/String;FF)V"))
    private void catchingsubtitles$specifySource(World world, int x, int y, int z, EntityPlayer player, CallbackInfoReturnable<Boolean> cir) {
        SourceIdentifier.setSource(SourceIdentifier.SOURCE_ACTIVATE_LEVER);
    }
}
