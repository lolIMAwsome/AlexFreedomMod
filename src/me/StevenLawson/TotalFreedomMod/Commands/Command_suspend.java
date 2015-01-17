package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_SuspensionList;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import net.minecraft.util.org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description = "Manage suspended players and IPs.", usage = "/<command> <list | reload>")
public class Command_suspend extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length != 1)
        {
            return false;
        }

        if (args[0].equalsIgnoreCase("list"))
        {
            dumplist(sender);
        }
        else if (args[0].equalsIgnoreCase("reload"))
        {
            if (!senderIsConsole)
            {
                sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);
                return true;
            }
            playerMsg("Reloading suspensions...", ChatColor.RED);
            TFM_SuspensionList.load();
            dumplist(sender);
        }
        else
        {
            return false;
        }

        return true;
    }

    private void dumplist(CommandSender sender)
    {
        if (TFM_SuspensionList.getSuspendedPlayers().isEmpty())
        {
            playerMsg(sender, "No suspended player names.");
        }
        else
        {
            playerMsg(sender, TFM_SuspensionList.getSuspendedPlayers().size() + " suspended players:");
            playerMsg(sender, StringUtils.join(TFM_SuspensionList.getSuspendedPlayers(), ", "));
        }

        if (TFM_SuspensionList.getSuspendedIps().isEmpty())
        {
            playerMsg(sender, "No suspended IPs.");
        }
        else
        {
            playerMsg(sender, TFM_SuspensionList.getSuspendedIps().size() + " suspended IPs:");
            playerMsg(sender, StringUtils.join(TFM_SuspensionList.getSuspendedIps(), ", "));
        }
    }
}
