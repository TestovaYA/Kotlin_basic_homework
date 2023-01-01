package hw9

class Vector(b: Point) : Line(Point(0.0, 0.0), b) {

    constructor(x: Double, y: Double) : this(Point(x, y))

    constructor(line: Line) : this(Point(line.b.getX() - line.a.getX(), line.b.getY() - line.a.getY()))

    override fun toString(): String {
        return "Vector[$a, $b]"
    }

    fun add(x: Double, y: Double) = Line(Point(0.0, 0.0), Point(b.getX() + x, b.getY() + y))
    fun add(line: Line) = Line(Point(0.0, 0.0), Point(b.getX() + line.b.getX() - line.a.getX(), line.b.getY() - line.a.getY()))

    fun set(x: Double, y: Double) = b.setLocation(x, y)
    fun set(line: Line) = b.setLocation(line.b.getX() - line.a.getX(), line.b.getY() - line.a.getY())

    fun setZero() = Line(0.0, 0.0, 0.0, 0.0)

    override fun isOnLine(a: Point) =
        if (this.a == a) true
        else angle() == Line(this.a, a).angle()

    //остальные методы отработают по наследованию от родителя
}