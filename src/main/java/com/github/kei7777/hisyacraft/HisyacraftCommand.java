package com.github.kei7777.hisyacraft;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Arrays;
import java.util.List;

public class HisyacraftCommand implements CommandExecutor, TabCompleter {
    Plugin plugin;
    public HisyacraftCommand(Hisyacraft hisyacraft) {
        this.plugin = hisyacraft;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "権限がありません。");
            return true;
        }
        if (args.length < 1) {
            sender.sendMessage("/hisya toggle 有効/無効切り替え。\n/hisya mode 通常/Neo切り替え。");
            return true;
        }

        if ("toggle".equalsIgnoreCase(args[0])) {
            Hisyacraft.enable = !Hisyacraft.enable;
            String msg = Hisyacraft.enable ? "有効" : "無効";
            sender.sendMessage("飛車クラフトを" + msg + "にしました。");
            return true;
        } else if ("mode".equalsIgnoreCase(args[0])) {
            Hisyacraft.mode = !Hisyacraft.mode;
            String msg = Hisyacraft.mode ? "有効" : "無効";
            sender.sendMessage("Neoモードを" + msg + "にしました。");
            return true;
        } else {
            sender.sendMessage("/hisya toggle 有効/無効切り替え。\n/hisya mode 通常/Neo切り替え。");
            return true;
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return Arrays.asList("toggle", "mode");
    }
}
