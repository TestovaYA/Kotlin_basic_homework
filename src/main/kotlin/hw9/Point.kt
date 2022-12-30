package hw9

import kotlin.math.pow
import kotlin.math.sqrt

class Point(initX: Double = 0.0, initY: Double = 0.0) {

    private var x: Double
    private var y: Double

    init {
        x = initX
        y = initY
    }

    fun getX() = x
    fun getY() = y

    fun compareX(a: Point, b: Point) =
        if (a.x > b.x) 1
        else if (a.x == b.x) 0
        else -1

    fun compareY(a: Point, b: Point) =
        if (a.y > b.y) 1
        else if (a.y == b.y) 0
        else -1

    fun distanceSq(a: Point, b: Point) = (a.x - b.x).pow(2) + (a.y - b.y).pow(2)

    fun distanceSq(other: Point) = (this.x - other.x).pow(2) + (this.y - other.y).pow(2)

    fun distance(a: Point, b: Point) = sqrt(distanceSq(a, b))

    fun distance(p: Point) = sqrt(distanceSq(p))

    fun setLocation(x: Double, y: Double) {
        this.x = x
        this.y = y
    }

    override fun toString(): String {
        return "Point[$x, $y]"
    }
}