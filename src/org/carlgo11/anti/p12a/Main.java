package org.carlgo11.anti.p12a;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.carlgo11.anti.p12a.Language.Lang;
import org.carlgo11.anti.p12a.Language.loadlang;
import org.carlgo11.anti.p12a.Listener.BlockListener;
import org.carlgo11.anti.p12a.Listener.ChatListener;
import org.carlgo11.anti.p12a.Listener.CommandListener;
import org.carlgo11.anti.p12a.Listener.JoinListener;
import org.carlgo11.anti.p12a.Listener.MoveListener;

import java.io.*;
import java.util.ArrayList;

public class Main extends JavaPlugin
{
    public String pre;
    public String Difficulty;
    ArrayList<String> names;
    public ArrayList<String> randomText;
    public static YamlConfiguration LANG;
    public static File LANG_FILE;

    @Override
    public void onEnable()
    {
        checkConfig();
        loadFile();

        Difficulty = this.getConfig().getString("Difficulty");

        getServer().getPluginManager().registerEvents(new loadlang(this), this);
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getServer().getPluginManager().registerEvents(new ChatListener(this), this);
        getServer().getPluginManager().registerEvents(new MoveListener(this), this);
        getServer().getPluginManager().registerEvents(new CommandListener(this), this);
        getServer().getPluginManager().registerEvents(new BlockListener(this), this);
    }

    @Override
    public void onDisable()
    {
    }

    public void checkConfig() {
        File config = new File(this.getDataFolder(), "config.yml");
        if (!config.exists()) {
            this.saveDefaultConfig();
            System.out.println("[" + getDescription().getName() + "] " + "No config.yml detected, config.yml created.");
        }
    }

    public YamlConfiguration getLang() {
        return LANG;
    }

    public File getLangFile() {
        return LANG_FILE;
    }

    public void loadFile(){
        try
        {
            File file = new File(getDataFolder() + "/names.txt");
            file.createNewFile();
            BufferedReader read = new BufferedReader(new FileReader(file));
            String line;
            while ((line = read.readLine()) != null) {
                if  (!names.contains(line.toString())){
                    names.add(line.toString());
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(){
        try {
            File file = new File(getDataFolder() + "/names.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter write = new PrintWriter(file, "UTF-8");

            for (int i = 0; i < names.size(); i++)
            {
                write.println(names.get(i));
            }
            write.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void helpMessage(CommandSender p){
        p.sendMessage(ChatColor.GREEN + "======== " + Lang.prefix.toString() + ChatColor.GREEN + " ======== ");
        p.sendMessage(ChatColor.GRAY + "-  /" + ChatColor.RED + "Antip12a " + Lang.antip12a.toString());
        p.sendMessage(ChatColor.GRAY + "-  /" + ChatColor.RED + "Antip12a help " + Lang.antip12a.toString());
        p.sendMessage(ChatColor.GRAY + "-  /" + ChatColor.RED + "Antip12a reload " + Lang.antip12a_reload.toString());
        p.sendMessage(ChatColor.GRAY + "-  /" + ChatColor.RED + "Antip12a verify <player> " + Lang.antip12a_verify.toString());
        p.sendMessage(ChatColor.GRAY + "-  /" + ChatColor.RED + "Antip12a check <player> " + Lang.antip12a_check.toString());

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            sender.sendMessage(Lang.console_error.toString());
            return true;
        }
        else
        {
            String perm = Lang.prefix.toString() + Lang.permission.toString();

            if (command.getName().equalsIgnoreCase("antip12a"))
            {
                if (args.length == 0)
                {
                    if (sender.hasPermission("antip12a.help"))
                    {
                        helpMessage(sender);
                        return true;
                    }
                    else
                    {
                        sender.sendMessage(perm);
                        return true;
                    }
                }
                else if (args.length == 1)
                {
                    if (args[0].equalsIgnoreCase("verify"))
                    {
                        helpMessage(sender);
                        return true;
                    }
                    else if (args[0].equalsIgnoreCase("check"))
                    {
                        sender.sendMessage(ChatColor.GRAY + "-  /" + ChatColor.RED + "Antip12a check" + ChatColor.RED + " <player>");
                        return true;
                    }
                    else if (args[0].equalsIgnoreCase("help"))
                    {
                        helpMessage(sender);
                        return true;
                    }
                    else
                    {
                        helpMessage(sender);
                        return true;
                    }
                }
                else if (args.length == 2)
                {
                    if (args[0].equalsIgnoreCase("verify"))
                    {
                        if (sender.hasPermission("antip12a.verify"))
                        {
                            if (names.contains(args[1]))
                            {
                                sender.sendMessage(Lang.prefix.toString() + Lang.verify_already.toString());
                                return true;
                            }
                            else
                            {
                                names.add(args[1]);
                                save();
                                sender.sendMessage(Lang.prefix.toString() + Lang.verify_confirmed.toString().replace("%p", args[1]));
                                return true;
                            }
                        }
                        else
                        {
                            sender.sendMessage(perm);
                            return true;
                        }
                    }
                    else if (args[0].equalsIgnoreCase("check"))
                    {
                        if (sender.hasPermission("antip12a.check"))
                        {
                            if (names.contains(args[1]))
                            {
                                sender.sendMessage(Lang.prefix.toString() + Lang.check_verified.toString().replace("%p", args[1]));
                                return true;
                            }
                            else
                            {
                                sender.sendMessage(Lang.prefix.toString() + Lang.check_no_verified.toString().replace("%p", args[1]));
                                return true;
                            }
                        }
                        else
                        {
                            sender.sendMessage(perm);
                            return true;
                        }
                    }
                }
                else
                {
                    helpMessage(sender);
                    return true;
                }
            }
            if (command.getName().equalsIgnoreCase("verify"))
            {
                if(args.length != 1)
                {
                    sender.sendMessage(Lang.prefix.toString() + Lang.verify_derp.toString());
                    return true;
                }
                else
                {
                    if (randomText.contains(sender.toString()))
                    {
                        int Line = randomText.indexOf(sender.toString());
                        String s = randomText.get(Line);
                        String y = sender + " " + args[0];
                        Player p = (Player) sender;
                        Location loc = p.getLocation();
                        World w = p.getWorld();
                        double locX = loc.getX();
                        double locY = loc.getY();
                        double locZ = loc.getZ();
                        if(y.equalsIgnoreCase(s))
                        {
                            randomText.remove(Line);
                            names.add(sender.toString());
                            save();

                            sender.sendMessage(Lang.prefix.toString() + Lang.nop12a.toString());
                            return true;
                        }
                        else
                        {
                            sender.sendMessage(Lang.prefix.toString() + Lang.verify_derp.toString());
                            w.createExplosion(loc, 0F, false);
                            p.damage(0.5);
                            return true;
                        }
                    }
                    else
                    {
                        sender.sendMessage(Lang.prefix.toString() + Lang.verify_derp.toString());
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
