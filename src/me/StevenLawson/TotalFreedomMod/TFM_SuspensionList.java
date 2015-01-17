package me.StevenLawson.TotalFreedomMod;

/*

  ____                 _                              _     _             
 |  _ \    ___   ___  (_)   __ _   _ __     ___    __| |   | |__    _   _ 
 | | | |  / _ \ / __| | |  / _` | | '_ \   / _ \  / _` |   | '_ \  | | | |
 | |_| | |  __/ \__ \ | | | (_| | | | | | |  __/ | (_| |   | |_) | | |_| |
 |____/   \___| |___/ |_|  \__, | |_| |_|  \___|  \__,_|   |_.__/   \__, |
                           |___/                                    |___/ 


  _             _                 _                                     _   _   ____  
 | |_   _   _  | |   ___   _ __  | |__    _   _   _ __     ___   _ __  | | | | |  _ \ 
 | __| | | | | | |  / _ \ | '__| | '_ \  | | | | | '_ \   / _ \ | '__| | |_| | | | | |
 | |_  | |_| | | | |  __/ | |    | | | | | |_| | | |_) | |  __/ | |    |  _  | | |_| |
  \__|  \__, | |_|  \___| |_|    |_| |_|  \__, | | .__/   \___| |_|    |_| |_| |____/ 
        |___/                             |___/  |_|                                  



*/

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.StevenLawson.TotalFreedomMod.Config.TFM_Config;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import org.bukkit.util.FileUtil;

public class TFM_SuspensionList
{
    private static final List<String> SUSPENDED_PLAYERS;
    private static final List<String> SUSPENDED_IPS;

    static
    {
        SUSPENDED_PLAYERS = new ArrayList<String>();
        SUSPENDED_IPS = new ArrayList<String>();
    }

    private TFM_SuspensionList()
    {
        throw new AssertionError();
    }

    public static List<String> getSuspendedPlayers()
    {
        return Collections.unmodifiableList(SUSPENDED_PLAYERS);
    }

    public static List<String> getSuspendedIps()
    {
        return Collections.unmodifiableList(SUSPENDED_IPS);
    }

    public static void load()
    {
        SUSPENDED_PLAYERS.clear();
        SUSPENDED_IPS.clear();

        final TFM_Config config = new TFM_Config(TotalFreedomMod.plugin, TotalFreedomMod.SUSPENSION_FILE, true);
        config.load();

        for (String playername : config.getKeys(false))
        {
            SUSPENDED_PLAYERS.add(playername.toLowerCase().trim());

            List<String> playerIps = config.getStringList(playername);
            for (String ip : playerIps)
            {
                ip = ip.trim();
                if (!SUSPENDED_IPS.contains(ip))
                {
                    SUSPENDED_IPS.add(ip);
                }
            }
        }

        TFM_Log.info("Loaded " + SUSPENDED_PLAYERS.size() + " suspended players and " + SUSPENDED_IPS.size() + " suspended IPs.");
    }
}
