package hw8

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