package com.github.lewis2333.PlayerEvent;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static com.github.lewis2333.Utils.ConfigManner.*;

/**
 * @author Lewis
 */
public class Gui {
    public static Inventory LoadGui(Player player){
        Inventory Gui = Bukkit.createInventory(player,9,ChatColor.BLUE+"天体系统 | Info");
        Gui.setItem(0,LoadItem());
        Gui.setItem(1,LoadItem1());
        Gui.setItem(2,LoadItem2());
        Gui.setItem(8,LoadItem3());
        return Gui;
    }
    public static void OpenGui(Player player){
        player.openInventory(LoadGui(player));
    }
    public static void CloseGui(Player player){
        player.closeInventory();
    }
    public static ItemStack LoadItem(){
        ItemStack CentralCelestialBody = new ItemStack(Material.OAK_SAPLING);
        ItemMeta CentralCelestialBody_Meta = CentralCelestialBody.getItemMeta();
        CentralCelestialBody_Meta.setDisplayName(ChatColor.AQUA + CentralCelestialBodyDisname);
        ArrayList<String> CentralCelestialBody_Lore = new ArrayList<>();
        CentralCelestialBody_Lore.add(ChatColor.WHITE+"质量:" + CentralCelestialBodyQuality + "亿万kg");
        CentralCelestialBody_Lore.add(ChatColor.WHITE+"半径:" + CentralCelestialBodyRadius + "亿万km");
        CentralCelestialBody_Meta.setLore(CentralCelestialBody_Lore);
        CentralCelestialBody.setItemMeta(CentralCelestialBody_Meta);
        return CentralCelestialBody;
    }
    public static ItemStack LoadItem1(){
        ItemStack CelestialBody_1 = new ItemStack(Material.BIRCH_SAPLING);
        ItemMeta CelestialBody_1_Meta = CelestialBody_1.getItemMeta();
        CelestialBody_1_Meta.setDisplayName(ChatColor.AQUA + CelestialBody_1Disname);
        ArrayList<String> CelestialBody_1_Lore = new ArrayList<>();
        CelestialBody_1_Lore.add(ChatColor.WHITE+"质量:" + CelestialBody_1Quality + "亿万kg");
        CelestialBody_1_Lore.add(ChatColor.WHITE+"半径:" + CelestialBody_1Radius + "亿万km");
        CelestialBody_1_Lore.add(ChatColor.WHITE+"周期" + CelestialBody_1Range + "年");
        CelestialBody_1_Meta.setLore(CelestialBody_1_Lore);
        CelestialBody_1.setItemMeta(CelestialBody_1_Meta);
        return CelestialBody_1;
    }
    public static ItemStack LoadItem2(){
        ItemStack CelestialBody_2 = new ItemStack(Material.DARK_OAK_SAPLING);
        ItemMeta CelestialBody_2_Meta = CelestialBody_2.getItemMeta();
        CelestialBody_2_Meta.setDisplayName(ChatColor.AQUA + CelestialBody_2Disname);
        ArrayList<String> CelestialBody_2_Lore = new ArrayList<>();
        CelestialBody_2_Lore.add(ChatColor.WHITE+"质量:" + CelestialBody_2Quality + "亿万kg");
        CelestialBody_2_Lore.add(ChatColor.WHITE+"半径:" + CelestialBody_2Radius + "亿万km");
        CelestialBody_2_Lore.add(ChatColor.WHITE+"周期:" + CelestialBody_2Range + "年");
        CelestialBody_2_Meta.setLore(CelestialBody_2_Lore);
        CelestialBody_2.setItemMeta(CelestialBody_2_Meta);
        return CelestialBody_2;
    }
    public static ItemStack LoadItem3(){
        ItemStack Start = new ItemStack(Material.EMERALD);
        ItemMeta Start_Meta = Start.getItemMeta();
        Start_Meta.setDisplayName(ChatColor.GREEN + "Start!");
        ArrayList<String> CelestialBody_2_Lore = new ArrayList<>();
        Start.setItemMeta(Start_Meta);
        return Start;
    }
}
