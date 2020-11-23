package com.github.kei7777.hisyacraft;

import org.bukkit.entity.Player;

public enum Yaw {
    NORTH, SOUTH, EAST, WEST;

    public static Yaw getYaw(Player p) {
        float yaw = p.getLocation().getYaw();
        if (yaw < 0) {
            yaw += 360;
        }
        if (yaw >= 315 || yaw < 45) {
            return Yaw.SOUTH;
        } else if (yaw < 135) {
            return Yaw.WEST;
        } else if (yaw < 225) {
            return Yaw.NORTH;
        } else if (yaw < 315) {
            return Yaw.EAST;
        }
        return Yaw.NORTH;
    }
}
