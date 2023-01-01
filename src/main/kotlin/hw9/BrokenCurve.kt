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

    /**
     * поворачиваем относительно (0,0)
     * каждую точку a, b, c будем поворачивать на новый угол относительно (0,0) - два вектора 0a, 0b, 0c
     * для каждого вектора:
     * - найти угол a0x
     * - вычислить расстояние от 0 до a
     * - переносим точку a - точка a1 = (lenA * cos(старый угол + новый), lenA * sin(старый угол + новый))
     * аналогично вычисляем точку b1 и c1
     * строим BrokenCurve по точкам a1, b1, c1
     */
    override fun rotate(degrees: Double): BrokenCurve {
        val angleA = atan2(a.getY(), a.getX())
        val lenA = Point(0.0, 0.0).distance(Point(a.getX(), a.getY()))
        val pointA = Point(lenA * cos(angleA + degrees), lenA * sin(angleA + degrees))

        val angleB = atan2(b.getY(), b.getX())
        val lenB = Point(0.0, 0.0).distance(Point(b.getX(), b.getY()))
        val pointB = Point(lenB * cos(angleB + degrees), lenB * sin(angleB + degrees))

        val angleC = atan2(c.getY(), c.getX())
        val lenC = Point(0.0, 0.0).distance(Point(c.getX(), c.getY()))
        val pointC = Point(lenC * cos(angleC + degrees), lenC * sin(angleC + degrees))

        return BrokenCurve(pointA, pointB, pointC)
    }

    override fun rotate90(dir: Int) =
        if (dir >= 0) BrokenCurve(Point(a.getX(), -a.getY()), Point(b.getX(), -b.getY()), Point(c.getX(), -c.getY()))
        else BrokenCurve(Point(-a.getX(), a.getY()), Point(-b.getX(), b.getY()), Point(-c.getX(), c.getY()))
}