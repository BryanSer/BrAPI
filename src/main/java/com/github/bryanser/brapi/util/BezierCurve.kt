package com.github.bryanser.brapi.util

import com.github.bryanser.brapi.Utils
import org.bukkit.Location
import org.bukkit.util.Vector

class BezierCurve(
        vararg val lines: BaseLine
) {

    interface BaseLine {
        fun at(center: Location, rate: Double): Location
    }

    class RelativeLine(//以朝向的方向为z 右边为x 上方为y
            val from: Vector,
            val to: Vector
    ) : BaseLine {
        override fun at(center: Location, rate: Double): Location {
            val length = to.distance(from)

            val z = center.direction.let { it.y = 0.0;it.normalize(); }
            val x = Utils.getRight(z)
            val y = Vector(0.0, 1.0, 0.0)
            val from = center.clone()
                    .add(x.clone().multiply(from.x))
                    .add(y.clone().multiply(from.y))
                    .add(z.clone().multiply(from.z))
            val vec = to.clone().subtract(this.from.clone())
            val v = length * rate
            return from.clone().add(vec.multiply(v))
        }

    }

    class FixLine(
            val from: Location,
            val to: Location
    ) : BaseLine {
        init {
            if (from.world !== to.world) {
                throw IllegalArgumentException("提供的两个坐标必须在同一个世界")
            }
        }

        val length = to.distance(from)
        val vec = to.toVector().subtract(from.toVector())
            get() = field.clone()

        override fun at(center: Location, rate: Double): Location {
            if (center.world !== from.world) {
                throw IllegalArgumentException("观测者和绘制世界不一致")
            }
            val v = length * rate
            return from.clone().add(vec.multiply(v))
        }
    }

    @JvmOverloads
    inline fun draw(center: Location, p: Double = 0.01, draw: (Location) -> Unit) {
        var curr = 0.0
        while (curr <= 1.0) {
            var lastPos: Location? = null
            for (l in lines) {
                if (lastPos == null) {
                    lastPos = l.at(center, curr)
                } else {
                    val next = l.at(center, curr)
                    val vec = next.toVector().subtract(lastPos.toVector())
                    val length = vec.length()
                    vec.normalize()
                    lastPos = lastPos.add(vec.multiply(length * curr))
                }
            }
            if (lastPos == null) {
                throw IllegalStateException("未定义线段")
            }
            draw(lastPos)
            curr += p
        }
    }
}