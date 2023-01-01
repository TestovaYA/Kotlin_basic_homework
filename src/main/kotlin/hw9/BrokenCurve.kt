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

    /**
     * Точка принадлежит отрезку, если сумма расстояний от этой точки до конечных точек отрезка равна длине отрезка.
     * проверяем оба отрезка
     * ao + ob = ab
     * bo + oc = bc
     */
    override fun isOnLine(o: Point): Boolean {
        if (this.a == o || this.b == o || this.c == o) return true

        val ao = a.distance(o)
        val ob = b.distance(o)
        val oc = c.distance(o)

        val lengthAB = a.distance(b)
        val lengthBC = b.distance(c)

        return (ao + ob == lengthAB) || (ob + oc == lengthBC)
    }

    //остальные методы отработают по наследованию от родителя
}