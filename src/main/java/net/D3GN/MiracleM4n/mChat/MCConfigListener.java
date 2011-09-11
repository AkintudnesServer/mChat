package net.D3GN.MiracleM4n.mChat;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.util.config.Configuration;

public class MCConfigListener {
    mChat plugin;
    Boolean hasChanged = false;

    public MCConfigListener(mChat plugin) {
        this.plugin = plugin;
    }

    protected void loadConfig() {
        Configuration config = plugin.mCConfig;
        config.load();

        plugin.censorMap.putAll(config.getAll());
    }

    protected void defaultConfig() {
        Configuration config = plugin.mCConfig;
        config.save();
        config.setHeader(
            "# mChat Censor file",
            ""
        );

        config.setProperty("fuck", "fawg");
        config.setProperty("god", "MiracleM4n");
        config.save();
    }
}
