import java.util.Scanner;

public class Main {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        Task_Manager manager = new Task_Manager();
        while (true) {//تكون بلوب لانهائية عبين ما يسجل المستخدم
            System.out.println("------THE LIST-----");
            System.out.println("1. ADD TASK");
            System.out.println("2. DISPLAY TASK");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. DELETE TASK");
            System.out.println("0. EXIT");
            System.out.print("CHOOSE: ");
            String input = sc.nextLine();
            int choice  = Task_Manager.check_input(input);

//====================================================



            switch (choice) {
                case 1:
                    System.out.print("ENTER THE TITLE OF THE TASK: ");
                    String title = sc.nextLine();
                    System.out.print("ENTER THE DESCRIPTION OF THE  TASK: ");
                    String description = sc.nextLine();

                    System.out.println("Is the task completed?");// راح تتغير لما نضيف جافا فيكس
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    System.out.print("Choose 1 or 2: ");
                    String choice1_2 = sc.nextLine();

                    boolean isCompleted = false;
                    if (choice1_2.equals("1")) {
                        isCompleted = true;
                    }

                    manager.addTask(title, description,isCompleted);
                    break;
                case 2:
                    manager.displayTasks();
                    break;

                case 3 :
                    manager.displayTasks(); // نعرض المهام أولًا
                    System.out.print("Enter the number of the task to mark as completed: ");
                    String inputnum = sc.nextLine();
                    int tasknum = Task_Manager.check_input(inputnum);
                    manager.markTaskAsCompleted(tasknum);


                case 4:
                    manager.displayTasks();
                    System.out.print("ENTER THE TASK’S NUMBER TO DELETE: ");
                    int index = sc.nextInt();
                    String input_delete = sc.nextLine();
                    int task_delete = Task_Manager.check_input(input_delete);
                    manager.deleteTask(task_delete);
                    break;


                case 0:
                    System.out.println("The program has been ended");
                    return;


                default:
                    System.out.println("!!!Invalid option!!!");
                    System.out.println("----Choose a number from the list---");
            }

        }
    }
}