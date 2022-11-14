package hw8

import java.util.*

class Department(var name: String) : Unit {
    private val employees: MutableSet<Employee> = mutableSetOf()
    override var personCount = 0

    fun addEmployee(e: Employee) {
        employees.add(e)
    }

    fun removeEmployee(e: Employee) {
        employees.remove(e)
    }
}

open class Man {
    protected var surname: String? = null
    protected var name: String? = null
}

class Employee(empName: String, empSurname: String, empPosition: String) : Man() {
    private var pastPosition: MutableSet<PastPosition> = mutableSetOf()
    private var department: Department? = null
    private var position: String? = null
    private val room: MutableSet<Room> = mutableSetOf()
    private var idCard: IdCard? = null

    init {
        name = empName
        surname = empSurname
        position = empPosition
    }

    fun deletePastPosition(p: PastPosition) {
        pastPosition.remove(p)
    }

    fun deleteRoom(r: Room) {
        room.remove(r)
    }
}

class Room(var number: Int)

class PastPosition(var name: String, var department: Department)

class IdCard(var number: Int) {
    private var dateExpire: Date? = null
}

interface Unit {
    var personCount: Int
}


