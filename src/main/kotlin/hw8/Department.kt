package hw8

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