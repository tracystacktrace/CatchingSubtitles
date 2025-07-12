package net.tracystacktrace.catchingsubtitles.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.tracystacktrace.catchingsubtitles.CatchingSubtitles;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiIngame.class)
public class MixinGuiIngame {
    @Shadow
    @Final
    private Minecraft mc;

    @Inject(method = "renderGameOverlay", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/gui/GuiIngame;renderHUD(IIF)V",
            shift = At.Shift.AFTER
    ))
    private void catchingsubtitles$injectRenderer(float deltaTicks, CallbackInfo ci) {
        CatchingSubtitles.SYSTEM.update();
        CatchingSubtitles.RENDERER.render(mc.fontRenderer);
    }
}
