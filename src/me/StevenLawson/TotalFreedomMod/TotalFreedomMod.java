package me.StevenLawson.TotalFreedomMod;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import me.StevenLawson.TotalFreedomMod.Commands.TFM_CommandHandler;
import me.StevenLawson.TotalFreedomMod.Commands.TFM_CommandLoader;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.HTTPD.TFM_HTTPD_Manager;
import me.StevenLawson.TotalFreedomMod.Listener.TFM_BlockListener;
import me.StevenLawson.TotalFreedomMod.Listener.TFM_EntityListener;
import me.StevenLawson.TotalFreedomMod.Listener.TFM_PlayerListener;
import me.StevenLawson.TotalFreedomMod.Listener.TFM_ServerListener;
import me.StevenLawson.TotalFreedomMod.Listener.TFM_TelnetListener;
import me.StevenLawson.TotalFreedomMod.Listener.TFM_WeatherListener;
import me.StevenLawson.TotalFreedomMod.World.TFM_AdminWorld;
import me.StevenLawson.TotalFreedomMod.World.TFM_Flatlands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.mcstats.Metrics;

public class TotalFreedomMod extends JavaPlugin
{
    public static final long HEARTBEAT_RATE = 5L; // Seconds
    public static final long SERVICE_CHECKER_RATE = 120L;
    //
    public static final String SUPERADMIN_FILE = "superadmin.yml";
    public static final String PERMBAN_FILE = "permban.yml";
    public static final String SUSPENSION_FILE = "suspensions.yml";
    public static final String EXPLODING_FILE = "exploding.yml";
    public static final String PROTECTED_AREA_FILE = "protectedareas.dat";
    public static final String SAVED_FLAGS_FILE = "savedflags.dat";
    //
    public static final String MSG_NO_PERMS = ChatColor.YELLOW + "You do not have permission to use this command.";
    public static final String YOU_ARE_OP = ChatColor.YELLOW + "You are now op!";
    public static final String YOU_ARE_NOT_OP = ChatColor.YELLOW + "You are no longer op!";
    public static final String CAKE_LYRICS = "But there's no sense crying over every mistake. You just keep on trying till you run out of cake.";
    public static final String COOKIE_LYRICS = "But there's no sense crying over every mistake. You just keep on trying till you run out of FUCKING COOKIES!";
    public static final String NOT_FROM_CONSOLE = "This command may not be used from the console.";
    public static final String PLAYER_NOT_FOUND = ChatColor.GRAY + "Player not found!";
    public static final String PIE_LYRICS = "PIE FOR EVERYONE! :D";
    //
    public static String buildNumber = "3";
    public static String buildDate = TotalFreedomMod.buildDate = TFM_Util.dateToString(new Date());
    public static String buildCreator = "tylerhyperHD";
    //
    public static Server server;
    public static TotalFreedomMod plugin;
    public static String pluginName;
    public static String pluginVersion;
    //
    public static boolean allPlayersFrozen = false;
    public static BukkitTask freezePurgeTask = null;
    public static BukkitTask mutePurgeTask = null;
    public static boolean lockdownEnabled = false;
    public static Map<Player, Double> fuckoffEnabledFor = new HashMap<Player, Double>();
    
    @Override
    public void onLoad()
    {
        TotalFreedomMod.plugin = this;
        TotalFreedomMod.server = plugin.getServer();
        TotalFreedomMod.pluginName = plugin.getDescription().getName();
        TotalFreedomMod.pluginVersion = plugin.getDescription().getVersion();

        TFM_Log.setPluginLogger(plugin.getLogger());
        TFM_Log.setServerLogger(server.getLogger());

        setAppProperties();
    }

