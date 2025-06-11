import java.util.LinkedList;
import java.util.Scanner;
public class Task_Manager {
    private LinkedList<Task> tasks;
    Scanner sc = new Scanner(System.in);


    public static int  check_input(String input) {
        boolean isNumber = true;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                isNumber = false;
            }
        }

        if (isNumber == false || input.length() == 0) {
            System.out.println("Invalid input!!!!. Please enter a valid number.");
            System.out.print("Enter the task number: ");

            Scanner sc = new Scanner(System.in);
            input = sc.nextLine(); //

            return check_input(input); // רקורסיה
        }

        return Integer.parseInt(input);

    }





    public Task_Manager() {
        tasks = new LinkedList<>();
    }

    public void addTask(String title, String description) {
        Task newTask = new Task(title, description);
        tasks.add(newTask);
        System.out.println("The task has been added successfully!");
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks currently.");
            return;
        }
//LOKE
        System.out.println("To DO List:");
        int index = 1;

//        for (int i = 0; i < tasks.size(); i++) {
//            Task task = tasks.get(i);     (غير مختصرة )ها الحل القبل

        for (Task task : tasks) {
            System.out.println("Tasks #" + index);
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("--------------------------");
            index++;
        }
    }

    public void deleteTask(int index) {
        if (index <= 0 || index > tasks.size()) {
            System.out.println("The task number is incorrect.");
            return;
        }

        Task removedTask = tasks.remove(index - 1); // لأن الفهرس يبدأ من 0
        System.out.println("Task deleted: " + removedTask.getTitle());
    }
}