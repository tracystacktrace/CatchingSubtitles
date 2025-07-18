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
    public static final byte SOURCE_CHICKEN_IDLE = -91;
    public static final byte SOURCE_CHICKEN_HURT = -90;
    public static final byte SOURCE_CHICKEN_DEATH = -89;

    public static final byte SOURCE_FOX_SHAKE = -96;
    public static final byte SOURCE_FOX_CONSUMES = -95;
    public static final byte SOURCE_FOX_IDLE = -88;
    public static final byte SOURCE_FOX_HURT = -87;
    public static final byte SOURCE_FOX_DEATH = -86;
    public static final byte SOURCE_FOX_SLEEP = -85;
    public static final byte SOURCE_FOX_AGGRESSIVE = -84;
    public static final byte SOURCE_FOX_WHINE = -83;

    public static final byte SOURCE_WASP_IDLE = -94;
    public static final byte SOURCE_WASP_HURT = -82;
    public static final byte SOURCE_WASP_DEATH = -81;

    public static final byte SOURCE_WOLF_SHAKE = -93;
    public static final byte SOURCE_WOLF_AGGRESSIVE = -80;
    public static final byte SOURCE_WOLF_BARK = -79;
    public static final byte SOURCE_WOLF_WHINE = -78;
    public static final byte SOURCE_WOLF_PANTING = -77;
    public static final byte SOURCE_WOLF_HURT = -76;
    public static final byte SOURCE_WOLF_DEATH = -75;

    public static final byte SOURCE_ENTITY_FALL = -74;
    public static final byte SOURCE_ENTITY_BURN = -73;
    public static final byte SOURCE_ENTITY_WATER_SPLASH = -72;
    public static final byte SOURCE_ENTITY_SWIM = -71;
    public static final byte SOURCE_ENTITY_EXTINGUISHED = -70;
    public static final byte SOURCE_ENTITY_WALK = -69;

    public static final byte SOURCE_BLAZE_IDLE = -92;
    public static final byte SOURCE_BLAZE_HURT = -68;
    public static final byte SOURCE_BLAZE_DEATH = -67;

    public static final byte SOURCE_GHAST_CHARGE = -66;
    public static final byte SOURCE_GHAST_FIREBALL = -65;
    public static final byte SOURCE_GHAST_IDLE = -64;
    public static final byte SOURCE_GHAST_HURT = -63;
    public static final byte SOURCE_GHAST_DEATH = -62;

    public static final byte SOURCE_SKELETON_IDLE = -61;
    public static final byte SOURCE_SKELETON_HURT = -60;
    public static final byte SOURCE_SKELETON_DEATH = -59;
    public static final byte SOURCE_SKELETON_SHOOTS = -58;

    public static final byte SOURCE_SLIME_JUMP = -57;
    public static final byte SOURCE_SLIME_HURT = -56;
    public static final byte SOURCE_SLIME_DEATH = -55;
    public static final byte SOURCE_SLIME_ATTACK = -54;

    public static final byte SOURCE_STROLDIAN_IDLE = -53;
    public static final byte SOURCE_STROLDIAN_HURT = -52;
    public static final byte SOURCE_STROLDIAN_DEATH = -51;

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
            case SOURCE_BLAZE_IDLE -> "Blaze Flickers";

            case SOURCE_CHICKEN_EGGDROP -> "Egg Ejected";
            case SOURCE_CHICKEN_IDLE -> "Chicken Idle Sounds";
            case SOURCE_CHICKEN_HURT -> "Chicken Hurt";
            case SOURCE_CHICKEN_DEATH -> "Chicken Died";

            case SOURCE_FOX_SHAKE -> "Fox Shakes";
            case SOURCE_FOX_CONSUMES -> "Fox Eats";
            case SOURCE_FOX_IDLE -> "Fox Idle Sounds";
            case SOURCE_FOX_HURT -> "Fox Hurt";
            case SOURCE_FOX_DEATH -> "Fox Died";
            case SOURCE_FOX_SLEEP -> "Fox Sleeping";
            case SOURCE_FOX_AGGRESSIVE -> "Fox Roaring";
            case SOURCE_FOX_WHINE -> "Fox Whines";

            case SOURCE_WASP_IDLE -> "Wasp Buzzes";
            case SOURCE_WASP_HURT -> "Wasp Hurt";
            case SOURCE_WASP_DEATH -> "Wasp Died";

            case SOURCE_WOLF_SHAKE -> "Wolf Shakes";
            case SOURCE_WOLF_AGGRESSIVE -> "Wolf Growls";
            case SOURCE_WOLF_BARK -> "Wolf Barks";
            case SOURCE_WOLF_WHINE -> "Wolf Whines";
            case SOURCE_WOLF_PANTING -> "Wolf Panting";
            case SOURCE_WOLF_HURT -> "Wolf Hurt";
            case SOURCE_WOLF_DEATH -> "Wolf Died";

            case SOURCE_ENTITY_FALL -> "Entity Fell";
            case SOURCE_ENTITY_BURN -> "Entity Burns";
            case SOURCE_ENTITY_WATER_SPLASH -> "Water Splashes";
            case SOURCE_ENTITY_SWIM -> "Entity Swimming";
            case SOURCE_ENTITY_EXTINGUISHED -> "Entity Extinguished (from fire)";
            case SOURCE_ENTITY_WALK -> String .format("Entity Walks (on %s)", identifier);

            case SOURCE_GHAST_CHARGE -> "Ghast Charges";
            case SOURCE_GHAST_FIREBALL -> "Ghast Shoots";
            case SOURCE_GHAST_IDLE -> "Idle Ghast Sounds";
            case SOURCE_GHAST_HURT -> "Ghast Hurt";
            case SOURCE_GHAST_DEATH -> "Ghast Died";

            case SOURCE_SKELETON_IDLE -> "Skeleton Idle Sounds";
            case SOURCE_SKELETON_HURT -> "Skeleton Hurt";
            case SOURCE_SKELETON_DEATH -> "Skeleton Died";
            case SOURCE_SKELETON_SHOOTS -> "Skeleton Shoots";

            case SOURCE_SLIME_JUMP -> "Slime Jumps";
            case SOURCE_SLIME_HURT -> "Slime Hurt";
            case SOURCE_SLIME_DEATH -> "Slime Died";
            case SOURCE_SLIME_ATTACK -> "Slime Attacks";

            case SOURCE_STROLDIAN_IDLE -> "Stroldian Idle";
            case SOURCE_STROLDIAN_HURT -> "Stroldian Hurt";
            case SOURCE_STROLDIAN_DEATH -> "Stroldian Died";

            default -> identifier;
        };
    }

    private SourceIdentifier() {
    }
}
