package com.github.kei7777.hisyacraft;

import org.bukkit.plugin.java.JavaPlugin;

public final class Hisyacraft extends JavaPlugin {

    public static boolean mode = false; // true = neo
    public static boolean enable = false;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new HisyacraftListener(this), this);
        getServer().getPluginCommand("hisya").setExecutor(new HisyacraftCommand(this));
    }
}
