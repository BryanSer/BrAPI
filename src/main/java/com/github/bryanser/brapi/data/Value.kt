package com.github.bryanser.brapi.data

interface Value<T> {
    fun getValue(): T
    @JvmDefault
    operator fun invoke(): T = getValue()
}

open class ValueProxy<T>(
        val namingspace: NamingSpace,
        val key: String,
        defaultValue: T
) : Value<T> {
    protected var data: T = defaultValue

    init {
        namingspace.proxy[key] = this
        namingspace.reload()
    }

    open fun load() {
        if (!namingspace.config.contains(key)) {
            namingspace.config[key] = data
            namingspace.save()
        }
        data = namingspace.config.get(key, data) as T
    }

    override fun getValue(): T = data

    override fun invoke(): T = getValue()
}

class ConstProxy<T>(val t: T) : Value<T> {
    override fun getValue(): T = t
}