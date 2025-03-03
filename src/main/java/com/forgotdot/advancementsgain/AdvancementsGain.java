package com.forgotdot.advancementsgain;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Main class for the AdvancementsGain plugin.
 * Handles plugin initialization, configuration loading, and economy setup.
 */
public class AdvancementsGain extends JavaPlugin {

    private static AdvancementsGain instance;
    private Economy econ;
    private File configFile;
    private FileConfiguration config;
    private RewardManager rewardManager;

    /**
     * Retrieves the singleton instance of the plugin.
     *
     * @return The instance of AdvancementsGain.
     */
    public static AdvancementsGain getInstance() {
        return instance;
    }

    /**
     * Called when the plugin is enabled.
     * Initializes the economy system (if Vault is available),
     * loads the configuration, and registers event listeners and commands.
     */
    @Override
    public void onEnable() {
        instance = this;

        // Initialize Vault economy if available
        if (setupEconomy()) {
            getLogger().info("Vault detected, economy support enabled.");
        } else {
            getLogger().warning("Vault not found, economy support disabled.");
        }

        // Load the configuration file
        loadConfig();

        // Initialize the reward manager
        this.rewardManager = new RewardManager(this);

        // Register event listeners and commands
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new EventListener(this), this);
        getCommand("advancementsgain").setExecutor(new CommandAdvancementsGain(this));

        getLogger().info("AdvancementsGain successfully enabled!");
    }

    /**
     * Called when the plugin is disabled.
     * Used for cleanup tasks if necessary.
     */
    @Override
    public void onDisable() {
        getLogger().info("AdvancementsGain has been disabled.");
    }

    /**
     * Attempts to set up the economy system using Vault.
     * If Vault is not installed or no economy provider is found, economy features will be disabled.
     *
     * @return true if Vault is successfully linked, false otherwise.
     */
    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        econ = (rsp == null) ? null : rsp.getProvider();
        return econ != null;
    }

    /**
     * Loads or creates the configuration file for the plugin.
     * If the file does not exist, a default version is copied from the plugin's resources.
     */
    public void loadConfig() {
        configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            saveResource("config.yml", false);
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    /**
     * Reloads the plugin's configuration file.
     * This method is called when the "/advancementsgain reload" command is used.
     */
    public void reloadPluginConfig() {
        config = YamlConfiguration.loadConfiguration(configFile);
        getLogger().info("Configuration successfully reloaded.");
    }

    /**
     * Retrieves the current plugin configuration.
     *
     * @return The plugin's FileConfiguration object.
     */
    public FileConfiguration getPluginConfig() {
        return config;
    }

    /**
     * Retrieves the economy instance (Vault).
     *
     * @return The economy provider if available, null otherwise.
     */
    public Economy getEconomy() {
        return econ;
    }

    /**
     * Retrieves the reward manager instance.
     *
     * @return The RewardManager instance handling rewards.
     */
    public RewardManager getRewardManager() {
        return rewardManager;
    }
}
