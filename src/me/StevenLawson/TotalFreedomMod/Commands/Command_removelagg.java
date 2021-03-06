package me.StevenLawson.TotalFreedomMod.Commands;

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

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.ONLY_CONSOLE)
@CommandParameters(description = "Run's the system lagg cleaner", usage = "/<command>")
public class Command_removelagg extends TFM_Command
{
    @Override 
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        TFM_Util.bcastMsg(ChatColor.RED + "Removing all forms of client and server lagg");
        if (senderIsConsole)
        {
            server.dispatchCommand(sender, "lagg chunk");
            server.dispatchCommand(sender, "lagg clear");
            server.dispatchCommand(sender, "lagg unloadchunks");
            server.dispatchCommand(sender, "setl");
            server.dispatchCommand(sender, "ro 119");
            server.dispatchCommand(sender, "ro 52");
            server.dispatchCommand(sender, "rd");
            server.dispatchCommand(sender, "opall -c");
            server.dispatchCommand(sender, "mp");
            server.dispatchCommand(sender, "purgeall");
            server.dispatchCommand(sender, "lagg gc");
            server.dispatchCommand(sender, "save-all");
            server.dispatchCommand(sender, "cc");
            TFM_Util.bcastMsg(ChatColor.GREEN + "Lagg cleanup completed. Server catching up.");
        }
        else
        {
            TFM_Util.bcastMsg(ChatColor.RED + "Lagg cleaning failed-this has been logged.");
        }

        return true;
    }
}
