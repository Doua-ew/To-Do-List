import java.util.LinkedList;
import java.util.Scanner;
public class Task_Manager {
    private LinkedList<Task> tasks;
    Scanner sc = new Scanner(System.in);

    public Task_Manager() {
        tasks = new LinkedList<>();
    }


    public static int  check_input_string_int(String input) {
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

            return check_input_string_int(input); // רקורסיה
        }

        return Integer.parseInt(input);// خاصية من جافا بتحول النص الى رقم

    }


    public static boolean check_input_boolean(int input){

        boolean isCompleted = false;
        switch (input) {

            case 1 :
                isCompleted=true;
                break;

            case 2 :
                isCompleted=false;
                break;


            default:
                System.out.println("Invalid input!!!!. Please enter a valid number.");
                System.out.print("Enter number ( 1:completed or 2: not completed ): ");
                Scanner sc = new Scanner(System.in);
               String input_String = sc.nextLine();
                input= check_input_string_int(input_String);
                return check_input_boolean(input);



        }



     return isCompleted;
        }


    public void addTask(String title, String description, boolean isCompleted) {
        Task newTask = new Task(title, description, isCompleted);
        tasks.add(newTask);
       newTask.setCompleted(isCompleted);   //mmkkm
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
            System.out.println("isCompleted: " + task.getCompleted());
            System.out.println("--------------------------");
            index++;
        }
    }


    public void markTaskAsCompleted(int tasknum){
        if (tasknum <= 0 || tasknum > tasks.size()) {
            System.out.println("The task number is incorrect.");
            return;
        }

        Task task = tasks.get(tasknum - 1);

        if (task.getCompleted()==true) {
            System.out.println("This task is already marked as completed.");
        } else {
            task.setCompleted(true);
            System.out.println("Task marked as completed: " + task.getTitle());
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