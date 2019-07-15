package com.github.bryanser.brapi.ui


fun ui(init: UI.() -> Unit): UI {
    val ui = UI()
    ui.init()
    return ui
}

fun test() {
    ui {
        name("test")
        displayName { "测试" }
        rows { 1 }
    }
}


class UI : UIBase() {
    lateinit var name: String
    lateinit var displayName: String
    var rows: Int = 6
    var allowShift: Boolean = false
    fun allowShift(shift: Boolean): UI {
        this.allowShift = shift
        return this
    }

    fun allowShift(allowShift: () -> Boolean): UI {
        allowShift(allowShift())
        return this
    }

    fun name(name: String): UI {
        this.name = name
        return this
    }

    fun name(name: () -> String): UI {
        name(name())
        return this
    }


    fun displayName(name: String): UI {
        displayName = name
        return this
    }

    fun displayName(displayName: () -> String): UI {
        displayName(displayName())
        return this
    }

    fun rows(r: Int): UI {
        this.rows = r
        return this
    }

    fun rows(rows: () -> Int): UI {
        rows(rows())
        return this
    }
}