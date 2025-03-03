package com.forgotdot.advancementsgain;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

/**
 * Manages the rewards given to players upon completing achievements.
 * Supports XP, money (Vault), items (with meta support), effects, and commands.
 */
public class RewardManager {

    private final AdvancementsGain plugin;

    /**
     * Constructor to initialize the reward manager.
     *
     * @param plugin The main plugin instance.
     */
    public RewardManager(AdvancementsGain plugin) {
        this.plugin = plugin;
    }

    /**
     * Grants rewards for a specific achievement to a player.
     *
     * @param player        The player receiving the reward.
     * @param achievementId The ID of the completed achievement.
     */
    public void giveReward(Player player, String achievementId) {
        ConfigurationSection rewardSection = plugin.getPluginConfig().getConfigurationSection("rewards." + achievementId);
        if (rewardSection != null) {
            applyRewards(player, rewardSection);
        }
    }

    /**
     * Grants general rewards to a player (applies to all achievements).
     *
     * @param player The player receiving the general rewards.
     */
    public void giveGeneralRewards(Player player) {
        ConfigurationSection generalSection = plugin.getPluginConfig().getConfigurationSection("general_rewards");
        if (generalSection != null) {
            applyRewards(player, generalSection);
        }
    }

    /**
     * Processes and applies different types of rewards to the player.
     *
     * @param player        The player receiving the rewards.
     * @param rewardSection The configuration section containing the reward details.
     */
    private void applyRewards(Player player, ConfigurationSection rewardSection) {
        // Grant XP
        if (rewardSection.contains("xp")) {
            int xpAmount = rewardSection.getInt("xp");
            player.giveExp(xpAmount);
        }

        // Grant Money (if Vault is enabled)
        if (rewardSection.contains("money") && plugin.getEconomy() != null) {
            double moneyAmount = rewardSection.getDouble("money");
            plugin.getEconomy().depositPlayer(player, moneyAmount);
        }

        // Grant Items with metadata support
        if (rewardSection.contains("items")) {
            List<String> items = rewardSection.getStringList("items");
            for (String itemData : items) {
                String[] parts = itemData.split(":");
                if (parts.length < 2) continue;

                Material material = Material.matchMaterial(parts[0]);
                int amount = Integer.parseInt(parts[1]);

                if (material != null) {
                    ItemStack itemStack = new ItemStack(material, amount);
                    ItemMeta meta = itemStack.getItemMeta();

                    // Process additional metadata (enchantments, custom names, etc.)
                    for (int i = 2; i < parts.length; i++) {
                        String[] metaData = parts[i].split("_");
                        if (metaData.length == 2) {
                            try {
                                meta.addEnchant(org.bukkit.enchantments.Enchantment.getByName(metaData[0].toUpperCase()), Integer.parseInt(metaData[1]), true);
                            } catch (Exception ignored) {}
                        }
                    }

                    itemStack.setItemMeta(meta);
                    player.getInventory().addItem(itemStack);
                }
            }
        }

        // Apply Potion Effects
        if (rewardSection.contains("effects")) {
            List<String> effects = rewardSection.getStringList("effects");
            for (String effectData : effects) {
                String[] parts = effectData.split(":");
                if (parts.length != 3) continue;

                PotionEffectType effectType = PotionEffectType.getByName(parts[0].toUpperCase());
                int duration = Integer.parseInt(parts[1]) * 20; // Convert seconds to ticks
                int amplifier = Integer.parseInt(parts[2]);

                if (effectType != null) {
                    player.addPotionEffect(new PotionEffect(effectType, duration, amplifier));
                }
            }
        }

        // Execute Commands
        if (rewardSection.contains("commands")) {
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            for (String command : rewardSection.getStringList("commands")) {
                Bukkit.dispatchCommand(console, command.replace("{player}", player.getName()));
            }
        }
    }
}
