// Part 1

// Question 1

/*fun whoAmI(input: Any): String {
    return when (input){
        is Int -> "Int"
        is String -> "String"
        is Double -> "Double"
        is Float -> "Float"
        is Boolean -> "Boolean"
        is List<*> -> "List"
        is Set<*> -> "set"
        else -> "Unknown type: ${input::class.simpleName}"
    }
}

fun main() {
    println(whoAmI(42))               // Int
    println(whoAmI("Hello, Kotlin"))  // String
    println(whoAmI(3.14))             // Double
    println(whoAmI(true))             // Boolean
    println(whoAmI(3.14f))            // Float
    println(whoAmI(listOf(1, 2, 3)))  // List
    println(whoAmI(setOf("a", "b")))  // Set
    println(whoAmI(mapOf("x" to 10))) // Map
    println(whoAmI(arrayOf(1, 2, 3))) // Unknown type: Array
}*/

// Question 2

/*fun calculateCircumference(radius: Double): Double {
    val pi = 3.14
    return 2 * pi * radius
}

fun calculateArea(radius: Double): Double {
    val pi = 3.14
    return pi * radius * radius
}

fun main() {
    print("Enter the radius of the circle: ")
    val radius = readLine()?.toDoubleOrNull()

    if (radius != null && radius >= 0) {
        val circumference = calculateCircumference(radius)
        val area = calculateArea(radius)

        println("Circumference: $circumference")
        println("Area: $area")
    } else {
        println("Invalid radius entered.")
    }
}*/

// Question 3

/*fun main() {
    val names = mutableListOf<String>()

    // Take 5 names as input
    for (i in 0 until 5) {
        print("Enter name ${i + 1}: ")
        val name = readLine() ?: ""
        names.add(name)
    }

    // Print names with their index
    println("\nNames with Index:")
    for (index in names.indices) {
        println("Name at index $index: ${names[index]}")
    }
}*/

// Part 2

// Question 1

// Abstract base class
abstract class Employee(
    val name: String,
    val id: Int
) {
    abstract fun calculateSalary(): Double
    abstract fun getDetails(): String
}

// Subclass for Temporary Staff
class TemporaryStaff(
    name: String,
    id: Int,
    private val hourlyRate: Double,
    private val hoursWorked: Int
) : Employee(name, id) {

    override fun calculateSalary(): Double {
        return hourlyRate * hoursWorked
    }

    override fun getDetails(): String {
        return "Temporary Staff - Name: $name, ID: $id, Hours Worked: $hoursWorked, Hourly Rate: $hourlyRate"
    }

    fun getContractLengthInWeeks(): Int {
        return 12 // Just an example
    }
}

// Subclass for Permanent Staff
class PermanentStaff(
    name: String,
    id: Int,
    private val monthlySalary: Double,
    private val bonus: Double
) : Employee(name, id) {

    override fun calculateSalary(): Double {
        return monthlySalary + bonus
    }

    override fun getDetails(): String {
        return "Permanent Staff - Name: $name, ID: $id, Monthly Salary: $monthlySalary, Bonus: $bonus"
    }

    fun getLeaveBalance(): Int {
        return 20 // Example leave balance
    }
}

// Main function
fun main() {
    val tempStaff = TemporaryStaff("Alice", 101, hourlyRate = 100.0, hoursWorked = 40)
    val permStaff = PermanentStaff("Bob", 102, monthlySalary = 50000.0, bonus = 5000.0)

    println(tempStaff.getDetails())
    println("Temporary Staff Salary: ${tempStaff.calculateSalary()}")
    println("Contract Length (weeks): ${tempStaff.getContractLengthInWeeks()}")
    println()

    println(permStaff.getDetails())
    println("Permanent Staff Salary: ${permStaff.calculateSalary()}")
    println("Leave Balance: ${permStaff.getLeaveBalance()}")
}
