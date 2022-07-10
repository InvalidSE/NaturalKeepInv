package me.invalidse.naturalkeepinv;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class Listeners implements Listener {

    ScoreboardManager manager = Bukkit.getScoreboardManager();
    Scoreboard board = manager.getMainScoreboard();
    Team KeepInv = board.getTeam("keep_inventory");

    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        if(KeepInv.getEntries().contains(event.getEntity().getPlayer().getDisplayName())){
            if(event.getEntity().getKiller() != null) {
                event.setKeepInventory(false);
            } else {
                event.setKeepInventory(true);
                event.getDrops().clear();
                event.getEntity().getPlayer().setExp(0);
            }
        }
    }
}
