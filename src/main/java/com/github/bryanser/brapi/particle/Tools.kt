package com.github.bryanser.brapi.particle

import com.comphenix.protocol.ProtocolLibrary

fun getVersion():Int{
    val version = ProtocolLibrary.getProtocolManager().minecraftVersion
    return version.minor
}
fun isVer14():Boolean = getVersion() >= 14