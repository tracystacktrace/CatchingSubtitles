package net.tracystacktrace.catchingsubtitles.subtitle;

import net.tracystacktrace.catchingsubtitles.CatchingSubtitles;

public final class SourceIdentifier {
    /* ----- Unspecified Sources ----- */
    public static final byte SOURCE_DEFAULT = -128;
    public static final byte SOURCE_INTERFACE = -127; //button clicks, etc
    public static final byte SOURCE_COLLECT_ITEM = -126;
    public static final byte SOURCE_CLOUD_BOOTS = -124;
    public static final byte SOURCE_MIDDLE_CLICK = -120;

    /* ----- Ambient Sources ----- */
    public static final byte SOURCE_AMBIENT_RAIN = -121;
    public static final byte SOURCE_AMBIENT_BLASTFURNACE = -119;
    public static final byte SOURCE_AMBIENT_REFRIDGEFRIZER = -102;
    public static final byte SOURCE_AMBIENT_DIMENSIONAL_CHEST = -116;
    public static final byte SOURCE_AMBIENT_DUNGEON_CHEST = -114;
    public static final byte SOURCE_AMBIENT_FIRE = -112;
    public static final byte SOURCE_AMBIENT_FURNACE = -111;
    public static final byte SOURCE_AMBIENT_INCINERATOR = -110;
    public static final byte SOURCE_AMBIENT_PORTAL = -106;
    public static final byte SOURCE_AMBIENT_POTION_FIRE = -105;

    /* ----- Restoring (Unclick) Sources ----- */
    public static final byte SOURCE_RESTORE_PLATE = -103;
    public static final byte SOURCE_RESTORE_BUTTON = -117;

    /* ----- Activation Sources ----- */
    public static final byte SOURCE_ACTIVATE_PORTAL = -125;
    public static final byte SOURCE_ACTIVATE_BUTTON = -118; //like, a real mechanical button
    public static final byte SOURCE_ACTIVATE_DOOR = -115; //button returned
    public static final byte SOURCE_ACTIVATE_GATE = -113;
    public static final byte SOURCE_ACTIVATE_LEVER = -109;
    public static final byte SOURCE_ACTIVATE_NOTE = -108;
    public static final byte SOURCE_ACTIVATE_PISTON = -107;
    public static final byte SOURCE_ACTIVATE_PLATE = -104;
    public static final byte SOURCE_ACTIVATE_TRAPDOOR = -100;

    /* ----- Unspecified Block Sources ----- */
    public static final byte SOURCE_INTERACT_SLIME = -101;
    public static final byte SOURCE_FIRE_EXTINGUISH = -123;
    public static final byte SOURCE_BLOCK_BREAKING = -122;
    public static final byte SOURCE_FLOW_WATER = -99;
    public static final byte SOURCE_FILL_CAULDRON = -98;


    public static void setSource(byte code) {
        CatchingSubtitles.SYSTEM.setSource(code);
    }

    private SourceIdentifier() {
    }
}
