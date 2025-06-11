import java.util.Scanner;

public class Main {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        Task_Manager manager = new Task_Manager();
// ===ssssssss
        while (true) {//تكون بلوب لانهائية عبين ما يسجل المستخدم
            System.out.println("1. ADD TASK");
            System.out.println("2. DISPLAY TASK");
            System.out.println("3. DELETE TASK");
            System.out.println("0. EXIT");
            System.out.print("CHOOSE: ");
            int choice = sc.nextInt();
            sc.nextLine(); // لتنظيف السطر

//====================================================
            switch (choice) {
                case 1:
                    System.out.print("ENTER THE TITLE OF THE TASK: ");
                    String title = sc.nextLine();
                    System.out.print("ENTER THE DESCRIPTION OF THE  TASK: ");
                    String description = sc.nextLine();
                    manager.addTask(title, description);
                    break;
                case 2:
                    manager.displayTasks();
                    break;
                case 3:
                    System.out.print("ENTER THE TASK’S NUMBER TO DELETE: ");
                    int index = sc.nextInt();
                    manager.deleteTask(index);
                    break;
                case 0:
                    System.out.println("The program has been ended");
                    return;
                default:
                    System.out.println(" Invalid option.");
            }

        }
    }
}