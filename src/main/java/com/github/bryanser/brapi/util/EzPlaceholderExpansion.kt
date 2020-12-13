package com.github.bryanser.brapi.util

import me.clip.placeholderapi.PlaceholderAPI
import me.clip.placeholderapi.expansion.PlaceholderExpansion
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import org.bukkit.plugin.Plugin

class EzPlaceholderExpansion(
        plugin: Plugin,
        private val identifier: String,
        val onRequest: (player: OfflinePlayer?, key: String) -> String?
) : PlaceholderExpansion(), IPlaceholderExpansion {
    private val author: String
    private val version: String


    override fun getIdentifier(): String = identifier

    override fun getAuthor(): String = author

    override fun getVersion(): String = version

    init {
        val pd = plugin.description
        author = pd.authors?.toString() ?: "no author"
        version = pd.version
    }

    override fun persist(): Boolean = true

    override fun canRegister(): Boolean = true

    override fun onRequest(player: OfflinePlayer?, params: String): String {
        return this.onRequest.invoke(player, params) ?: " "
    }

    companion object {
        /**
         * 注册PAPI扩展
         *
         * @param plugin
         * @param identifier
         * @param onRequest
         */
        fun registerPlaceholder(plugin: Plugin, identifier: String, onRequest: (player: OfflinePlayer?, key: String) -> String?) {
            if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
                EzPlaceholderExpansion(plugin, identifier, onRequest).register()
            }
        }

        /**
         * 返回papi扩展(不会注册的)
         *
         * @param plugin
         * @param identifier
         * @param onRequest
         * @return 如果服务器没有安装PAPI则返回null
         */
        fun createPlaceholder(plugin: Plugin, identifier: String, onRequest: (player: OfflinePlayer?, key: String) -> String?): IPlaceholderExpansion? {
            return if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
                EzPlaceholderExpansion(plugin, identifier, onRequest)
            } else {
                null
            }
        }

        fun setPlaceholder(p: OfflinePlayer, str: String): String {
            if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
                return PlaceholderAPI.setPlaceholders(p,str)
            }
            return str
        }
    }

    override fun registerPlaceholder(): Boolean = register()

    override fun unregisterPlaceholder(): Boolean = unregister()
}