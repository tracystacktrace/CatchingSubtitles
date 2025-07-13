package net.tracystacktrace.catchingsubtitles.client;

import com.fox2code.foxloader.config.ConfigEntry;

public final class CatchingSubtitlesConfig {
    @ConfigEntry(configComment = "Show subtitles")
    public boolean showSubtitles = true;

    @ConfigEntry(configComment = "Show distance of a sound")
    public boolean showDistance = true;

    @ConfigEntry(
            configComment = "Max distance of sound (in blocks)",
            lowerBounds = 4,
            upperBounds = 512
    )
    public int maxSoundDistance = 256;

    @ConfigEntry(
            configComment = "Max unique subtitles",
            lowerBounds = 3,
            upperBounds = 32
    )
    public int maxUniqueSubtitles = 12;

    @ConfigEntry(
            configComment = "Subtitles Duration (sec)",
            lowerBounds = 1,
            upperBounds = 10
    )
    public int subtitlesDuration = 5;
}
