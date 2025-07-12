package net.tracystacktrace.catchingsubtitles.subtitle;

import net.minecraft.client.Minecraft;
import net.minecraft.common.entity.player.EntityPlayer;
import net.tracystacktrace.catchingsubtitles.CatchingSubtitles;
import net.tracystacktrace.catchingsubtitles.tools.DistanceHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SubtitleSystem {
    public record BakedSubtitle(String displayString, char directionChar) {
    }

    private final Map<String, ActiveSubtitle> current = new HashMap<>();
    private final Queue<Subtitle> queue = new ConcurrentLinkedQueue<>();

    public void addSubtitle(String string) {
        final EntityPlayer player = Minecraft.getInstance().thePlayer;
        if (player != null) {
            addSubtitle(string, player.posX, player.posY, player.posZ);
        }
    }

    public void addSubtitle(String string, double x, double y, double z) {
        if (CatchingSubtitles.currentScreenPauses()) {
            return;
        }

        final float distance = (float) DistanceHelper.calculateDistanceFromPlayer(x, y, z);

        if (distance > CatchingSubtitles.CONFIG.maxSoundDistance) {
            return;
        }

        System.out.println(String.format("Detected \"%s\" with distance %.1f blocks, registering...", string, distance));
        this.queue.add(new Subtitle(string, x, y, z));
    }

    public void update() {
        long currentTime = System.currentTimeMillis();

        this.current.entrySet().removeIf(e -> e.getValue().isExpired(currentTime));

        while (!this.queue.isEmpty() && this.current.size() < CatchingSubtitles.CONFIG.maxUniqueSubtitles) {
            final Subtitle next = this.queue.poll();
            this.current.put(next.identifier, new ActiveSubtitle(next, currentTime));
        }
    }

    public BakedSubtitle[] getCurrentSubtitles() {
        if (current.isEmpty()) {
            return null;
        }
        final BakedSubtitle[] result = new BakedSubtitle[current.size()];
        int index = result.length - 1;
        for (ActiveSubtitle subtitle : this.current.values()) {
            result[index--] = new BakedSubtitle(subtitle.getDisplayString(), CatchingSubtitles.getDirectionChar(subtitle.getDirection()));
        }
        return result;
    }

    public void clear() {
        this.queue.clear();
        this.current.clear();
    }
}
