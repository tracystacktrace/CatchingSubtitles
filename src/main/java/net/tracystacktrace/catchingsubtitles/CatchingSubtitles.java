package net.tracystacktrace.catchingsubtitles;

import com.fox2code.foxloader.loader.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.tracystacktrace.catchingsubtitles.client.CatchingSubtitlesConfig;
import net.tracystacktrace.catchingsubtitles.client.SubtitleRenderer;
import net.tracystacktrace.catchingsubtitles.subtitle.SourceIdentifier;
import net.tracystacktrace.catchingsubtitles.subtitle.SubtitleSystem;
import net.tracystacktrace.catchingsubtitles.tools.SoundSourcePosition;
import org.jetbrains.annotations.NotNull;

public class CatchingSubtitles extends Mod {
    public static final CatchingSubtitlesConfig CONFIG = new CatchingSubtitlesConfig();
    public static final SubtitleSystem SYSTEM = new SubtitleSystem();
    public static final SubtitleRenderer RENDERER = new SubtitleRenderer();

    @Override
    public void onPreInit() {
        this.setConfigObject(CONFIG);
    }

    public static byte getDirectionCharWidth(char c) {
        return switch (c) {
            case '↑', '↓' -> 6;
            case '←', '→', '⚠', '⏼' -> 8;
            default -> 4; //space
        };
    }

    public static char getDirectionChar(byte direction) {
        return switch (direction) {
            case SoundSourcePosition.UNKNOWN -> '⚠';
            case SoundSourcePosition.SAME_POSITION -> '⏼';
            case SoundSourcePosition.FRONT -> '↑';
            case SoundSourcePosition.BEHIND -> '↓';
            case SoundSourcePosition.LEFT -> '←';
            case SoundSourcePosition.RIGHT -> '→';
            default -> ' '; //space
        };
    }

    public static boolean currentScreenPauses() {
        final GuiScreen screen = Minecraft.getInstance().currentScreen;
        return screen != null && screen.doesGuiPauseGame();
    }
}
