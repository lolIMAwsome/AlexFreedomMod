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

import me.StevenLawson.TotalFreedomMod.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(
        description = "Give someone a blowjob.",
        usage = "/<command>")
public class Command_blowjob extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        
        if (!sender.getName().equals("Alex33856") && !sender.getName().equals("tylerhyperHD") && !sender.getName().equals("_herobrian35_"))
        {
            sender.sendMessage("You cannot give others blowjobs u fuck. No perms for you.");
            sender.sendMessage(TFM_Command.MSG_NO_PERMS);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("You cannot give others blowjobs u fuck.");
            }

            return true;
        }
        if (args.length != 1)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND);
            return true;
        }

        TFM_Util.adminAction(sender.getName(), "Giving " + player.getName() + " a blowjob.", true);
        server.dispatchCommand(sender, "tpo " + player.getName() + " " + sender.getName());
        TFM_PlayerData playerdata = TFM_PlayerData.getPlayerData(player);
        playerdata.setFrozen(!playerdata.isFrozen());
        player.chat("Ohhhh yeahhhhh.");
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
        TFM_Util.bcastMsg(player.getName() + " got fucked too hard, and fell asleep whilst the fuck happened.", ChatColor.RED);
        player.setHealth(0.0);
        player.sendMessage(ChatColor.RED + "You just got a blowjob by a gay guy in Minecraft!");
        TFM_PlayerData playerdata = TFM_PlayerData.getPlayerData(player);
        playerdata.setFrozen(!playerdata.isFrozen());
            }
        }.runTaskLater(plugin, 4L * 40L);
       return true;
    }
}