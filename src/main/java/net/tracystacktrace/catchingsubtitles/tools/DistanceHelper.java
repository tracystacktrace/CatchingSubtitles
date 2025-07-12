package net.tracystacktrace.catchingsubtitles.tools;

import net.minecraft.client.Minecraft;
import net.minecraft.common.entity.player.EntityPlayer;

public final class DistanceHelper {
    private DistanceHelper() {
    }

    public static double calculateDistance(
            double x1, double y1, double z1,
            double x2, double y2, double z2
    ) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double dz = z2 - z1;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static double calculateDistanceFromPlayer(double sX, double sY, double sZ) {
        final EntityPlayer player = Minecraft.getInstance().thePlayer;
        if (player == null) {
            return 0.0f;
        }
        return calculateDistance(player.posX, player.posY, player.posZ, sX, sY, sZ);
    }
}
