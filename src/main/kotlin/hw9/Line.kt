package hw9

import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin

open class Line(var a: Point, var b: Point) {

    constructor(x1: Double, y1: Double, x2: Double, y2: Double) : this(Point(x1, y1), Point(x2, y2))
    constructor(line: Line) : this(line.a, line.b)

    fun angle(): Double {
        val x = b.getX() - a.getX()
        val y = b.getY() - a.getY()

        var angle = atan2(y, x)
        if (angle < 0) angle += 2 * Math.PI

        return angle * 180 / Math.PI
    }

    open fun len() = a.distance(b)

    /**
     * поворачиваем относительно (0,0)
     * каждую точку a и b будем поворачивать на новый угол относительно (0,0) - два вектора 0a, 0b
     * для каждого вектора:
     * - найти угол a0x
     * - вычислить расстояние от 0 до a
     * - переносим точку a - точка a1 = (lenA * cos(старый угол + новый), lenA * sin(старый угол + новый))
     * аналогично вычисляем точку b1
     * строим линию (a1, b1)
     */
    open fun rotate(degrees: Double): Line {
        val angleA = atan2(a.getY(), a.getX())
        val lenA = Point(0.0, 0.0).distance(Point(a.getX(), a.getY()))
        val pointA = Point(lenA * cos(angleA + degrees), lenA * sin(angleA + degrees))

        val angleB = atan2(b.getY(), b.getX())
        val lenB = Point(0.0, 0.0).distance(Point(b.getX(), b.getY()))
        val pointB = Point(lenB * cos(angleB + degrees), lenB * sin(angleB + degrees))

        return Line(pointA, pointB)
    }

    open fun rotate90(dir: Int) =
        if (dir >= 0) Line(Point(a.getX(), -a.getY()), Point(b.getX(), -b.getY()))
        else Line(Point(-a.getX(), a.getY()), Point(-b.getX(), b.getY()))

    /**
     * Точка принадлежит отрезку, если сумма расстояний от этой точки до конечных точек отрезка равна длине отрезка.
     * ac + cb = ab
     */
    open fun isOnLine(c: Point): Boolean {
        if (this.a == c || this.b == c) return true

        val ac = a.distance(c)
        val cb = b.distance(c)
        val length = a.distance(b)

        return ac + cb == length
    }

    fun isOnLine(x: Double, y: Double) = isOnLine(Point(x, y))

    override fun toString(): String {
        return "Line[$a, $b]"
    }
}