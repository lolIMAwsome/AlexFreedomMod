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

import java.util.Arrays;
import java.util.List;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import net.camtech.camutils.CUtils_Attributes;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.inventory.HorseInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Graces the world with purple. Command that is pretty pointless unless you are tyler.", usage = "/<command>")
public class Command_purple extends TFM_Command
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
             if (!sender.getName().equals("tylerhyperHD") && !sender.getName().equals("_Herobrian35_") && !sender.getName().equals("Alex33856"))
        {
            sender_p.sendMessage(ChatColor.RED + "Only Tyler, Hero, and Alex may use this command.");
            sender_p.setHealth(0.0);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender_p.sendMessage(ChatColor.RED + "Only Tyler, Hero, and Alex may use this command.");
                sender_p.setHealth(0.0);
            }

            return true;
        }
            if (args.length == 0)
        {
          for(Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack CamWool = new ItemStack(Material.WOOL, 1, (short)10);
                    for (Enchantment ench : Enchantment.values()) {
                     if (!ench.equals(Enchantment.DURABILITY)) {
                        CamWool.addUnsafeEnchantment(ench, 32767);
                      }
                    }
                    ItemMeta meta = CamWool.getItemMeta();
                    meta.setDisplayName(ChatColor.YELLOW + "Purple Aura");
                    Object lore = Arrays.asList(new String[] { ChatColor.BLUE + "This aura should protect", ChatColor.BLUE + "you from all possible harm." });
                    meta.setLore((List)lore);
                    CamWool.setItemMeta(meta);
                    World world = player.getWorld();
                    Location loc = player.getLocation();
                    inv.setHelmet(CamWool);
                    world.strikeLightningEffect(loc);
                }
                for(Player player : Bukkit.getOnlinePlayers())
                {
                World world = player.getWorld();
                Location loc = player.getLocation();
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with Purple!", false);
                world.strikeLightningEffect(loc);
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with Purple!", false);
                world.strikeLightningEffect(loc);
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with Purple!", false);
                world.strikeLightningEffect(loc);
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with Purple!", false);
                world.strikeLightningEffect(loc);
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with Purple!", false);
                world.strikeLightningEffect(loc);
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with Purple!", false);
                world.strikeLightningEffect(loc);
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with Purple!", false);
                world.strikeLightningEffect(loc);
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with Purple!", false);
                world.strikeLightningEffect(loc);
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with Purple!", false);
                world.strikeLightningEffect(loc);
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with Purple!", false);
                world.strikeLightningEffect(loc);
                }
        for(Player player : Bukkit.getOnlinePlayers())
                {
                PlayerInventory inv = player.getInventory();
                ItemStack CamBow = new ItemStack(Material.BOW, 1);
                for (Enchantment ench : Enchantment.values()) {
                 CamBow.addUnsafeEnchantment(ench, 32767);
                }
                ItemMeta meta = CamBow.getItemMeta();
                meta.setDisplayName(ChatColor.DARK_AQUA + "The Purple Shot");
                Object lore = Arrays.asList(new String[] { ChatColor.BLUE + "Legend has it, this bow", ChatColor.BLUE + "can only shoot purple arrows!" });
                meta.setLore((List)lore);
                CamBow.setItemMeta(meta);
                inv.addItem(CamBow);
                }
                for(Player player : Bukkit.getOnlinePlayers())
                {
                PlayerInventory inv = player.getInventory();
                ItemStack CamSword = new ItemStack(Material.GOLD_SWORD, 1);
                for (Enchantment ench : Enchantment.values()) {
                CamSword.addUnsafeEnchantment(ench, 32767);
                }
                ItemMeta meta = CamSword.getItemMeta();
                meta.setDisplayName(ChatColor.DARK_GREEN + "The Purple Blade");
                Object lore = Arrays.asList(new String[] { ChatColor.BLUE + "The purple has the power", ChatColor.BLUE + "to wield this legendary blade!" });
                meta.setLore((List)lore);
                CamSword.setItemMeta(meta);
                inv.addItem(CamSword);
                }
                for(Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack CamArrow = new ItemStack(Material.ARROW, 1);
                    for (Enchantment ench : Enchantment.values()) {
                      CamArrow.addUnsafeEnchantment(ench, 32767);
                    }
                ItemMeta meta = CamArrow.getItemMeta();
                meta.setDisplayName(ChatColor.DARK_PURPLE + "Purple Arrow");
                Object lore = Arrays.asList(new String[] { ChatColor.BLUE + "This arrow has a mysterious", ChatColor.BLUE + "purple aura around it..." });
                meta.setLore((List)lore);
                CamArrow.setItemMeta(meta);
                inv.addItem(CamArrow);
                }
                for(Player player : Bukkit.getOnlinePlayers())
                {
                PlayerInventory inv = player.getInventory();
                ItemStack CamChest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                 for (Enchantment ench : Enchantment.values()) {
                if (!ench.equals(Enchantment.DURABILITY)) {
                  CamChest.addUnsafeEnchantment(ench, 32767);
                }
              }
               LeatherArmorMeta meta = (LeatherArmorMeta)CamChest.getItemMeta();
               meta.setDisplayName(ChatColor.YELLOW + "Purple Aura");
                 Object lore = Arrays.asList(new String[] { ChatColor.BLUE + "This aura should protect", ChatColor.BLUE + "you from all possible harm." });
               meta.setLore((List)lore);
               meta.setColor(Color.fromRGB(125, 20, 240));
                CamChest.setItemMeta(meta);
                inv.setChestplate(CamChest);

                }
        for(Player player : Bukkit.getOnlinePlayers())
                {
               PlayerInventory inv = player.getInventory();
               ItemStack CamLegs = new ItemStack(Material.LEATHER_LEGGINGS, 1);
               for (Enchantment ench : Enchantment.values()) {
                if (!ench.equals(Enchantment.DURABILITY)) {
                    CamLegs.addUnsafeEnchantment(ench, 32767);
                  }
               }
                 LeatherArmorMeta meta = (LeatherArmorMeta)CamLegs.getItemMeta();
                 meta.setDisplayName(ChatColor.YELLOW + "Purple Aura");
                 Object lore = Arrays.asList(new String[] { ChatColor.BLUE + "This aura should protect", ChatColor.BLUE + "you from all possible harm." });
                 meta.setLore((List)lore);
                 meta.setColor(Color.fromRGB(125, 20, 240));
                 CamLegs.setItemMeta(meta);
                 inv.setLeggings(CamLegs);
                }
        for(Player player : Bukkit.getOnlinePlayers())
                {
              PlayerInventory inv = player.getInventory();
              ItemStack CamBoots = new ItemStack(Material.LEATHER_BOOTS, 1);
              for (Enchantment ench : Enchantment.values()) {
                if (!ench.equals(Enchantment.DURABILITY)) {
                     CamBoots.addUnsafeEnchantment(ench, 32767);
                  }
                }
               LeatherArmorMeta meta = (LeatherArmorMeta)CamBoots.getItemMeta();
                meta.setDisplayName(ChatColor.YELLOW + "Purple Aura");
               Object lore = Arrays.asList(new String[] { ChatColor.BLUE + "This aura should protect", ChatColor.BLUE + "you from all possible harm." });
               meta.setLore((List)lore);
              meta.setColor(Color.fromRGB(125, 20, 240));
                 CamBoots.setItemMeta(meta);
                 inv.setBoots(CamBoots);
                }
    }
    return true;
}
}
