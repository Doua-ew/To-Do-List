import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // فتح شاشة تسجيل الدخول/تسجيل حساب
        SCREEN_TO_DO.main(null);
    }

    // هذه الدالة تُستدعى بعد تسجيل الدخول بنجاح من واجهة المستخدم
    public static void continueAppFromConsole(String username) {
        Scanner sc = new Scanner(System.in);
        Task_Manager manager = new Task_Manager();
        manager.setTasks(TaskStorage.loadTasksFromFile(username));

        while (true) {
            System.out.println("--------THE LIST-------");
            System.out.println("1. ADD TASK");
            System.out.println("2. DISPLAY TASK");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. DELETE TASK");
            System.out.println("5. Update a task ");
            System.out.println("0. Sign Out");
            System.out.print(" ....Please , CHOOSE: ");
            String input = sc.nextLine();
            int choice  = Cheak_sc.check_input_string_int(input);

            switch (choice) {
                case 1:
                    System.out.print("ENTER THE TITLE OF THE TASK (or type 'back' to return): ");
                    String title = sc.nextLine();
                    if (title.equalsIgnoreCase("back")) break;
                    title = Cheak_sc.checktitle(title);


                    System.out.print("ENTER THE DESCRIPTION OF THE TASK: ");
                    String description = sc.nextLine();

                    System.out.println("Is the task completed?");
                    System.out.println("1. Yes ✅\n2. No ❌");
                    System.out.print("Choose 1 or 2: ");
                    String choice1_2 = sc.nextLine();
                    int choice_1_final = Cheak_sc.check_input_string_int(choice1_2);
                    boolean isCompleted = Cheak_sc.check_input_boolean(choice_1_final);

                    manager.addTask(title, description, isCompleted);
                    TaskStorage.saveTasksToFile(username, manager.getTasks());
                    break;

                case 2:
                    manager.displayTasks();
                    break;

                case 3:
                    manager.displayTasks();
                    System.out.print("Enter task number to mark as completed (or type 'back' to return): ");
                    String inputnum = sc.nextLine();
                    if (inputnum.equalsIgnoreCase("back")) break;
                    int tasknum = Cheak_sc.check_input_string_int(inputnum);


                    manager.markTaskAsCompleted(tasknum);
                    TaskStorage.saveTasksToFile(username, manager.getTasks());
                    break;


                case 4:
                    manager.displayTasks();
                    System.out.print("Enter task number to delete (or type 'back' to return): ");
                    String input_delete = sc.nextLine();
                    if (input_delete.equalsIgnoreCase("back")) break;
                    int task_delete = Cheak_sc.check_input_string_int(input_delete);
                    manager.deleteTask(task_delete);
                    TaskStorage.saveTasksToFile(username, manager.getTasks());
                    break;

                case 5:
                    manager.displayTasks();
                    System.out.print("Enter task number to update (or type 'back' to return): ");
                    String inputUpdate = sc.nextLine();
                    if (inputUpdate.equalsIgnoreCase("back")) break;
                    int updateIndex = Cheak_sc.check_input_string_int(inputUpdate);

                    if (updateIndex <= 0 || updateIndex > manager.getTasks().size()) {
                        System.out.println("❌ Invalid task number.");
                        break;
                    }

                    System.out.print("Enter the new title: ");
                    String newTitle = sc.nextLine();
                    newTitle = Cheak_sc.checktitle(newTitle);

                    System.out.print("Enter the new description: ");
                    String newDescription = sc.nextLine();

                    System.out.println("Is the task completed now?\n1. Yes ✅\n2. No ❌");
                    System.out.print("Choose 1 or 2: ");
                    String statusInput = sc.nextLine();
                    int statusChoice = Cheak_sc.check_input_string_int(statusInput);
                    boolean newStatus = Cheak_sc.check_input_boolean(statusChoice);

                    manager.updateTask(updateIndex, newTitle, newDescription, newStatus);
                    TaskStorage.saveTasksToFile(username, manager.getTasks());
                    break;

                case 0:
                    TaskStorage.saveTasksToFile(username, manager.getTasks());
                    System.out.println("==== Thank you for using the app. Goodbye 👋 ====");
                    SCREEN_TO_DO.main(null);  // ← فتح واجهة تسجيل الدخول مجددًا
                    return;  // ← الخروج من هذه الحلقة فقط


                default:
                    System.out.println("❌ Invalid option ❌\nPlease choose a valid number.");
            }
        }
    }
}
