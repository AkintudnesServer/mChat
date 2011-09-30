package net.D3GN.MiracleM4n.mChat;

import java.util.Map;
import java.util.regex.Pattern;

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

        for (Map.Entry<String, Object> entry : config.getAll().entrySet()) {
            plugin.censorMap.put(Pattern.compile(
                    "\\b" + Pattern.quote(entry.getKey()) + "\\b",
                    Pattern.CASE_INSENSITIVE), entry.getValue().toString());
        }
    }

    protected void defaultConfig() {
        Configuration config = plugin.mCConfig;
        config.save();
        config.setHeader("# mChat Censor file", "");

        config.setProperty("fuck", "fawg");
        config.setProperty("god", "MiracleM4n");
        config.save();
    }
}
