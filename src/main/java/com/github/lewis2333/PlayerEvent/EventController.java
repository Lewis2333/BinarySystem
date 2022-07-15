package com.github.lewis2333.PlayerEvent;

import com.github.lewis2333.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import static com.github.lewis2333.PlayerEvent.Gui.CloseGui;
import static com.github.lewis2333.Utils.ConfigManner.*;


/**
 * @author Lewis
 */
public class EventController implements Listener {
    public float max,min,radius_,radius_2,a1,a2,density,density2;
    @EventHandler
    public void ClickGui(InventoryClickEvent event){
        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE+"天体系统 | Info")){
            event.setCancelled(true);
            try{
                if(event.getCurrentItem().getType().equals(Material.EMERALD)){
                    Player player = (Player) event.getWhoClicked();
                    Location location = new Location(player.getWorld(), -3090.5,194.7,187.7);
                    player.sendMessage(Start);
                    CloseGui(player);
                    player.sendTitle("正在传送至星系","..........",10,70,20);
                    player.teleport(location);
                    player.sendMessage(ChatColor.BLUE + "[BinarySystem]" + ChatColor.GREEN +" 启动完毕!");
                    player.spigot().sendMessage(ChatMessageType.CHAT, new TextComponent("§b[BinarySystem] 正在模拟星系运转、计算数据中，请稍后..."));
                    runCalculation(player);
                }
            }catch (NullPointerException e){

            }

        }
    }
    public void Calculation(Player player){

        radius_ = (float) Math.pow( Math.pow(CelestialBody_2Range,2),-3);
        radius_2 = (float) Math.pow(Math.pow(CelestialBody_1Range,2),-3);
        player.sendMessage("============§b[@Calculation]§f============");
        player.sendMessage(ChatColor.RED +" 根据开普勒第三定律得，行星A与行星B公转轨道的半径之比为:" + ChatColor.BLUE+radius_ +":" +radius_2);
        a1 = (float) Math.pow(CelestialBody_1Radius,2);
        a2 = (float) Math.pow(CelestialBody_2Radius,2);
        player.sendMessage( ChatColor.RED +" 根据a=GM/r2得行星A与行星B加速度之比为:" +ChatColor.BLUE+ a1 +":" +a2);
        min = (float) ((CelestialBody_1Range*CelestialBody_2Range/(CelestialBody_1Range-CelestialBody_2Range))+0.09);
        max = (float) ((min/2.0));
        player.sendMessage( ChatColor.RED +" 根据ThetaA-ThetaB=2π得" +ChatColor.BLUE+ "当经过"+min+"年时,两行星相距最近");
        player.sendMessage( ChatColor.RED +" 根据ThetaA-ThetaB=π得" +ChatColor.BLUE+ "当经过"+max+"年时,两行星相距最远");
        density = (float) (CelestialBody_1Quality*Math.pow(CelestialBody_2Radius,3));
        density2 = (float) (CelestialBody_2Quality*Math.pow(CelestialBody_1Radius,3));
        player.sendMessage( ChatColor.RED +" 根据ρ=3M/4πR3得行星A与行星B密度之比为:" +ChatColor.BLUE+ density +":" +density2);
        player.sendMessage("============§b[@计算完毕]§f============");
    }
        public void runCalculation(Player player){
            new BukkitRunnable(){
                @Override
                public void run() {
                    player.sendTitle(ChatColor.GREEN+"计算完毕！","[以下是计算结果]",10,70,20);
                    Calculation(player);
                }
                }.runTaskLaterAsynchronously(Main.plugin, 250);
            }
        }

