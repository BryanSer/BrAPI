package Br.API.GUI.Ex.kt

import Br.API.GUI.Ex.BaseUI
import Br.API.GUI.Ex.Item
import Br.API.GUI.Ex.SnapshotFactory
import org.bukkit.entity.Player


abstract class KtUI private constructor(
        var playerInit: SnapshotFactoryInit? = null
) : BaseUI() {
    constructor(
            name: String,
            displayName: String,
            rows: Int,
            allowShift: Boolean = false,
            playerInit: SnapshotFactoryInit? = null
    ) : this(playerInit) {
        super.Name = name
        super.DisplayName = displayName
        super.Rows = rows
        super.AllowShift = allowShift
    }

    constructor(builder: KtUIBuilder) : this(
            builder.name,
            builder.displayName,
            builder.rows,
            builder.allowShift,
            builder.snapshotInit
    )

    var factory: SnapshotFactory<*> = SnapshotFactory.getDefaultSnapshotFactory(this, this.playerInit)


    override fun getSnapshotFactory(): SnapshotFactory<*> = factory
}