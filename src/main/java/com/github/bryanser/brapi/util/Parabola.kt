package com.github.bryanser.brapi.util

import org.bukkit.Location
import org.bukkit.util.Vector
import kotlin.math.cos
import kotlin.math.sin

class Parabola(loc1: Location, loc2: Location, loc3: Location) {
    val center = loc1.clone()
        get() = field.clone()
    val x: Vector = loc3.toVector().subtract(loc1.toVector()).normalize()
        get() = field.clone()
    val y: Vector
        get() = field.clone()
    val a: Double
    val b: Double
    val x_length: Double

    inline fun draw(p: Double = 0.05, consumer: (Location) -> Unit) {
        var tx = 0.0
        while (tx <= x_length) {
            val ty = a * tx * tx + b * tx
            val loc = center.add(x.multiply(tx)).add(y.multiply(ty))
            consumer(loc)
            tx += p
        }
    }

    init {
        val z = x.getCrossProduct(loc2.toVector().subtract(center.toVector()).normalize())
        y = z.getCrossProduct(x)
        val vectop = loc2.toVector().subtract(center.toVector())
        val topa = vectop.angle(x)
        val topl = vectop.length()
        val ux = topl * cos(topa)
        val uy = topl * sin(topa)
        val dx = loc3.toVector().subtract(loc1.toVector()).length()
        x_length = dx
        val u = Vector(ux * ux, ux, uy)
        val d = Vector(dx * dx, dx, 0.0)
        u.multiply(dx)
        d.multiply(ux)
        val t = u.subtract(d)
        a = t.z / t.x
        b = -a * dx
    }

    val projection: (x: Double, y: Double) -> Location by lazy {
        { tx: Double, ty: Double ->
            center.add(x.multiply(tx)).add(y.multiply(ty))
        }
    }


}