package com.github.bryanser.brapi.kview

import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder

abstract class KViewHolder() : InventoryHolder {


    lateinit var kView: KView<KViewHolder>
    lateinit var player: Player

    protected lateinit var inv: Inventory

    override fun getInventory(): Inventory = inv

}