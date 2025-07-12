package net.tracystacktrace.catchingsubtitles.subtitle;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Subtitle {
    public final String identifier;
    public final double x;
    public final double y;
    public final double z;

    public Subtitle(@NotNull String identifier, double x, double y, double z) {
        this.identifier = identifier;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Subtitle subtitle = (Subtitle) o;
        return Double.compare(x, subtitle.x) == 0 &&
                Double.compare(y, subtitle.y) == 0 &&
                Double.compare(z, subtitle.z) == 0 &&
                Objects.equals(identifier, subtitle.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, x, y, z);
    }
}
