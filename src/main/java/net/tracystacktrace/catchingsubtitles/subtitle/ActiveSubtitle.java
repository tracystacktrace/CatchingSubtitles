package net.tracystacktrace.catchingsubtitles.subtitle;

import net.tracystacktrace.catchingsubtitles.CatchingSubtitles;
import net.tracystacktrace.catchingsubtitles.tools.DistanceHelper;
import net.tracystacktrace.catchingsubtitles.tools.SoundSourcePosition;
import org.jetbrains.annotations.NotNull;

public class ActiveSubtitle extends Subtitle {
    public final long captureTime;

    public ActiveSubtitle(@NotNull Subtitle subtitle, long captureTime) {
        super(subtitle.identifier, subtitle.x, subtitle.y, subtitle.z);
        this.captureTime = captureTime;
    }

    public boolean isExpired(long current) {
        return current - this.captureTime > 5000;
    }

    public String getDisplayString() {
        return CatchingSubtitles.CONFIG.showDistance ? String.format("§e%s §b%.1f§r", this.identifier, this.getDistance()) : String.format("§e%s", this.identifier);
    }

    public byte getDirection() {
        return SoundSourcePosition.getSoundDirection(this.x, this.z);
    }

    public double getDistance() {
        return DistanceHelper.calculateDistanceFromPlayer(this.x, this.y, this.z);
    }
}
