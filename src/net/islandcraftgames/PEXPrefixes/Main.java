package net.islandcraftgames.PEXPrefixes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import ru.tehkode.permissions.events.PermissionEntityEvent;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		PEXUpdate();
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	@Override
	public void onDisable() {
	}

	@EventHandler
	public void onPEXUpdate(PermissionEntityEvent e) {
		PEXUpdate();
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		PEXUpdate();
	}

	public void PEXUpdate() {
		if (Bukkit.getOnlinePlayers().size() != 0) {
			for (Player p : Bukkit.getOnlinePlayers()) {
				PermissionUser pu = PermissionsEx.getUser(p);

				String prefix = pu.getPrefix();
				if (prefix == null)
					prefix = "";
				String suffix = pu.getSuffix();
				if (suffix == null)
					suffix = "";
				p.setDisplayName(ChatColor.translateAlternateColorCodes('&',
						prefix + p.getName() + suffix + ChatColor.RESET));
			}
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (sender.hasPermission("pexprefixes.update")) {
			PEXUpdate();
			sender.sendMessage(ChatColor.GREEN + "Prefixes and suffixes reloaded!");
			return true;
		}
		sender.sendMessage(ChatColor.RED + "No permission.");
		return false;
	}

}
