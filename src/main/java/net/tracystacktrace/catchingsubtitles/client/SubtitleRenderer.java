package net.tracystacktrace.catchingsubtitles.client;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.tracystacktrace.catchingsubtitles.CatchingSubtitles;
import net.tracystacktrace.catchingsubtitles.subtitle.SubtitleSystem;
import org.jetbrains.annotations.NotNull;

public class SubtitleRenderer extends Gui {

    public void render(@NotNull FontRenderer fontRenderer) {
        final SubtitleSystem.BakedSubtitle[] data = CatchingSubtitles.SYSTEM.getCurrentSubtitles();

        if (data == null || !CatchingSubtitles.CONFIG.showSubtitles) {
            return;
        }

        final int width = this.getLargestString(fontRenderer, data) + 8;
        final int height = 10 * data.length;

        final ScaledResolution resolution = ScaledResolution.instance;

        final int offsetX = resolution.getScaledWidth() - width;
        final int offsetY = resolution.getScaledHeight() - height - 12;

        //draw rect
        drawRect(offsetX, offsetY - 1, offsetX + width, offsetY + height, -2147483648);

        for (int i = 0; i < data.length; i++) {
            final int startY = offsetY + (i * 10);

            //draw signal chars
            final char signal = data[i].directionChar();
            fontRenderer.drawStringWithShadow(String.valueOf(signal), offsetX, startY, 0xFFFFFFFF);
            fontRenderer.drawStringWithShadow(String.valueOf(signal), offsetX + width - CatchingSubtitles.getDirectionCharWidth(signal), startY, 0xFFFFFFFF);

            //draw main string
            final String show = data[i].displayString();
            fontRenderer.drawStringWithShadow(show, offsetX + (width / 2) - fontRenderer.getStringWidth(show) / 2, startY, 0xFFFFFFFF);
        }
    }

    private int getLargestString(
            @NotNull FontRenderer fontRenderer,
            @NotNull SubtitleSystem.BakedSubtitle @NotNull [] data
    ) {
        int b = 0;
        for (SubtitleSystem.BakedSubtitle datum : data) {
            b = Math.max(b, fontRenderer.getStringWidth(datum.displayString()) + 2 * CatchingSubtitles.getDirectionCharWidth(datum.directionChar()));
        }
        return b;
    }
}
