package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "reuben4545 is totally sexy!", usage = "/<command>")
public class Command_sexy extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender_p.chat ("I would have thought I was sexy, but im Ugxly... We all know who is sexy, reuben4545 sexy!");
        playerMsg("reuben4545 is sexy! :O", ChatColor.GRAY);
        playerMsg("Also reuben4545 is sexy :) and he's our co-chief-dev!", ChatColor.GOLD);
        return true;  
    }
}
