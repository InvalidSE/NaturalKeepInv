package me.invalidse.naturalkeepinv;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public final class NaturalKeepInv extends JavaPlugin {

    @Override
    public void onEnable() {

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getMainScoreboard();
        Team KeepInv = board.registerNewTeam("keep_inventory");
        KeepInv.setDisplayName("Keep Inventory");

        System.out.println("NaturalKeepInv by InvalidSE Enabled (InvalidSE on Discord)");
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new Listeners(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
