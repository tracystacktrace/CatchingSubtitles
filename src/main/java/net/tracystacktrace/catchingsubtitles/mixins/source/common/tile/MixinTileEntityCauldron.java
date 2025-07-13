package net.tracystacktrace.catchingsubtitles.mixins.source.common.tile;

import net.minecraft.common.block.tileentity.TileEntityCauldron;
import net.minecraft.common.entity.player.EntityPlayer;
import net.minecraft.common.item.ItemStack;
import net.minecraft.common.world.World;
import net.tracystacktrace.catchingsubtitles.CatchingSubtitles;
import net.tracystacktrace.catchingsubtitles.subtitle.SubtitleSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TileEntityCauldron.class)
public class MixinTileEntityCauldron {
    @Inject(method = "fillCauldron(Lnet/minecraft/common/world/World;Lnet/minecraft/common/entity/player/EntityPlayer;Lnet/minecraft/common/item/ItemStack;)Z", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/common/block/tileentity/TileEntityCauldron;playSoundFX(Lnet/minecraft/common/world/World;I)V"))
    private void catchingsubtitles$specifySource(World world, EntityPlayer player, ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
        CatchingSubtitles.SYSTEM.setSource(SubtitleSystem.SOURCE_FILL_CAULDRON);
    }
}
