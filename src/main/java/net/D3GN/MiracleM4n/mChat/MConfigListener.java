package net.D3GN.MiracleM4n.mChat;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.util.config.Configuration;

import java.util.logging.Level;

public class MConfigListener {
    mChat plugin;
    Boolean hasChanged = false;

    public MConfigListener(mChat plugin) {
        this.plugin = plugin;
    }

    protected void loadConfig() {
        Configuration config = plugin.mConfig;
        config.load();

        plugin.chatFormat = config.getString("mchat-message-format", plugin.chatFormat);
        plugin.nameFormat = config.getString("mchat-name-format", plugin.nameFormat);
        plugin.joinFormat = config.getString("mchat-playerEvent-format", plugin.joinFormat);
        plugin.dateFormat = config.getString("mchat-date-format", plugin.dateFormat);
        plugin.joinMessage = config.getString("mchat-join-message", plugin.joinMessage);
        plugin.leaveMessage = config.getString("mchat-leave-message", plugin.leaveMessage);
        plugin.kickMessage = config.getString("mchat-kick-message", plugin.kickMessage);
        plugin.mAPI_Only_Mode = config.getBoolean("mchat-API-only", plugin.mAPI_Only_Mode);
    }

    protected void defaultConfig() {
        Configuration config = plugin.mConfig;
        config.save();
        config.setHeader(
            "# mChat configuration file",
            "# ",
            "#           **IMPORTANT**",
            "#   usage of mchat-message-format can be, but is not limited to",
            "#       +suffix,+s, +prefix,+p, +group,+g, +world,+w, +time,+t, +name,+n, +dname,+dn, +health,+h +healthbar,+hb, +message,+msg,+m",
            "#       Suffix, Prefix, Group, World, Time, Player Name, Player Display Name, Health, Health Bar, Message",
            ""
        );

        config.setProperty("mchat-date-format", plugin.dateFormat);
        config.setProperty("mchat-message-format", plugin.chatFormat);
        config.setProperty("mchat-name-format", plugin.nameFormat);
        config.setProperty("mchat-playerEvent-format", plugin.joinFormat);
        config.setProperty("mchat-join-message", plugin.joinMessage);
        config.setProperty("mchat-leave-message", plugin.leaveMessage);
        config.setProperty("mchat-kick-message", plugin.kickMessage);
        config.setProperty("mchat-API-only", plugin.mAPI_Only_Mode);
        config.save();
    }

    protected void checkConfig() {
        Configuration config = plugin.mConfig;
        PluginDescriptionFile pdfFile = plugin.getDescription();
        config.load();

        if (config.getProperty("mchat-date-format") == null) {
            config.setProperty("mchat-date-format", plugin.dateFormat);
            hasChanged = true;
        }

        if (config.getProperty("mchat-message-format") == null) {
            config.setProperty("mchat-message-format", plugin.chatFormat);
            hasChanged = true;
        }

        if (config.getProperty("mchat-name-format") == null) {
            config.setProperty("mchat-name-format", plugin.nameFormat);
            hasChanged = true;
        }

        if (config.getProperty("mchat-playerEvent-format") == null) {
            config.setProperty("mchat-playerEvent-format", plugin.joinFormat);
            hasChanged = true;
        }

        if (config.getProperty("mchat-join-message") == null) {
            config.setProperty("mchat-join-message", plugin.joinMessage);
            hasChanged = true;
        }

        if (config.getProperty("mchat-leave-message") == null) {
            config.setProperty("mchat-leave-message", plugin.leaveMessage);
            hasChanged = true;
        }

        if (config.getProperty("mchat-kick-message") == null) {
            config.setProperty("mchat-kick-message", plugin.kickMessage);
            hasChanged = true;
        }

        if (config.getProperty("mchat-API-only") == null) {
            config.setProperty("mchat-API-only", plugin.mAPI_Only_Mode);
            hasChanged = true;
        }

        if (hasChanged) {
            config.setHeader(
            "# mChat configuration file",
                 "# ",
                "#           **IMPORTANT**",
                "#   usage of mchat-message-format can be, but is not limited to",
                "#       +suffix,+s, +prefix,+p, +group,+g, +world,+w, +time,+t, +name,+n, +dname,+dn, +health,+h +healthbar,+hb, +message,+msg,+m",
                "#       Suffix, Prefix, Group, World, Time, Player Name, Player Display Name, Health, Health Bar, Message",
                ""
            );

            plugin.console.log(Level.INFO, "[" + pdfFile.getName() + "]" + " config.yml has been updated.");
            config.save();
        }
    }
}
