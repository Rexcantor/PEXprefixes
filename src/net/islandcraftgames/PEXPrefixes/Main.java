package net.islandcraftgames.PEXPrefixes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import ru.tehkode.permissions.events.PermissionEntityEvent;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
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
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	@Override
	public void onDisable() {
	}

	@EventHandler
	public void onPEXUpdate(PermissionEntityEvent e) {
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

}
