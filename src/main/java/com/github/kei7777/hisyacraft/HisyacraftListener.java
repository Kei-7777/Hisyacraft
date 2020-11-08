package com.github.kei7777.hisyacraft;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HisyacraftListener implements Listener {
    static Plugin plugin;
    public HisyacraftListener(Hisyacraft hisyacraft) {
        this.plugin = hisyacraft;
    }

    int max = 100;
    HashMap<Player, Arrow> arrows = new HashMap<Player, Arrow>();
    List<Material> airblocks = Arrays.asList(
        Material.AIR,
        Material.WATER,
        Material.GRASS,
        Material.TALL_GRASS
    );

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        e.getPlayer().sendMessage(e.getBlock().getType().toString());
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        if(!Hisyacraft.enable) return;
        if(Hisyacraft.mode){ // neo
            Player p = e.getPlayer();
            double yaw = p.getLocation().getYaw();
            if(Math.signum(yaw) == -1) {
                yaw = -(yaw);
                yaw = yaw + 180;
            }
            Location from = e.getFrom();
            Location to = e.getTo();

            if(!arrows.containsKey(p)){
                if(from.getX() == to.getX() && from.getY() == to.getY() && from.getZ() == to.getZ()) {
                    return;
                } else if((from.getX() == to.getX() && from.getZ() == to.getZ()) && from.getY() != to.getY()){
                    return;
                }
                if(yaw <= 30 || (330 <= yaw && yaw <= 360) ){ //Z++
                    Arrow ent = p.getWorld().spawn(p.getLocation().add(0, 0.45, 0), Arrow.class);
                    arrows.put(p, ent);
                    ent.setGravity(false);
                    ent.setPassenger(p);
                    new BukkitRunnable(){
                        int c = 0;
                        @Override
                        public void run() {
                            Location to = ent.getLocation();
                            c++;
                            if(airblocks.contains(to.clone().add(0,-1,0).getBlock().getType())){
                                ent.setGravity(false);
                                ent.setVelocity(new Vector(0,-1,1));
                            } else {
                                ent.setGravity(true);
                                ent.setVelocity(new Vector(0,0,1));
                            }

                            if(!airblocks.contains(to.clone().add(0,0,1).getBlock().getType())){
                                Location l = ent.getLocation().clone();
                                l.setYaw(p.getLocation().getYaw());
                                ent.remove();
                                new BukkitRunnable(){
                                    @Override
                                    public void run() {
                                        p.teleport(l);
                                        arrows.remove(p);
                                    }
                                }.runTaskLater(HisyacraftListener.plugin, 10);
                                this.cancel();
                            }

                            if(c > 100){
                                Location l = ent.getLocation().clone();
                                l.setYaw(p.getLocation().getYaw());
                                ent.remove();
                                new BukkitRunnable(){
                                    @Override
                                    public void run() {
                                        p.teleport(l);
                                        arrows.remove(p);
                                    }
                                }.runTaskLater(HisyacraftListener.plugin, 10);
                                this.cancel();
                            }

                            if(ent.isOnGround()){
                                Location l = ent.getLocation().clone();
                                l.setYaw(p.getLocation().getYaw());
                                ent.remove();
                                new BukkitRunnable(){
                                    @Override
                                    public void run() {
                                        p.teleport(l);
                                        arrows.remove(p);
                                    }
                                }.runTaskLater(HisyacraftListener.plugin, 10);
                                this.cancel();
                            }
                        }
                    }.runTaskTimer(plugin, 0, 1);
                } else if(60 <= yaw && yaw <= 120){
                    Arrow ent = p.getWorld().spawn(p.getLocation().add(0, 0.45, 0), Arrow.class);
                    arrows.put(p, ent);
                    ent.setGravity(false);
                    ent.setPassenger(p);
                    new BukkitRunnable(){
                        int c = 0;
                        @Override
                        public void run() {
                            Location to = ent.getLocation();
                            c++;
                            if(airblocks.contains(to.clone().add(0,-1,0).getBlock().getType())){
                                ent.setGravity(false);
                                ent.setVelocity(new Vector(-1,-1,0));
                            } else {
                                ent.setGravity(true);
                                ent.setVelocity(new Vector(-1,0,0));
                            }

                            if(!airblocks.contains(to.clone().add(-1,0,0).getBlock().getType())){
                                Location l = ent.getLocation().clone();
                                l.setYaw(p.getLocation().getYaw());
                                ent.remove();
                                new BukkitRunnable(){
                                    @Override
                                    public void run() {
                                        p.teleport(l);
                                        arrows.remove(p);
                                    }
                                }.runTaskLater(HisyacraftListener.plugin, 10);
                                this.cancel();
                            }

                            if(c > 100){
                                Location l = ent.getLocation().clone();
                                l.setYaw(p.getLocation().getYaw());
                                ent.remove();
                                new BukkitRunnable(){
                                    @Override
                                    public void run() {
                                        p.teleport(l);
                                        arrows.remove(p);
                                    }
                                }.runTaskLater(HisyacraftListener.plugin, 10);
                                this.cancel();
                            }

                            if(ent.isOnGround()){
                                Location l = ent.getLocation().clone();
                                l.setYaw(p.getLocation().getYaw());
                                ent.remove();
                                new BukkitRunnable(){
                                    @Override
                                    public void run() {
                                        p.teleport(l);
                                        arrows.remove(p);
                                    }
                                }.runTaskLater(HisyacraftListener.plugin, 10);
                                this.cancel();
                            }
                        }
                    }.runTaskTimer(plugin, 0, 1);
                } else if(150 <= yaw && yaw <= 210){
                    Arrow ent = p.getWorld().spawn(p.getLocation().add(0, 0.45, 0), Arrow.class);
                    arrows.put(p, ent);
                    ent.setGravity(false);
                    ent.setPassenger(p);
                    new BukkitRunnable(){
                        int c = 0;
                        @Override
                        public void run() {
                            Location to = ent.getLocation();
                            c++;
                            if(airblocks.contains(to.clone().add(0,-1,0).getBlock().getType())){
                                ent.setGravity(false);
                                ent.setVelocity(new Vector(0,-1,-1));
                            } else {
                                ent.setGravity(true);
                                ent.setVelocity(new Vector(0,0,-1));
                            }

                            if(!airblocks.contains(to.clone().add(0,0,-1).getBlock().getType())){
                                Location l = ent.getLocation().clone();
                                l.setYaw(p.getLocation().getYaw());
                                ent.remove();
                                new BukkitRunnable(){
                                    @Override
                                    public void run() {
                                        p.teleport(l);
                                        arrows.remove(p);
                                    }
                                }.runTaskLater(HisyacraftListener.plugin, 10);
                                this.cancel();
                            }

                            if(c > 100){
                                Location l = ent.getLocation().clone();
                                l.setYaw(p.getLocation().getYaw());
                                ent.remove();
                                new BukkitRunnable(){
                                    @Override
                                    public void run() {
                                        p.teleport(l);
                                        arrows.remove(p);
                                    }
                                }.runTaskLater(HisyacraftListener.plugin, 10);
                                this.cancel();
                            }

                            if(ent.isOnGround()){
                                Location l = ent.getLocation().clone();
                                l.setYaw(p.getLocation().getYaw());
                                ent.remove();
                                new BukkitRunnable(){
                                    @Override
                                    public void run() {
                                        p.teleport(l);
                                        arrows.remove(p);
                                    }
                                }.runTaskLater(HisyacraftListener.plugin, 10);
                                this.cancel();
                            }
                        }
                    }.runTaskTimer(plugin, 0, 1);
                } else if(240 <= yaw && yaw <= 300){
                    Arrow ent = p.getWorld().spawn(p.getLocation().add(0, 0.45, 0), Arrow.class);
                    arrows.put(p, ent);
                    ent.setGravity(false);
                    ent.setPassenger(p);
                    new BukkitRunnable(){
                        int c = 0;
                        @Override
                        public void run() {
                            Location to = ent.getLocation();
                            c++;
                            if(airblocks.contains(to.clone().add(0,-1,0).getBlock().getType())){
                                ent.setGravity(false);
                                ent.setVelocity(new Vector(1,-1,0));
                            } else {
                                ent.setGravity(true);
                                ent.setVelocity(new Vector(1,0,0));
                            }

                            if(!airblocks.contains(to.clone().add(1,0,0).getBlock().getType())){
                                Location l = ent.getLocation().clone();
                                l.setYaw(p.getLocation().getYaw());
                                ent.remove();
                                new BukkitRunnable(){
                                    @Override
                                    public void run() {
                                        p.teleport(l);
                                        arrows.remove(p);
                                    }
                                }.runTaskLater(HisyacraftListener.plugin, 10);
                                this.cancel();
                            }

                            if(c > 100){
                                Location l = ent.getLocation().clone();
                                l.setYaw(p.getLocation().getYaw());
                                ent.remove();
                                new BukkitRunnable(){
                                    @Override
                                    public void run() {
                                        p.teleport(l);
                                        arrows.remove(p);
                                    }
                                }.runTaskLater(HisyacraftListener.plugin, 10);
                                this.cancel();
                            }

                            if(ent.isOnGround()){
                                Location l = ent.getLocation().clone();
                                l.setYaw(p.getLocation().getYaw());
                                ent.remove();
                                new BukkitRunnable(){
                                    @Override
                                    public void run() {
                                        p.teleport(l);
                                        arrows.remove(p);
                                    }
                                }.runTaskLater(HisyacraftListener.plugin, 10);
                                this.cancel();
                            }
                        }
                    }.runTaskTimer(plugin, 0, 1);
                } else {
                    if(from.getX() != to.getX() || from.getY() != to.getY() || from.getZ() != to.getZ()) {
                        p.teleport(from);
                    }
                }
            }
        } else {
            Player p = e.getPlayer();
            double yaw = p.getLocation().getYaw();
            if(Math.signum(yaw) == -1) {
                yaw = -(yaw);
                yaw = yaw + 180;
            }
            Location from = e.getFrom();
            Location to = e.getTo();

            if(yaw <= 30 || (330 <= yaw && yaw <= 360) ){
                if(from.getBlockX() != to.getBlockX()){
                    Location loc = new Location(from.getWorld(), ((int) from.getX()) + .5, from.getY(), from.getZ());
                    loc.setYaw(0f);
                    p.teleport(loc);
                }
            } else if(60 <= yaw && yaw <= 120){
                if(from.getBlockZ() != to.getBlockZ()){
                    Location loc = new Location(from.getWorld(), from.getX(), from.getY(), ((int) from.getZ()) + .5);
                    loc.setYaw(90f);
                    p.teleport(loc);
                }
            } else if(150 <= yaw && yaw <= 210){
                if(from.getBlockX() != to.getBlockX()){
                    Location loc = new Location(from.getWorld(), from.getX(), from.getY(), ((int) from.getZ()) + .5);
                    loc.setYaw(0f);
                    p.teleport(loc);
                }
            } else if(240 <= yaw && yaw <= 300){
                if(from.getBlockZ() != to.getBlockZ()){
                    Location loc = new Location(from.getWorld(), ((int) from.getX()) + .5, from.getY(), from.getZ());
                    loc.setYaw(270f);
                    p.teleport(loc);
                }
            } else {
                if(from.getX() != to.getX() || from.getY() != to.getY() || from.getZ() != to.getZ()) {
                    p.teleport(from);
                }
            }
        }
    }
}
