package net.tracystacktrace.catchingsubtitles.tools;

import net.minecraft.client.Minecraft;
import net.minecraft.common.entity.player.EntityPlayer;

public final class SoundSourcePosition {
    public static final byte UNKNOWN = -1;
    public static final byte SAME_POSITION = 0;
    public static final byte FRONT = 1;
    public static final byte BEHIND = 2;
    public static final byte LEFT = 3;
    public static final byte RIGHT = 4;

    private SoundSourcePosition() {
    }

    public static byte getSoundDirection(double soundX, double soundZ) {
        final EntityPlayer player = Minecraft.getInstance().thePlayer;
        if (player == null) {
            return UNKNOWN;
        }
        return getSoundDirection(player.posX, player.posZ, soundX, soundZ, getSimplifiedYaw(player.rotationYaw));
    }

    public static byte getSoundDirection(double playerX, double playerZ, double soundX, double soundZ, float yaw) {
        double dx = soundX - playerX;
        double dz = soundZ - playerZ;

        double distance = Math.sqrt(dx * dx + dz * dz);
        if (distance == 0) {
            return SAME_POSITION;
        }
        dx /= distance;
        dz /= distance;

        double yawRad = Math.toRadians(yaw);

        double forwardX = -Math.sin(yawRad);
        double forwardZ = Math.cos(yawRad);

        double rightX = Math.cos(yawRad);
        double rightZ = Math.sin(yawRad);

        double forwardDot = dx * forwardX + dz * forwardZ;
        double rightDot = dx * rightX + dz * rightZ;

        if (Math.abs(forwardDot) > Math.abs(rightDot)) {
            return forwardDot > 0 ? FRONT : BEHIND;
        }
        return rightDot > 0 ? LEFT : RIGHT;
    }

    private static float getSimplifiedYaw(float rotationYaw) {
        float yaw = rotationYaw % 360.0F;
        if (yaw < 0.0F) yaw += 360.0F;
        return yaw;
    }
}
