package me.StevenLawson.TotalFreedomMod.Commands;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Run your personal command.", usage = "/<command>", aliases = "psl")
public class Command_personal extends TFM_Command
{    @Override
    public boolean run(CommandSender sender, final Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        String which;
        if (args.length >= 1)
        {
            if (!TFM_Util.isHighRank(sender))
            {
                TFM_Util.playerMsg(sender, TotalFreedomMod.MSG_NO_PERMS, ChatColor.RED);
                return true;
            }
            which = args[0];
        }
        else if (sender.getName().equals("eagleeye64000") || sender.getName().equals("R1SSY") || sender.getName().equals("escojay"))
        {
            which = "multiEagle";
        }
        else
        {
            which = sender_p.getName();
        }
        switch(which)
        {
            case "Camzie99":
                for(Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack wool = new ItemStack(Material.WOOL, 1, (short) 10);
                    for (Enchantment ench : Enchantment.values())
                    {
                        wool.addUnsafeEnchantment(ench, 32767);
                    }
                    ItemMeta meta = wool.getItemMeta();
                    World world = player.getWorld();
                    Location loc = player.getLocation();
                    meta.setDisplayName(ChatColor.DARK_PURPLE + "The Purple Aura");
                    List<String> lore = Arrays.asList(ChatColor.BLUE + "The aura should protect you from all possible harm.");
                    meta.setLore(lore);
                    wool.setItemMeta(meta);
                    inv.setHelmet(wool);
                    world.strikeLightningEffect(loc);
                }
                TFM_Util.adminAction(sender_p.getName(), "Gracing the world with Purple!", false);
            break;
                case "brickblock12":
                for(Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack brick = new ItemStack(Material.BRICK, 1);
                    for (Enchantment ench : Enchantment.values())
                    {
                        brick.addUnsafeEnchantment(ench, 10000);
                    }
                    ItemMeta meta = brick.getItemMeta();
                    World world = player.getWorld();
                    Location loc = player.getLocation();
                    meta.setDisplayName(ChatColor.DARK_PURPLE + "DA BRICK");
                    List<String> lore = Arrays.asList(ChatColor.BLUE + "The brick protects you from getting hit in the head. Strange...");
                    meta.setLore(lore);
                    brick.setItemMeta(meta);
                    inv.setHelmet(brick);
                    world.strikeLightningEffect(loc);
                }
                TFM_Util.adminAction(sender_p.getName(), "HAH! You got brick blocked!", true);
            break;
            case "jumpymonkey123" :
                TFM_Util.asciiUnicorn();
            break;
            case "dick" :
                TFM_Util.asciiDick();
                TFM_Util.bcastMsg("Lel its a dick!", TFM_Util.randomChatColor());
            break;
            case "dsate1" :
            TFM_Util.asciiUnicorn();
            TFM_Util.bcastMsg(" Look", TFM_Util.randomChatColor());
            TFM_Util.bcastMsg(" At", TFM_Util.randomChatColor());
            TFM_Util.bcastMsg(" The", TFM_Util.randomChatColor());
            TFM_Util.bcastMsg(" Pretty", TFM_Util.randomChatColor());
            TFM_Util.bcastMsg(" Unicorn", TFM_Util.randomChatColor()); 
            break;
            case "taahanis":
            playerMsg("taahanis, you may not have a personal command at all. -Tyler");
            break;
            case "RobinGall2910"  :
                TFM_Util.asciiDog();
                TFM_Util.bcastMsg("hi doggies", TFM_Util.randomChatColor());
                TFM_Util.bcastMsg("Now, doggies for everyone :P", ChatColor.AQUA);
                for(Player player : Bukkit.getOnlinePlayers())
                {
                    TFM_Util.spawnMob(player, EntityType.WOLF, 10);
                    LivingEntity dog = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.WOLF);
                    dog.setCustomNameVisible(true);
                    dog.setCustomName(ChatColor.DARK_AQUA + "Doggie");
                    player.setOp(true);
                    player.sendRawMessage(TotalFreedomMod.YOU_ARE_OP);
                }
            new BukkitRunnable()
              {
                @Override
                public void run()
                {
                  TFM_Util.bcastMsg("Except you Robin, you get nothing u whore XD", ChatColor.RED);
                  sender_p.chat("U whore.");
                  sender_p.setHealth(0.0);
                }
            }.runTaskLater(plugin, 2L * 2L);
            break;
            case "cowgomooo12":
                for(Player player : Bukkit.getOnlinePlayers())
                {
                    TFM_Util.spawnMob(player, EntityType.COW, 2);
                }
                TFM_Util.adminAction(sender_p.getName(), "Let there be cows!", false);
            break;
            case "Different_T_O_P":
                for(Player player : Bukkit.getOnlinePlayers())
                {
                    TFM_Util.spawnMob(player, EntityType.HORSE, 2);
                }
                TFM_Util.adminAction(ChatColor.RED + sender_p.getName(), "YOU LIKE DAT ASS?", false);
            break;
            case "Typhlosion147":
                TFM_Util.bcastMsg("Incoming Oblivion!", ChatColor.RED);
                for (World world : Bukkit.getWorlds())
                {
                    for (Entity entity : world.getEntities())
                    {
                        if(entity instanceof LivingEntity && !(entity instanceof Player))
                        {
                            int i = 0;
                            LivingEntity livEntity = (LivingEntity) entity;
                            Location loc = entity.getLocation();
                            do
                            {
                                world.strikeLightningEffect(loc);

                                i++;
                            }
                            while (i <= 2);
                            livEntity.setHealth(0);
                        }
                    }
                    for (final Player player : server.getOnlinePlayers())
                    {
                        for (double percent = 0.0; percent <= 1.0; percent += (1.0 / STEPS))
                        {
                            final float pitch = (float) (percent * 2.0);

                            new BukkitRunnable()
                            {
                                @Override
                                public void run()
                                {
                                    player.playSound(randomOffset(player.getLocation(), 5.0), Sound.values()[random.nextInt(Sound.values().length)], 100.0f, pitch);
                                }
                            }.runTaskLater(plugin, Math.round(20.0 * percent * 2.0));
                        }
                    }
                }
            break;
            case "_GeneralOfGames_":
                TFM_Util.adminAction(sender_p.getName(), "Pies for all!", false);
                for(Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack pie = new ItemStack(Material.PUMPKIN_PIE, 1);
                    ItemMeta meta = pie.getItemMeta();
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "FREE PIE");
                    meta.addEnchant(Enchantment.FIRE_ASPECT, 25, true);
                    meta.addEnchant(Enchantment.KNOCKBACK, 10, true);
                    pie.setItemMeta(meta);
                    inv.addItem(pie);
                }
            break;
                case "myd":
                TFM_Util.adminAction(sender_p.getName(), "And we gonna let it burn burn burn burn!", true);
                for(Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack burn = new ItemStack(Material.FIRE, 1);
                    ItemMeta meta = burn.getItemMeta();
                    meta.setDisplayName(ChatColor.DARK_RED + "burn burn burn burn burn burn burn burn");
                    burn.setItemMeta(meta);
                    for (Enchantment ench : Enchantment.values())
                    {
                        burn.addUnsafeEnchantment(ench, 10000);
                    }
                    inv.addItem(burn);
                }
            break;
                case "weed":
                TFM_Util.adminAction(sender_p.getName(), "SMOKE WEED EVERY DAY!", true);
                for(Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack weed = new ItemStack(Material.DEAD_BUSH, 1);
                    ItemMeta meta = weed.getItemMeta();
                    World world = player.getWorld();
                    Location loc = player.getLocation();
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "WEED");
                    List<String> lore = Arrays.asList(ChatColor.LIGHT_PURPLE + "Don't do drugs kids. I never should have wrote this.");
                    meta.setLore(lore);
                    meta.addEnchant(Enchantment.FIRE_ASPECT, 10000, true);
                    meta.addEnchant(Enchantment.KNOCKBACK, 10000, true);
                    weed.setItemMeta(meta);
                    inv.addItem(weed);
                }
            break;
                case "minemagic1234":
                TFM_Util.adminAction(sender_p.getName(), "Oh oh oh, it's magic!", true);
                for(Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack magic = new ItemStack(Material.NETHER_STAR, 1);
                    ItemMeta meta = magic.getItemMeta();
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "MAGIC");
                    magic.setItemMeta(meta);
                    for (Enchantment ench : Enchantment.values())
                    {
                        magic.addUnsafeEnchantment(ench, 10000);
                    }
                    inv.addItem(magic);
                }
            break;
            case "book":
                for(Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack magic = new ItemStack(Material.ENCHANTED_BOOK, 1);
                    ItemMeta meta = magic.getItemMeta();
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "GIMME DA OP BOOK");
                    magic.setItemMeta(meta);
                    for (Enchantment ench : Enchantment.values())
                    {
                        magic.addUnsafeEnchantment(ench, 10000);
                    }
                    inv.addItem(magic);
                }
            break;
            case "Rex657":
                TFM_Util.bcastMsg("Rex is going on a rampage!", ChatColor.RED);
                TFM_Util.bcastMsg("Take this to kill him!", ChatColor.YELLOW);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
                    for (Enchantment ench : Enchantment.values())
                    {
                        sword.addUnsafeEnchantment(ench, 50);
                    }
                    inv.addItem(sword);
                }
            break;
            case "Blacklepoard":
                TFM_Util.adminAction(sender.getName(), "Quick! The god is above you!", true);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
                    ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
                    ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
                    ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1);
                    ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET, 1);
                    ItemStack bow = new ItemStack(Material.BOW, 1);
                    for (Enchantment ench : Enchantment.values())
                    {
                        sword.addUnsafeEnchantment(ench, 10000);
                    }
                    for (Enchantment ench : Enchantment.values())
                    {
                        bow.addUnsafeEnchantment(ench, 10000);
                    }
                    inv.addItem(bow);
                    inv.addItem(sword);
                    for (Enchantment ench : Enchantment.values())
                    {
                        chestplate.addUnsafeEnchantment(ench, 10000);
                    }
                    for (Enchantment ench : Enchantment.values())
                    {
                        leggings.addUnsafeEnchantment(ench, 10000);
                    }
                    for (Enchantment ench : Enchantment.values())
                    {
                        boots.addUnsafeEnchantment(ench, 10000);
                    }
                    for (Enchantment ench : Enchantment.values())
                    {
                        helmet.addUnsafeEnchantment(ench, 10000);
                    }
                    inv.setHelmet(helmet);
                    inv.setBoots(boots);
                    inv.setLeggings(leggings);
                    inv.setChestplate(chestplate);
                }
            break;
            case "multiEagle":
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack potato = new ItemStack(Material.POTATO_ITEM, 1);
                    ItemMeta meta = potato.getItemMeta();
                    List<String> lore = Arrays.asList(ChatColor.DARK_PURPLE + "It's dangerous to go alone; take this!");
                    meta.setLore(lore);
                    potato.setItemMeta(meta);
                    inv.addItem(potato);
                }
            break;
            case "TheLunarPrincess":
                StringBuilder output = new StringBuilder();
                Random randomGenerator = new Random();

                String[] words = "You have been given a Moonstone from the Moon Princess!".split(" ");
                for (String word : words)
                {
                    String color_code = Integer.toHexString(1 + randomGenerator.nextInt(14));
                    output.append(ChatColor.COLOR_CHAR).append(color_code).append(word).append(" ");
                }
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    TFM_Util.playerMsg(player, output.toString());
                    PlayerInventory inv = player.getInventory();
                    ItemStack moonstone = new ItemStack(Material.NETHER_STAR, 1);
                    ItemMeta meta = moonstone.getItemMeta();
                    List<String> lore = Arrays.asList(ChatColor.BLUE + "This mysterious stone", ChatColor.BLUE + "was given to you by", ChatColor.GOLD + "the Moon Princess!");
                    meta.setDisplayName(TFM_Util.randomChatColor() + "" + ChatColor.BOLD + "Moonstone");
                    meta.setLore(lore);
                    moonstone.setItemMeta(meta);
                    inv.addItem(moonstone);
                }
            break;
            case "Stampy100" :
            TFM_Util.adminAction("DarkDoge108", "Casting Doom Over All Doge Haters!", true);
            for (World world : Bukkit.getWorlds())
                {
                    for (Entity entity : world.getEntities())
                    {
                        if(entity instanceof LivingEntity && !(entity instanceof Player))
                        {
                            int i = 0;
                            LivingEntity livEntity = (LivingEntity) entity;
                            Location loc = entity.getLocation();
                            do
                            {
                                world.strikeLightningEffect(loc);

                                i++;
                            }
                            while (i <= 2);
                            livEntity.setHealth(0);
                        }
                        }
                    }
            break;
            case "Dev238":
                TFM_Util.adminAction(sender.getName(), "You have been DEV'D!!!", true);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    inv.addItem(new ItemStack(Material.SNOW_BALL, 1));
                }
            break;
            case "CrafterSmith12":
                TFM_Util.adminAction(sender_p.getName(), "Cookies for all! Don't let others take yours!", true);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack cookie = new ItemStack(Material.COOKIE, 1);
                    cookie.addUnsafeEnchantment(Enchantment.KNOCKBACK, 100);
                    ItemMeta meta = cookie.getItemMeta();
                    meta.setDisplayName(ChatColor.GREEN + "Crafter's Cookie!");
                    cookie.setItemMeta(meta);
                    inv.addItem(cookie);
                }
            break;
            case "lukkan99":
                TFM_Util.adminAction(sender.getName(), "When life gives you lemons, don't make lemonade! Make life take the lemons back! Get mad!", true);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack glados = new ItemStack(Material.POTATO_ITEM, 1);
                    ItemMeta meta = glados.getItemMeta();
                    meta.setDisplayName(TFM_Util.randomChatColor() + "" + ChatColor.BOLD + "GlaDOS");
                    glados.setItemMeta(meta);
                    inv.addItem(glados);
                }
            break;    
            case "robotexplorer":
                TFM_Util.adminAction(sender_p.getName(), "You think you can outsmart a robot? I think NOT!", true);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack robot = new ItemStack(Material.REDSTONE_BLOCK, 1);
                    ItemMeta meta = robot.getItemMeta();
                    meta.setDisplayName(ChatColor.RED + "Robot");
                    robot.setItemMeta(meta);
                    inv.addItem(robot);
                }
            break;
            case "harryMC":
                TFM_Util.adminAction(sender_p.getName(), "Behold! The SPEED DAEMON!", true);
                server.dispatchCommand(sender, "effect harryMC SPEED 10000 255");
            break;
            case "tylerhyperHD":
          if (!sender.getName().equals("tylerhyperHD"))
        {
            sender_p.setHealth(0.0);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("You cannot use my PSL you stupid fuck.");
                sender_p.setHealth(0.0);
            }
            break;
        }
            if (args.length == 0)
        {
                TFM_Util.adminAction(sender_p.getName(), "" + ChatColor.WHITE + ChatColor.BOLD + "Behold! The " + ChatColor.BLACK + ChatColor.BOLD + "LIE " + ChatColor.WHITE + ChatColor.BOLD + "GOD!", true);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack drobot = new ItemStack(Material.CAKE, 1);
                    ItemMeta meta = drobot.getItemMeta();
                    meta.setDisplayName("" + ChatColor.WHITE + ChatColor.BOLD + "THE" + ChatColor.BLACK + ChatColor.BOLD + " LIE " + ChatColor.WHITE + ChatColor.BOLD + "GOD");
                    drobot.setItemMeta(meta);
                    inv.addItem(drobot);
                }
                for (World world : Bukkit.getWorlds())
                {
                    for (Entity entity : world.getEntities())
                    {
                        if(entity instanceof LivingEntity && !(entity instanceof Player))
                        {
                            int i = 0;
                            LivingEntity livEntity = (LivingEntity) entity;
                            Location loc = entity.getLocation();
                            do
                            {
                                world.strikeLightningEffect(loc);

                                i++;
                            }
                            while (i <= 2);
                            livEntity.setHealth(0);
                        }
                    }
                    for (final Player player : server.getOnlinePlayers())
                    {
                        for (double percent = 0.0; percent <= 1.0; percent += (1.0 / STEPS))
                        {
                            final float pitch = (float) (percent * 2.0);

                            new BukkitRunnable()
                            {
                                @Override
                                public void run()
                                {
                                    player.playSound(randomOffset(player.getLocation(), 5.0), Sound.values()[random.nextInt(Sound.values().length)], 100.0f, pitch);
                                }
                            }.runTaskLater(plugin, Math.round(20.0 * percent * 2.0));
                        }
                    }
                }
            }
            break;
            case "Alex33856":
            TFM_Util.adminAction(sender_p.getName(), "Casting Doom All Over the World", true);
        for(Player player : Bukkit.getOnlinePlayers())
         {
            TFM_Util.bcastMsg(player.getName() + " has been a naughty, naughty boy.", ChatColor.GREEN);
            final Location targetPos = player.getLocation();
            final World world = player.getWorld();
            for (int x = -1; x <= 1; x++)
            {
            for (int z = -1; z <= 1; z++)
            {
                final Location strike_pos = new Location(world, targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
                world.strikeLightning(strike_pos);
            }
            }
            }
            TFM_Util.bcastMsg("Alex33856 - Has taken over the world!", ChatColor.RED);
            break;
            case "RedSea11001":
          if (!sender.getName().equals("RedSea11001") && !sender.getName().equals("tylerhyperHD"))
        {
            sender_p.setHealth(0.0);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("You cannot use my PSL you stupid fuck.");
                sender_p.setHealth(0.0);
            }
            break;
        }
            if (args.length == 0)
        {
           for(Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack wool = new ItemStack(Material.REDSTONE_BLOCK);
                    for (Enchantment ench : Enchantment.values())
                    {
                        wool.addUnsafeEnchantment(ench, 32767);
                    }
                    ItemMeta meta = wool.getItemMeta();
                    World world = player.getWorld();
                    Location loc = player.getLocation();
                    meta.setDisplayName(ChatColor.RED + "The Red Sea");
                    List<String> lore = Arrays.asList(ChatColor.RED + "The sea should keep you away from harm.");
                    meta.setLore(lore);
                    wool.setItemMeta(meta);
                    inv.setHelmet(wool);
                    world.strikeLightningEffect(loc);
                }
                TFM_Util.adminAction(ChatColor.RED + sender_p.getName(), "Gracing the world with seas of red!", false);
                    }
            break;
            case "cldoesmc":
          if (!sender.getName().equals("cldoesmc"))
        {
            sender.sendMessage("You cannot use my PSL you stupid fuck.");
            sender_p.setHealth(0.0);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("You cannot use my PSL you stupid fuck.");
                sender_p.setHealth(0.0);
            }
            break;
        }
            if (args.length == 0)
        {
                TFM_Util.adminAction(sender_p.getName(), "" + ChatColor.WHITE + ChatColor.BOLD + "Behold! The " + ChatColor.BLUE + ChatColor.BOLD + "WATER " + ChatColor.WHITE + ChatColor.BOLD + "GOD!", true);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack drobot = new ItemStack(Material.WATER, 1);
                    ItemMeta meta = drobot.getItemMeta();
                    meta.setDisplayName("" + ChatColor.WHITE + ChatColor.BOLD + "THE" + ChatColor.BLUE + ChatColor.BOLD + " WATER " + ChatColor.WHITE + ChatColor.BOLD + "GOD");
                    drobot.setItemMeta(meta);
                    inv.addItem(drobot);
                }
                for (World world : Bukkit.getWorlds())
                {
                    for (Entity entity : world.getEntities())
                    {
                        if(entity instanceof LivingEntity && !(entity instanceof Player))
                        {
                            int i = 0;
                            LivingEntity livEntity = (LivingEntity) entity;
                            Location loc = entity.getLocation();
                            do
                            {
                                world.strikeLightningEffect(loc);

                                i++;
                            }
                            while (i <= 2);
                            livEntity.setHealth(0);
                        }
                    }
                    for (final Player player : server.getOnlinePlayers())
                    {
                        for (double percent = 0.0; percent <= 1.0; percent += (1.0 / STEPS))
                        {
                            final float pitch = (float) (percent * 2.0);

                            new BukkitRunnable()
                            {
                                @Override
                                public void run()
                                {
                                    player.playSound(randomOffset(player.getLocation(), 5.0), Sound.values()[random.nextInt(Sound.values().length)], 100.0f, pitch);
                                }
                            }.runTaskLater(plugin, Math.round(20.0 * percent * 2.0));
                        }
                    }
                }
                break;
            }
            break;
            case "GigaByte_Jr":
                TFM_Util.asciiDog();
                TFM_Util.adminAction(sender_p.getName(), "Giving everyone a pet Woofie.\nTame them with the bone!", false);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    inv.addItem(new ItemStack(Material.BONE, 1));
                    LivingEntity dog = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.WOLF);
                    dog.setCustomNameVisible(true);
                    dog.setCustomName(ChatColor.DARK_AQUA + "Woofie!");
                }
            break;
            case "DeerBoo"  :
            for (Player player : Bukkit.getOnlinePlayers())
                {
            PlayerInventory inv = player.getInventory();
            inv.addItem(new ItemStack(Material.COOKIE, 1));
            TFM_Util.adminAction(sender_p.getName(), "There you go my deer", true);  
                }
            break;
            case "Ninjaristic":
                TFM_Util.asciiHorse();
                TFM_Util.bcastMsg("NEIGH", ChatColor.RED);
            break;
            case "0sportguy0":
                TFM_Util.adminAction(sender_p.getName(), "An apple a day keeps the doctor away!", false);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1));
                }
            break;
            case "lynxlps":
                TFM_Util.adminAction("Dahlia Hawthorne", "Eliminating all signs of life.", true);
                for (World world : Bukkit.getWorlds())
                {
                    for (Entity entity : world.getEntities())
                    {
                        if(entity instanceof LivingEntity && !(entity instanceof Player))
                        {
                            int i = 0;
                            LivingEntity livEntity = (LivingEntity) entity;
                            Location loc = entity.getLocation();
                            do
                            {
                                world.strikeLightningEffect(loc);

                                i++;
                            }
                            while (i <= 2);
                            livEntity.setHealth(0);
                        }
                    }
                    for (final Player player : server.getOnlinePlayers())
                    {
                        for (double percent = 0.0; percent <= 1.0; percent += (1.0 / STEPS))
                        {
                            final float pitch = (float) (percent * 2.0);

                            new BukkitRunnable()
                            {
                                @Override
                                public void run()
                                {
                                    player.playSound(randomOffset(player.getLocation(), 5.0), Sound.values()[random.nextInt(Sound.values().length)], 100.0f, pitch);
                                }
                            }.runTaskLater(plugin, Math.round(20.0 * percent * 2.0));
                        }
                    }
                }
            break;
            case "Lehctas":
                TFM_Util.adminAction(sender_p.getName(), "Giving everyone a wand that doesn't work", true);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack wand = new ItemStack(Material.STICK, 1);
                    ItemMeta meta = wand.getItemMeta();
                    meta.setDisplayName(ChatColor.DARK_PURPLE + "Void Wand");
                    List<String> lore = Arrays.asList(ChatColor.BLUE + "Void wand given by Lehctas, You wish you can use it. But haha. nerd. You can't only Lehctas can!");
                    meta.setLore(lore);
                    wand.setItemMeta(meta);
                    inv.addItem(wand);
                }
            case "aggelosQQ":
                TFM_Util.adminAction(sender_p.getName(), "Giving everyone a free egg! EGG FIGHT!", true);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack egg = new ItemStack(Material.EGG, 1);
                    ItemMeta meta = egg.getItemMeta();
                    meta.setDisplayName(ChatColor.DARK_GREEN + "eggelosQQ's" + ChatColor.AQUA + " Egg");
                    meta.addEnchant(Enchantment.KNOCKBACK, 320, true);
                    egg.setItemMeta(meta);
                    inv.addItem(egg);
                }   
            break;
            default:
                TFM_Util.playerMsg(sender, "Unfortunately, you do not have a personal command defined\nPlease contact tylerhyperHD to request a personal command or\ngo to http://alexfreedommc.proboards.com/ to go get one.", ChatColor.AQUA);  
            break;
        }
        return true;
    }
    
    private static final Random random = new Random();
    public static final double STEPS = 10.0;
    
    private static Location randomOffset(Location a, double magnitude)
    {
        return a.clone().add(randomDoubleRange(-1.0, 1.0) * magnitude, randomDoubleRange(-1.0, 1.0) * magnitude, randomDoubleRange(-1.0, 1.0) * magnitude);
    }

    private static Double randomDoubleRange(double min, double max)
    {
        return min + (random.nextDouble() * ((max - min) + 1.0));
    }
}
