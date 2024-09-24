import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Scanner

// Task data class to hold task information
data class Task(
    val id: Int,
    val title: String,
    val description: String,
    var status: TaskStatus,
    val createdAt: LocalDateTime
)

// Enum to define task status
enum class TaskStatus {
    PENDING,
    IN_PROGRESS,
    COMPLETED
}

// TaskManager class to handle task operations
class TaskManager {
    private val tasks = mutableListOf<Task>()
    private var nextId = 1

    // Function to add a new task
    fun addTask(title: String, description: String) {
        val task = Task(nextId++, title, description, TaskStatus.PENDING, LocalDateTime.now())
        tasks.add(task)
        println("Task added successfully!")
    }

    // Function to view all tasks
    fun viewTasks() {
        if (tasks.isEmpty()) {
            println("No tasks available.")
            return
        }

        println("Tasks:")
        tasks.forEach { task ->
            println("${task.id}. ${task.title} - ${task.description} [${task.status}] (Created: ${task.createdAt.format(formatter)})")
        }
    }

    // Function to update a task
    fun updateTask(id: Int, title: String?, description: String?, status: TaskStatus?) {
        val task = tasks.find { it.id == id }
        if (task != null) {
            if (title != null) task.title = title
            if (description != null) task.description = description
            if (status != null) task.status = status
            println("Task updated successfully!")
        } else {
            println("Task with ID $id not found.")
        }
    }

    // Function to delete a task
    fun deleteTask(id: Int) {
        val task = tasks.find { it.id == id }
        if (task != null) {
            tasks.remove(task)
            println("Task deleted successfully!")
        } else {
            println("Task with ID $id not found.")
        }
    }

    // Function to mark a task as completed
    fun completeTask(id: Int) {
        val task = tasks.find { it.id == id }
        if (task != null) {
            task.status = TaskStatus.COMPLETED
            println("Task marked as completed!")
        } else {
            println("Task with ID $id not found.")
        }
    }

    // Function to get the number of tasks
    fun getTaskCount(): Int = tasks.size
}

// Main function to run the task management application
fun main() {
    val scanner = Scanner(System.`in`)
    val taskManager = TaskManager()

    while (true) {
        println("\nTask Management Application")
        println("1. Add Task")
        println("2. View Tasks")
        println("3. Update Task")
        println("4. Delete Task")
        println("5. Complete Task")
        println("6. Exit")
        print("Choose an option: ")

        when (scanner.nextInt()) {
            1 -> {
                scanner.nextLine() // Consume newline
                print("Enter task title: ")
                val title = scanner.nextLine()
                print("Enter task description: ")
                val description = scanner.nextLine()
                taskManager.addTask(title, description)
            }
            2 -> taskManager.viewTasks()
            3 -> {
                print("Enter task ID to update: ")
                val id = scanner.nextInt()
                scanner.nextLine() // Consume newline
                print("Enter new task title (or leave empty to skip): ")
                val title = scanner.nextLine().takeIf { it.isNotEmpty() }
                print("Enter new task description (or leave empty to skip): ")
                val description = scanner.nextLine().takeIf { it.isNotEmpty() }
                print("Enter new task status (PENDING, IN_PROGRESS, COMPLETED or leave empty to skip): ")
                val statusInput = scanner.nextLine()
                val status = if (statusInput.isNotEmpty()) TaskStatus.valueOf(statusInput) else null
                taskManager.updateTask(id, title, description, status)
            }
            4 -> {
                print("Enter task ID to delete: ")
                val id = scanner.nextInt()
                taskManager.deleteTask(id)
            }
            5 -> {
                print("Enter task ID to complete: ")
                val id = scanner.nextInt()
                taskManager.completeTask(id)
            }
            6 -> {
                println("Exiting the application.")
                return
            }
            else -> println("Invalid option, please try again.")
        }
    }
}

// Formatter for displaying dates
val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
