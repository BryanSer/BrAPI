package com.github.bryanser.brapi.kview

import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder

abstract class KViewContext(
        var title: String
) : InventoryHolder {


    lateinit var kView: KView<KViewContext>
    lateinit var player: Player
    internal lateinit var inv: Inventory

    var closed = false

    override fun getInventory(): Inventory = inv

}