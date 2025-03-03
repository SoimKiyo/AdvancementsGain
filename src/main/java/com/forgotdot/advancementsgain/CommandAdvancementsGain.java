package com.forgotdot.advancementsgain;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Command handler for "/advancementsgain reload".
 * This command allows admins to reload the plugin configuration.
 */
public class CommandAdvancementsGain implements CommandExecutor {

    private final AdvancementsGain plugin;

    public CommandAdvancementsGain(AdvancementsGain plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("advancementsgain.admin")) {
                sender.sendMessage(plugin.getPluginConfig().getString("messages.no_permission"));
                return false;
            }

            plugin.reloadPluginConfig();
            sender.sendMessage(plugin.getPluginConfig().getString("messages.reload_success"));
            return true;
        }

        sender.sendMessage(plugin.getPluginConfig().getString("messages.usage"));
        return false;
    }
}
