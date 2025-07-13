package net.tracystacktrace.catchingsubtitles.helper;

import net.tracystacktrace.catchingsubtitles.subtitle.SourceIdentifier;
import org.jetbrains.annotations.NotNull;

public final class FoxStatusSource {
    public static void setFoxSoundSource(@NotNull String source) {
        switch (source) {
            case "mob.fox.sleep" -> {
                SourceIdentifier.setSource(SourceIdentifier.SOURCE_FOX_SLEEP);
                return;
            }
            case "mob.fox.aggro" -> {
                SourceIdentifier.setSource(SourceIdentifier.SOURCE_FOX_AGGRESSIVE);
                return;
            }
            case "mob.fox.whine" -> {
                SourceIdentifier.setSource(SourceIdentifier.SOURCE_FOX_WHINE);
                return;
            }
            case "mob.fox.idle" -> {
                SourceIdentifier.setSource(SourceIdentifier.SOURCE_FOX_IDLE);
                return;
            }
        }
    }

    public static void setWolfSoundSource(@NotNull String source) {
        switch (source) {
            case "mob.wolf.growl" -> {
                SourceIdentifier.setSource(SourceIdentifier.SOURCE_WOLF_AGGRESSIVE);
                return;
            }
            case "mob.wolf.bark" -> {
                SourceIdentifier.setSource(SourceIdentifier.SOURCE_WOLF_BARK);
                return;
            }
            case "mob.wolf.whine" -> {
                SourceIdentifier.setSource(SourceIdentifier.SOURCE_WOLF_WHINE);
                return;
            }
            case "mob.wolf.panting" -> {
                SourceIdentifier.setSource(SourceIdentifier.SOURCE_WOLF_PANTING);
                return;
            }
        }
    }
}
