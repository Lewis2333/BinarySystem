package com.github.lewis2333.Utils;


import com.github.lewis2333.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * @author Lewis
 */
public class ConfigManner {
    public static String CentralCelestialBodyDisname;
    public static int CentralCelestialBodyQuality;
    public static int CentralCelestialBodyRadius;
    public static String CelestialBody_1Disname;
    public static int CelestialBody_1Quality;
    public static int CelestialBody_1Radius;
    public static int CelestialBody_1Range;
    public static String CelestialBody_2Disname;
    public static int CelestialBody_2Quality;
    public static int CelestialBody_2Radius;
    public static int CelestialBody_2Range;

    public static String Start;
    public static String errormode;
    public static String Reload;

    public static void testConfig(){
        File file = new File(Main.plugin.getDataFolder(), "Settings.yml");
        FileConfiguration filec = YamlConfiguration.loadConfiguration(file);
        //settings.yml
        testConfig_2(filec,"BinarySystem.CentralCelestialBody.disname",0,"中心天体",false,0.0,true,false,false);
        testConfig_2(filec,"BinarySystem.CelestialBody_1.disname",0,"恒星A",false,0.0,true,false,false);
        testConfig_2(filec,"BinarySystem.CelestialBody_2.disname",0,"恒星B",false,0.0,true,false,false);
        testConfig_2(filec,"BinarySystem.CelestialBody_1.quality",320,null,false,0.0,false,false,false);
        testConfig_2(filec,"BinarySystem.CelestialBody_2.quality",1,null,false,0.0,false,false,false);
        testConfig_2(filec,"BinarySystem.CelestialBody_1.range",12,null,false,0.0,false,false,false);
        testConfig_2(filec,"BinarySystem.CelestialBody_2.range",1,null,false,0.0,false,false,false);
        testConfig_2(filec,"BinarySystem.CelestialBody_1.radius",11,null,false,0.0,false,false,false);
        testConfig_2(filec,"BinarySystem.CelestialBody_2.radius",1,null,false,0.0,false,false,false);
        File file_ = new File(Main.plugin.getDataFolder(), "Message.yml");
        FileConfiguration filec_ = YamlConfiguration.loadConfiguration(file_);
        //Message.yml
        testConfig_2(filec_,"Start",0,"&b[BinarySystem] &7正在启动天体系统...",false,0.0,true,false,false);
        testConfig_2(filec_,"Reload",0,"&b[BinarySystem] &c重载配置文件成功~",false,0.0,true,false,false);
        testConfig_2(filec_,"errormode",0,"§b[BinarySystem] §c错误！数据溢出 插件已关闭！",false,0.0,true,false,false);
        testConfig_2(filec_,"HelpMessage.0",0,"============§b[BinarySystem]§f============",false,0.0,true,false,false);
        testConfig_2(filec_,"HelpMessage.1",0," ► §7/BinarySystem start 开启天体模式",false,0.0,true,false,false);
        testConfig_2(filec_,"HelpMessage.2",0," ",false,0.0,true,false,false);
        testConfig_2(filec_,"HelpMessage.3",0," ► §7/BinarySystem reload 重载配置文件(Settings)",false,0.0,true,false,false);
        testConfig_2(filec_,"HelpMessage.4",0,"============§b[@By Lewis]§f============",false,0.0,true,false,false);

        try {
            filec.save(file);
            filec_.save(file_);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void reloadConfig() {
        File file = new File(Main.plugin.getDataFolder(), "Settings.yml");
        FileConfiguration filec = YamlConfiguration.loadConfiguration(file);
        try {
            filec.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        loadConfig();

    }

    public static void loadConfig() {
        loadSettings();
        loadMessage();
    }

    public static void loadSettings() {
        File file = new File(Main.plugin.getDataFolder(), "Settings.yml");
        FileConfiguration filec = YamlConfiguration.loadConfiguration(file);
        CentralCelestialBodyDisname = filec.getString("BinarySystem.CentralCelestialBody.disname");
        CentralCelestialBodyQuality = filec.getInt("BinarySystem.CentralCelestialBody.quality");
        CentralCelestialBodyRadius = filec.getInt("BinarySystem.CentralCelestialBody.radius");
        CelestialBody_1Disname = filec.getString("BinarySystem.CelestialBody_1.disname");
        CelestialBody_1Quality = filec.getInt("BinarySystem.CelestialBody_1.quality");
        CelestialBody_1Radius = filec.getInt("BinarySystem.CelestialBody_1.radius");
        CelestialBody_1Range = filec.getInt("BinarySystem.CelestialBody_1.radius");
        CelestialBody_2Disname = filec.getString("BinarySystem.CelestialBody_2.disname");
        CelestialBody_2Quality = filec.getInt("BinarySystem.CelestialBody_2.quality");
        CelestialBody_2Radius = filec.getInt("BinarySystem.CelestialBody_2.radius");
        CelestialBody_2Range = filec.getInt("BinarySystem.CelestialBody_2.radius");
    }

    public static void loadMessage() {
        File file = new File(Main.plugin.getDataFolder(), "Message.yml");
        FileConfiguration filec = YamlConfiguration.loadConfiguration(file);
        Start = filec.getString("Start");
        Start = Start.replace("&", "§");
        Reload = filec.getString("Reload");
        Reload = Reload.replace("&", "§");
        errormode = filec.getString("errormode");

    }

    public static List<String> loadHelpMessage() {
        File file = new File(Main.plugin.getDataFolder(), "Message.yml");
        FileConfiguration filec = YamlConfiguration.loadConfiguration(file);
        ConfigurationSection filecc = filec.getConfigurationSection("HelpMessage");
        List<String> newHelpMessage = new ArrayList<>();
        for (String key : filecc.getKeys(false)){
            newHelpMessage.add(filec.getString("HelpMessage."+key));
        }
        return newHelpMessage;
    }


    public static void testConfig_2(FileConfiguration filec,String path,int a,String b,Boolean c,Double d,Boolean isString,Boolean isBoolean,Boolean isDouble){
        if(!isString && !isBoolean && !isDouble){
            if(!filec.contains(path)){
                filec.set(path,a);
                Main.plugin.getLogger().info("检测到"+path+"节点消失，已自动生成！");
            }
        }
        if(isString) {
            if (!filec.contains(path)) {
                filec.set(path,b);
                Main.plugin.getLogger().info("检测到"+path+"节点消失，已自动生成！");
            }
        }
        if(isBoolean){
            if (!filec.contains(path)) {
                filec.set(path,c);
                Main.plugin.getLogger().info("检测到"+path+"节点消失，已自动生成！");
            }
        }
        if(isDouble){
            if (!filec.contains(path)) {
                filec.set(path,d);
                Main.plugin.getLogger().info("检测到"+path+"节点消失，已自动生成！");
            }
        }
    }
}
