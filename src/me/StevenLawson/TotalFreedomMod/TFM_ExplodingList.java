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

public class TFM_ExplodingList
{
    private static final List<String> EXPLODING_PLAYERS;
    private static final List<String> EXPLODING_IPS;

    static
    {
        EXPLODING_PLAYERS = new ArrayList<String>();
        EXPLODING_IPS = new ArrayList<String>();
    }

    private TFM_ExplodingList()
    {
        throw new AssertionError();
    }

    public static List<String> getExplodingPlayers()
    {
        return Collections.unmodifiableList(EXPLODING_PLAYERS);
    }

    public static List<String> getExplodingIps()
    {
        return Collections.unmodifiableList(EXPLODING_IPS);
    }

    public static void load()
    {
        EXPLODING_PLAYERS.clear();
        EXPLODING_IPS.clear();

        final TFM_Config config = new TFM_Config(TotalFreedomMod.plugin, TotalFreedomMod.EXPLODING_FILE, true);
        config.load();

        for (String playername : config.getKeys(false))
        {
            EXPLODING_PLAYERS.add(playername.toLowerCase().trim());

            List<String> playerIps = config.getStringList(playername);
            for (String ip : playerIps)
            {
                ip = ip.trim();
                if (!EXPLODING_IPS.contains(ip))
                {
                    EXPLODING_IPS.add(ip);
                }
            }
        }

        TFM_Log.info("Loaded " + EXPLODING_PLAYERS.size() + " EXPLODINGFreedom players and " + EXPLODING_IPS.size() + " EXPLODINGFreedom IPs.");
    }
}
