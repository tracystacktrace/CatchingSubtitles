package net.tracystacktrace.catchingsubtitles.subtitle;

import net.tracystacktrace.catchingsubtitles.CatchingSubtitles;
import org.jetbrains.annotations.NotNull;

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

    /* ----- Entity Sources ----- */
    public static final byte SOURCE_CHICKEN_EGGDROP = -97;
    public static final byte SOURCE_FOX_SHAKE = -96;
    public static final byte SOURCE_FOX_CONSUMES = -95;
    public static final byte SOURCE_WASP_BUZZ = -94;
    public static final byte SOURCE_WOLF_SHAKE = -93;


    public static void setSource(byte code) {
        CatchingSubtitles.SYSTEM.setSource(code);
    }

    public static @NotNull String getSourceName(byte source, @NotNull String identifier) {
        return switch (source) {
            case SOURCE_DEFAULT -> String.format("Undefined: %s", identifier);
            case SOURCE_INTERFACE -> "Button Click";
            case SOURCE_COLLECT_ITEM -> "Item Collected";
            case SOURCE_ACTIVATE_PORTAL ->
                    identifier.equals("portal.trigger") ? "Portal Triggered" : "Portal Activation";
            case SOURCE_CLOUD_BOOTS -> "Cloud Boots Dash";
            case SOURCE_FIRE_EXTINGUISH -> "Fire Extinguished";
            case SOURCE_BLOCK_BREAKING -> String.format("Block breaking: %s", identifier);
            case SOURCE_AMBIENT_RAIN -> "Rain Sounds";
            case SOURCE_MIDDLE_CLICK -> "Middle Mouse Click";
            case SOURCE_AMBIENT_BLASTFURNACE -> "Blast Furnace Ambient";
            case SOURCE_ACTIVATE_BUTTON -> "Button Clicked";
            case SOURCE_RESTORE_BUTTON -> "Button Unclicked";
            case SOURCE_AMBIENT_DIMENSIONAL_CHEST -> "Dimensional Chest Ambient";
            case SOURCE_ACTIVATE_DOOR -> "Door Activated";
            case SOURCE_AMBIENT_DUNGEON_CHEST -> "Dungeon Chest Ambient";
            case SOURCE_ACTIVATE_GATE -> "Fence Gate Activated";
            case SOURCE_AMBIENT_FIRE -> "Fire Ambient";
            case SOURCE_AMBIENT_FURNACE -> "Furnace Ambient";
            case SOURCE_AMBIENT_INCINERATOR -> "Incinerator Ambient";
            case SOURCE_ACTIVATE_LEVER -> "Lever Activated";
            case SOURCE_ACTIVATE_NOTE -> "Note Block Played";
            case SOURCE_ACTIVATE_PISTON ->
                    identifier.equals("tile.piston.out") ? "Piston Deactivated" : "Piston Activated";
            case SOURCE_AMBIENT_PORTAL -> "Portal Ambient";
            case SOURCE_AMBIENT_POTION_FIRE -> "Potion Fire Ambient";
            case SOURCE_ACTIVATE_PLATE -> "Plate Stepped On";
            case SOURCE_RESTORE_PLATE -> "Plate Restored";
            case SOURCE_AMBIENT_REFRIDGEFRIZER -> "Refridgefrizer Activated";
            case SOURCE_INTERACT_SLIME -> "Slime Squished";
            case SOURCE_ACTIVATE_TRAPDOOR -> "Trapdoor Activated";
            case SOURCE_FLOW_WATER -> "Water Flowing";
            case SOURCE_FILL_CAULDRON -> "Cauldron Filled";
            case SOURCE_CHICKEN_EGGDROP -> "Egg Ejected";
            case SOURCE_FOX_SHAKE -> "Fox Shakes";
            case SOURCE_FOX_CONSUMES -> "Fox Eats";
            case SOURCE_WASP_BUZZ -> "Wasp Buzzes";
            case SOURCE_WOLF_SHAKE -> "Wolf Shakes";

            default -> identifier;
        };
    }

    private SourceIdentifier() {
    }
}
