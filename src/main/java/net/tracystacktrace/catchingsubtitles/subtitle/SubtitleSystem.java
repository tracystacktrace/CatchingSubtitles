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
    public static final byte SOURCE_DEFAULT = -128;
    public static final byte SOURCE_INTERFACE = -127; //button clicks, etc
    public static final byte SOURCE_COLLECT_ITEM = -126;
    public static final byte SOURCE_PORTAL_INTERACTION = -125;
    public static final byte SOURCE_CLOUD_BOOTS = -124;
    public static final byte SOURCE_FIRE_EXTINGUISH = -123;
    public static final byte SOURCE_BLOCK_BREAKING = -122;
    public static final byte SOURCE_RAINING = -121;
    public static final byte SOURCE_MIDDLE_CLICK = -120;
    public static final byte SOURCE_AMBIENT_BLASTFURNACE = -119;
    public static final byte SOURCE_ACTIVATE_BUTTON = -118; //like, a real mechanical button
    public static final byte SOURCE_RESTORE_BUTTON = -117; //button returned
    public static final byte SOURCE_AMBIENT_DIMENSIONAL_CHEST = -116;
    public static final byte SOURCE_ACTIVATE_DOOR = -115;
    public static final byte SOURCE_AMBIENT_DUNGEON_CHEST = -114;
    public static final byte SOURCE_ACTIVATE_GATE = -113;
    public static final byte SOURCE_AMBIENT_FIRE = -112;
    public static final byte SOURCE_AMBIENT_FURNACE = -111;
    public static final byte SOURCE_AMBIENT_INCINERATOR = -110;
    public static final byte SOURCE_ACTIVATE_LEVER = -109;
    public static final byte SOURCE_ACTIVATE_NOTE = -108;
    public static final byte SOURCE_ACTIVATE_PISTON = -107;
    public static final byte SOURCE_AMBIENT_PORTAL = -106;
    public static final byte SOURCE_AMBIENT_POTION_FIRE = -105;
    public static final byte SOURCE_ACTIVATE_PLATE = -104;
    public static final byte SOURCE_RESTORE_PLATE = -103;
    public static final byte SOURCE_AMBIENT_REFRIDGEFRIZER = -102;
    public static final byte SOURCE_INTERACT_SLIME = -101;
    public static final byte SOURCE_ACTIVATE_TRAPDOOR = -100;
    public static final byte SOURCE_FLOW_WATER = -99;
    public static final byte SOURCE_FILL_CAULDRON = -98;


    public record BakedSubtitle(String displayString, char directionChar) {
    }

    private final Map<String, ActiveSubtitle> current = new HashMap<>();
    private final Queue<Subtitle> queue = new ConcurrentLinkedQueue<>();
    private byte currentSource = SOURCE_DEFAULT;

    public void setSource(byte source) {
        this.currentSource = source;
    }

    public void addSubtitle(String string) {
        final EntityPlayer player = Minecraft.getInstance().thePlayer;
        if (player != null) {
            addSubtitle(string, player.posX, player.posY, player.posZ);
        }
        this.currentSource = SOURCE_DEFAULT;
    }

    public void addSubtitle(String string, double x, double y, double z) {
        if (CatchingSubtitles.currentScreenPauses()) {
            this.currentSource = SOURCE_DEFAULT;
            return;
        }

        final float distance = (float) DistanceHelper.calculateDistanceFromPlayer(x, y, z);

        if (distance > CatchingSubtitles.CONFIG.maxSoundDistance) {
            this.currentSource = SOURCE_DEFAULT;
            return;
        }

        System.out.println(String.format("Detected \"%s\" with distance %.1f blocks, registering...", string, distance));
        this.queue.add(new Subtitle(string, x, y, z, this.currentSource));
        this.currentSource = SOURCE_DEFAULT;
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
