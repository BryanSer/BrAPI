package com.github.bryanser.brapi.util

import org.bukkit.OfflinePlayer

/**
 * 使依赖brapi的插件免去直接依赖papi
 *
 */
interface IPlaceholderExpansion{
    fun registerPlaceholder():Boolean
    fun unregisterPlaceholder():Boolean
    fun onRequest(player: OfflinePlayer?, params: String): String
}