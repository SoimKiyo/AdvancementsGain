package com.forgotdot.advancementsgain;

import com.forgotdot.advancementscore.events.CustomAchievementCompleteEvent;
import com.forgotdot.advancementscore.data.Team;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.UUID;

/**
 * Listens for achievement completion events and grants rewards.
 * Supports both individual and team-based rewards.
 */
public class EventListener implements Listener {

    private final AdvancementsGain plugin;

    /**
     * Constructor to initialize the event listener.
     *
     * @param plugin The main plugin instance.
     */
    public EventListener(AdvancementsGain plugin) {
        this.plugin = plugin;
    }

    /**
     * Handles the event when a player completes an achievement.
     * Grants rewards based on the configuration.
     *
     * @param event The event triggered when a player completes an achievement.
     */
    @EventHandler
    public void onCustomAchievementComplete(CustomAchievementCompleteEvent event) {
        Player player = event.getPlayer();
        String achievementId = event.getAchievement().getId();
        Team team = event.getTeam();

        // Retrieve the specific reward configuration for the achievement
        ConfigurationSection rewardSection = plugin.getPluginConfig().getConfigurationSection("rewards." + achievementId);

        boolean hasSpecificRewards = rewardSection != null;
        boolean teamReward = hasSpecificRewards && rewardSection.getString("mode", "player").equalsIgnoreCase("team");

        // Always grant general rewards (applies to all achievements)
        plugin.getRewardManager().giveGeneralRewards(player);

        // Handle team rewards
        if (teamReward && team != null) {
            for (UUID memberUUID : team.getMembers()) {
                Player teamMember = Bukkit.getPlayer(memberUUID);
                if (teamMember != null) {
                    if (hasSpecificRewards) {
                        plugin.getRewardManager().giveReward(teamMember, achievementId);
                    }
                }
            }
        }
        // Handle individual player rewards
        else if (hasSpecificRewards) {
            plugin.getRewardManager().giveReward(player, achievementId);
        }
    }
}
