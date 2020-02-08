package com.github.bryanser.brapi

import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta


operator fun ItemStack.unaryPlus(): ItemMeta = this.itemMeta
operator fun ItemStack.plusAssign(im: ItemMeta) {
    this.itemMeta = im
}

infix fun Player.msg(msg: String) {
    this.sendMessage(msg)
}