    @Override
    public void onEnable()
    {
        TFM_Log.info("Made by Madgeek1450 and DarthSalamon");
        TFM_Log.info("Plugin designed by tylerhyperHD");
        TFM_Log.info("Compiled " + buildDate + " by " + buildCreator); 
        TFM_Log.info("/***********************/");
        TFM_Log.info("");
        TFM_Log.info("Made for AlexFreedom - An all-op server");
        TFM_Log.info("Any version not originated from Github is not official!");
        TFM_Log.info("");
        TFM_Log.info("/***********************/");

        
        if (!TFM_ServerInterface.COMPILE_NMS_VERSION.equals(TFM_Util.getNmsVersion()))
        {
            TFM_Log.warning(pluginName + " is compiled for " + TFM_ServerInterface.COMPILE_NMS_VERSION + " but the server is running "
                    + "version " + TFM_Util.getNmsVersion() + "!");
            TFM_Log.warning("This might result in unexpected behaviour!");
        }

        TFM_Util.deleteCoreDumps();
        TFM_Util.deleteFolder(new File("./_deleteme"));

        // Create backups
        TFM_Util.createBackups(SUPERADMIN_FILE);
        TFM_Util.createBackups(PERMBAN_FILE);

        // Load services
        TFM_AdminList.load();
        TFM_PermbanList.load();
        TFM_SuspensionList.load();
        TFM_PlayerList.load();
        TFM_BanManager.load();
        TFM_Announcer.load();

        // Protect area
        // TODO: Refractor to single .load() method
        if (TFM_ConfigEntry.PROTECTAREA_ENABLED.getBoolean())
        {
            TFM_ProtectedArea.loadProtectedAreas();
            TFM_ProtectedArea.autoAddSpawnpoints();
        }

        final PluginManager pm = server.getPluginManager();
        pm.registerEvents(new TFM_EntityListener(), plugin);
        pm.registerEvents(new TFM_BlockListener(), plugin);
        pm.registerEvents(new TFM_PlayerListener(), plugin);
        pm.registerEvents(new TFM_WeatherListener(), plugin);
        pm.registerEvents(new TFM_ServerListener(), plugin);
        pm.registerEvents(new TFM_TelnetListener(), plugin);

        try
        {
            TFM_Flatlands.getInstance().getWorld();
        }
        catch (Exception ex)
        {
            TFM_Log.warning("Could not load world: Flatlands");
        }

        try
        {
            TFM_AdminWorld.getInstance().getWorld();
        }
        catch (Exception ex)
        {
            TFM_Log.warning("Could not load world: AdminWorld");
        }

        // Initialize game rules
        TFM_GameRuleHandler.setGameRule(TFM_GameRuleHandler.TFM_GameRule.DO_DAYLIGHT_CYCLE, !TFM_ConfigEntry.DISABLE_NIGHT.getBoolean(), false);
        TFM_GameRuleHandler.setGameRule(TFM_GameRuleHandler.TFM_GameRule.DO_FIRE_TICK, TFM_ConfigEntry.ALLOW_FIRE_SPREAD.getBoolean(), false);
        TFM_GameRuleHandler.setGameRule(TFM_GameRuleHandler.TFM_GameRule.DO_MOB_LOOT, false, false);
        TFM_GameRuleHandler.setGameRule(TFM_GameRuleHandler.TFM_GameRule.DO_MOB_SPAWNING, !TFM_ConfigEntry.MOB_LIMITER_ENABLED.getBoolean(), false);
        TFM_GameRuleHandler.setGameRule(TFM_GameRuleHandler.TFM_GameRule.DO_TILE_DROPS, false, false);
        TFM_GameRuleHandler.setGameRule(TFM_GameRuleHandler.TFM_GameRule.MOB_GRIEFING, false, false);
        TFM_GameRuleHandler.setGameRule(TFM_GameRuleHandler.TFM_GameRule.NATURAL_REGENERATION, true, false);
        TFM_GameRuleHandler.commitGameRules();

        // Disable weather
        if (TFM_ConfigEntry.DISABLE_WEATHER.getBoolean())
        {
            for (World world : server.getWorlds())
            {
                world.setThundering(false);
                world.setStorm(false);
                world.setThunderDuration(0);
                world.setWeatherDuration(0);
            }
        }

        // Heartbeat
        new TFM_Heartbeat(plugin).runTaskTimer(plugin, HEARTBEAT_RATE * 20L, HEARTBEAT_RATE * 20L);

        // Start services
        TFM_ServiceChecker.start();
        TFM_HTTPD_Manager.start();
        
        TFM_Log.info("Version " + pluginVersion + " for " + TFM_ServerInterface.COMPILE_NMS_VERSION + " enabled");

        // Metrics @ http://mcstats.org/plugin/TotalFreedomMod
        try
        {
            final Metrics metrics = new Metrics(plugin);
            metrics.start();
        }
        catch (IOException ex)
        {
            TFM_Log.warning("Failed to submit metrics data: " + ex.getMessage());
        }

        // Load commands later
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                TFM_CommandLoader.scan();
                TFM_CommandBlocker.load();
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    if (TFM_AdminList.isSuperAdmin(player))
                    {
                        TFM_PlayerData.getPlayerData(player).setCommandSpy(true);
                    }
                }
            }
        }.runTaskLater(plugin, 20L);
    }

    @Override
    public void onDisable()
    {
        server.getScheduler().cancelTasks(plugin);

        TFM_HTTPD_Manager.stop();
        TFM_BanManager.save();

        TFM_Log.info("Plugin disabled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        return TFM_CommandHandler.handleCommand(sender, cmd, commandLabel, args);
    }

    private static void setAppProperties()
    {
        try
        {
            final InputStream in = plugin.getResource("appinfo.properties");
            Properties props = new Properties();

            // in = plugin.getClass().getResourceAsStream("/appinfo.properties");
            props.load(in);
            in.close();

            TotalFreedomMod.buildNumber = props.getProperty("program.buildnumber");
            TotalFreedomMod.buildDate = props.getProperty("program.builddate");
            TotalFreedomMod.buildCreator = props.getProperty("program.buildcreator");
        }
        catch (Exception ex)
        {
            TFM_Log.severe("Could not load App properties!");
            TFM_Log.severe(ex);
        }
    }
}
