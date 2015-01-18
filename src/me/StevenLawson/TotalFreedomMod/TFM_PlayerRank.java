package me.StevenLawson.TotalFreedomMod;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.DEVELOPERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.AFM_DEVELOPERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.FOP_DEVELOPERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.WEBDEV;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.SPECIAL_EXECS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.SYS;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public enum TFM_PlayerRank
{
    EXECUTIVE("an " + ChatColor.BLUE + "Executive", ChatColor.BLUE + "[Executive]"),
    CoOwner("the " + ChatColor.BLUE + "Co-Owner", ChatColor.BLUE + "[Co-Owner]"),
    CDEV("the " + ChatColor.BLUE + "Owner" + ChatColor.AQUA + " and the" + ChatColor.BLUE + " AlexFreedom Creator", ChatColor.BLUE + "[Owner]"),
    FARAH("a " + ChatColor.LIGHT_PURPLE + "Senior Admin" + ChatColor.AQUA + " and is" + ChatColor.GREEN + " bae", ChatColor.LIGHT_PURPLE + "[SrA]"),
    SECURITY("the chief of " + ChatColor.RED + "Security", ChatColor.DARK_RED + "[Chief of Security]"),
    SYSTEM("a " + ChatColor.DARK_RED + "System Admin", ChatColor.DARK_RED + "[Sys-Admin]"),
    LDEVELOPER("the " + ChatColor.DARK_PURPLE + "Lead Developer", ChatColor.DARK_PURPLE + "[Lead-Dev]"),
    TFDEVELOPER("a " + ChatColor.DARK_PURPLE + "TotalFreedom Developer", ChatColor.DARK_PURPLE + "[TF-Dev]"),
    FOPDEVELOPER("a " + ChatColor.DARK_PURPLE + "FreedomOP Developer", ChatColor.DARK_PURPLE + "[FOP-Dev]"),
    DEVELOPER("a " + ChatColor.DARK_PURPLE + "Developer", ChatColor.DARK_PURPLE + "[Dev]"),
    WARGO("a " + ChatColor.YELLOW + "Special Executive" + ChatColor.AQUA + " and a " + ChatColor.DARK_PURPLE + "Developer", ChatColor.YELLOW + "[Spec-Exec]"),
    Founder("the " + ChatColor.DARK_RED + "Founder", ChatColor.DARK_RED + "[Founder]"),
    IMPOSTOR("an " + ChatColor.YELLOW + ChatColor.UNDERLINE + "Impostor", ChatColor.YELLOW.toString() + ChatColor.UNDERLINE + "[IMP]"),
    NON_OP("a " + ChatColor.GREEN + "Non-OP", ChatColor.GREEN.toString()),
    OP("an " + ChatColor.RED + "OP", ChatColor.RED + "[OP]"),
    SUPER("a " + ChatColor.GOLD + "Super Admin", ChatColor.GOLD + "[SA]"),
    TELNET("a " + ChatColor.DARK_GREEN + "Super Telnet Admin", ChatColor.DARK_GREEN + "[STA]"),
    SENIOR("a " + ChatColor.LIGHT_PURPLE + "Senior Admin", ChatColor.LIGHT_PURPLE + "[SrA]"),
    OWNER("the " + ChatColor.DARK_RED + "Owner", ChatColor.DARK_RED + "[Owner]"),
    CONSOLE("The " + ChatColor.DARK_PURPLE + "Console", ChatColor.DARK_PURPLE + "[Console]"),
    WEBDEVS("a " + ChatColor.RED + "Web Developer", ChatColor.DARK_RED + "[Web-Dev]"),
    HELPER("a " + ChatColor.RED + "Helper", ChatColor.RED + "[Helper]"),
    SPEC_EXEC("a " + ChatColor.YELLOW + "Special Executive", ChatColor.YELLOW + "[Spec-Exec]"),
    MAN("the " + ChatColor.DARK_RED + "Admin Manager", ChatColor.DARK_RED + "[Admin Manager]"),
    SRA("a " + ChatColor.LIGHT_PURPLE + "Senior Helper", ChatColor.LIGHT_PURPLE + "[Senior-Helper]"),
    EXCD("the " + ChatColor.BLUE + "Executive Chief Designer", ChatColor.BLUE + "[Executive Chief]"),
    Z("the " + ChatColor.DARK_RED + "Executive Admin Officer", ChatColor.DARK_RED + "[Execuitve Admin Officer]"),
    AC("a " + ChatColor.DARK_BLUE + "Admin trainer", ChatColor.DARK_BLUE + "[Admin Trainer]"),
    LSYS("a " + ChatColor.DARK_RED + "Lead System Admin", ChatColor.DARK_RED + "[Lead Sys-Admin]");
    
    private String loginMessage;
    private String prefix;

    private TFM_PlayerRank(String loginMessage, String prefix)
    {
        this.loginMessage = loginMessage;
        this.prefix = prefix;
    }

    public static String getLoginMessage(CommandSender sender)
    {
        // Handle console
        if (!(sender instanceof Player))
        {
            return fromSender(sender).getLoginMessage();
        }

        // Handle admins
        final TFM_Admin entry = TFM_AdminList.getEntry((Player) sender);
        if (entry == null)
        {
            // Player is not an admin
            return fromSender(sender).getLoginMessage();
        }

        // Custom login message
        final String loginMessage = entry.getCustomLoginMessage();

        if (loginMessage == null || loginMessage.isEmpty())
        {
            return fromSender(sender).getLoginMessage();
        }

        return ChatColor.translateAlternateColorCodes('&', loginMessage);
    }

    public static TFM_PlayerRank fromSender(CommandSender sender)
    {
        if (!(sender instanceof Player))
        {
            return CONSOLE;
        }

        if (TFM_AdminList.isAdminImpostor((Player) sender))
        {
            return IMPOSTOR;
        }
        
        if (sender.getName().equals("DF_Crafted"))
        {
            return SECURITY;
        }
        
        if (sender.getName().equals("dsate1"))
        {
            return WARGO;
        }
        
        if (sender.getName().equals("Gavin_spywolf"))
        {
            return EXCD;
        }
        
        if (sender.getName().equals("FarahIsAwesome"))
        {
            return FARAH;
        }
        
        if (sender.getName().equals("XxNicozillaxX"))
        {
            return AC;
        }
        
        if (sender.getName().equals("zthehorsekid"))
        {
            return Z;
        }
        
        if (sender.getName().equals("Smart_Mann"))
        {
            return EXECUTIVE;
        }
        
        if (sender.getName().equals("tylerhyperHD"))
        {
            return LDEVELOPER;
        }
        
        if (sender.getName().equals("_herobrian35_"))
        {
            return CDEV;
        }
        
        if (sender.getName().equals("Stampy100"))
        {
            return LSYS;
        }
        
        if (sender.getName().equals("DarkDoge108"))
        {
            return LSYS;
        }
            
        if (sender.getName().equals("HollywoodFred"))
        {
            return SECURITY;
        }
        
        if (sender.getName().equals("robotexplorer"))
        {
            return CoOwner;
        }
        
        if (sender.getName().equals("Alex33856"))
        {
            return Founder;
        }
        
        if (sender.getName().equals("RobinGall2910"))
        {
            return CDEV;
        }
        
        if (DEVELOPERS.contains(sender.getName()))
        {
            return TFDEVELOPER;
        }
        
        if (FOP_DEVELOPERS.contains(sender.getName()))
        {
            return FOPDEVELOPER;
        }

        if (AFM_DEVELOPERS.contains(sender.getName()))
        {
            return DEVELOPER;
        }
                
        else if (SYS.contains(sender.getName()))
        {
            return SYSTEM;
        }
                
        else if (SPECIAL_EXECS.contains(sender.getName()))
        {
            return SPEC_EXEC;
        }
        
        if (WEBDEV.contains(sender.getName()))
        {
            return WEBDEVS;
        }     
        final TFM_Admin entry = TFM_AdminList.getEntry((Player) sender);

        final TFM_PlayerRank rank;

        if (entry != null && entry.isActivated())
        {
            if (TFM_ConfigEntry.SERVER_OWNERS.getList().contains(sender.getName()))
            {
                return OWNER;
            }

            if (entry.isSeniorAdmin())
            {
                rank = SENIOR;
            }
            else if (entry.isTelnetAdmin())
            {
                rank = TELNET;
            }
            else
            {
                rank = SUPER;
            }
        }
        else
        {
            if (sender.isOp())
            {
                rank = OP;
            }
            else
            {
                rank = NON_OP;
            }

        }
        return rank;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public String getLoginMessage()
    {
        return loginMessage;
    }
}
