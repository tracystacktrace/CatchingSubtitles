package net.tracystacktrace.catchingsubtitles.mixins.source.client;

import net.minecraft.client.networking.NetClientHandler;
import net.minecraft.common.networking.Packet22Collect;
import net.tracystacktrace.catchingsubtitles.CatchingSubtitles;
import net.tracystacktrace.catchingsubtitles.subtitle.SubtitleSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetClientHandler.class)
public class MixinNetClientHandler {
    @Inject(method = "handleCollect", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/world/WorldClient;playSoundAtEntity(Lnet/minecraft/common/entity/Entity;Ljava/lang/String;FF)V"
    ))
    private void catchingsubtitles$injectSourceData0(Packet22Collect packet22, CallbackInfo ci) {
        CatchingSubtitles.SYSTEM.setSource(SubtitleSystem.SOURCE_COLLECT_ITEM);
    }
}
