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

    public static @NotNull String getSourceName(byte source, String identifier) {
        return switch (source) {
            case SourceIdentifier.SOURCE_DEFAULT -> String.format("Undefined: %s", identifier);
            case SourceIdentifier.SOURCE_INTERFACE -> "Button Click";
            case SourceIdentifier.SOURCE_COLLECT_ITEM -> "Item Collected";
            case SourceIdentifier.SOURCE_PORTAL_INTERACTION ->
                    identifier.equals("portal.trigger") ? "Portal Triggered" : "Portal Activation";
            case SourceIdentifier.SOURCE_CLOUD_BOOTS -> "Cloud Boots Dash";
            case SourceIdentifier.SOURCE_FIRE_EXTINGUISH -> "Fire Extinguished";
            case SourceIdentifier.SOURCE_BLOCK_BREAKING -> String.format("Block breaking: %s", identifier);
            case SourceIdentifier.SOURCE_RAINING -> "Rain Sounds";
            case SourceIdentifier.SOURCE_MIDDLE_CLICK -> "Middle Mouse Click";
            case SourceIdentifier.SOURCE_AMBIENT_BLASTFURNACE -> "Blast Furnace Ambient";
            case SourceIdentifier.SOURCE_ACTIVATE_BUTTON -> "Button Clicked";
            case SourceIdentifier.SOURCE_RESTORE_BUTTON -> "Button Unclicked";
            case SourceIdentifier.SOURCE_AMBIENT_DIMENSIONAL_CHEST -> "Dimensional Chest Ambient";
            case SourceIdentifier.SOURCE_ACTIVATE_DOOR -> "Door Activated";
            case SourceIdentifier.SOURCE_AMBIENT_DUNGEON_CHEST -> "Dungeon Chest Ambient";
            case SourceIdentifier.SOURCE_ACTIVATE_GATE -> "Fence Gate Activated";
            case SourceIdentifier.SOURCE_AMBIENT_FIRE -> "Fire Ambient";
            case SourceIdentifier.SOURCE_AMBIENT_FURNACE -> "Furnace Ambient";
            case SourceIdentifier.SOURCE_AMBIENT_INCINERATOR -> "Incinerator Ambient";
            case SourceIdentifier.SOURCE_ACTIVATE_LEVER -> "Lever Activated";
            case SourceIdentifier.SOURCE_ACTIVATE_NOTE -> "Note Block Played";
            case SourceIdentifier.SOURCE_ACTIVATE_PISTON ->
                    identifier.equals("tile.piston.out") ? "Piston Deactivated" : "Piston Activated";
            case SourceIdentifier.SOURCE_AMBIENT_PORTAL -> "Portal Ambient";
            case SourceIdentifier.SOURCE_AMBIENT_POTION_FIRE -> "Potion Fire Ambient";
            case SourceIdentifier.SOURCE_ACTIVATE_PLATE -> "Plate Stepped On";
            case SourceIdentifier.SOURCE_RESTORE_PLATE -> "Plate Restored";
            case SourceIdentifier.SOURCE_AMBIENT_REFRIDGEFRIZER -> "Refridgefrizer Activated";
            case SourceIdentifier.SOURCE_INTERACT_SLIME -> "Slime Squished";
            case SourceIdentifier.SOURCE_ACTIVATE_TRAPDOOR -> "Trapdoor Activated";
            case SourceIdentifier.SOURCE_FLOW_WATER -> "Water Flowing";
            case SourceIdentifier.SOURCE_FILL_CAULDRON -> "Cauldron Filled";

            default -> identifier;
        };
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
