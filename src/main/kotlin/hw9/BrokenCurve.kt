package hw9

import kotlin.math.*

class BrokenCurve(a: Point, b: Point, val c: Point) : Line(a, b) {
    override fun len() = b.distance(a) + b.distance(c)

    /**
     * через теорему косинусов по трем сторонам треугольник можно найти угол
     * находим три длины сторон треугольника
     * уравнение cos(угла) = (a2 + b2 - c2)/(2*a*b)
     * через арккосинус найдем угол
     */
    fun angleMiddle(): Double {
        val lenAB2 = a.distanceSq(b)
        val lenBC2 = b.distanceSq(c)
        val lenAC2 = a.distanceSq(c)

        val cos = (lenAB2 + lenBC2 - lenAC2) / (2 * sqrt(lenAB2) * sqrt(lenBC2))

        return acos(cos)
    }

    override fun toString(): String {
        return "Line : (x=$a.x, y=$a.y) - (x=$b.x, y=$b.y) - (x=$c.x, y=$c.y)"
    }

    //остальные методы отработают по наследованию от родителя
}