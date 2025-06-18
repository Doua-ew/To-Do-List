import java.util.Scanner;
import com.google.gson.Gson;
// كل مستخدم الو لينكيد ليست خاصة به
//تو دو ليست اكثر من وحدة للمستخدم ننضيف تواريخ
// تو دو ليست لكل يوم تقريبا في الاسبوع
// ابديت لليست
// هيستوري لليست
//ملف جيسون
// هعارة في البيدكاة في المتسقت ابديكوت والتحديات

public class Main {


    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        Task_Manager manager = new Task_Manager();
//        System.out.print("Enter your username: ");
//        String username = sc.nextLine();
//        manager.setTasks(TaskStorage.loadTasksFromFile(username));
        String username= null;
        while (true) {
            System.out.println("========== Welcome to the To-Do App ==========");
            System.out.println("1. Sign up (Create new account)");
            System.out.println("2. Login (Enter existing account)");
            System.out.print("Choose 1 or 2: ");
            String choose_sign_login_string = sc.nextLine();
            int choose_login_sign_int= Cheak_sc.check_input_string_int(choose_sign_login_string);
             username = Cheak_sc.check_then_do_singUP_login(choose_login_sign_int);
            if (username != null) break;

        }
        manager.setTasks(TaskStorage.loadTasksFromFile(username));

        while (true) {//تكون بلوب لانهائية عبين ما يسجل المستخدم
            System.out.println("------THE LIST-----");
            System.out.println("1. ADD TASK");
            System.out.println("2. DISPLAY TASK");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. DELETE TASK");
            System.out.println("0. EXIT");
            System.out.print("CHOOSE: ");
            // احط هاي الملاحظة في المتسكقت
            String input = sc.nextLine();
            int choice  = Cheak_sc.check_input_string_int(input);

//====================================================

            switch (choice) {
                case 1:
                    System.out.print("ENTER THE TITLE OF THE TASK: ");
                    String title = sc.nextLine();
                    title=Cheak_sc.checktitle(title);


                    System.out.print("ENTER THE DESCRIPTION OF THE  TASK: ");
                    String description = sc.nextLine();

                    System.out.println("Is the task completed?");// راح تتغير لما نضيف جافا فيكس
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    System.out.print("Choose 1 or 2: ");
                    String choice1_2 = sc.nextLine();
                    int choice_1_final  = Cheak_sc.check_input_string_int(choice1_2);
                    boolean isCompleted = Cheak_sc.check_input_boolean(choice_1_final);


                    manager.addTask(title, description,isCompleted);
                    TaskStorage.saveTasksToFile(username, manager.getTasks());


                    break;
                case 2:
                    manager.displayTasks();
                    break;

                case 3 :
                    manager.displayTasks(); // نعرض المهام أولًا
                    System.out.print("Enter the number of the task to mark as completed: ");
                    String inputnum = sc.nextLine();
                    int tasknum = Cheak_sc.check_input_string_int(inputnum);
                    manager.markTaskAsCompleted(tasknum);
                    TaskStorage.saveTasksToFile(username, manager.getTasks());
                    break;



                case 4:
                    manager.displayTasks();
                    System.out.print("ENTER THE TASK’S NUMBER TO DELETE: ");
                    String input_delete = sc.nextLine();
                    int task_delete = Cheak_sc.check_input_string_int(input_delete);
                    manager.deleteTask(task_delete);
                    TaskStorage.saveTasksToFile(username, manager.getTasks());

                    break;


                case 0:
                    TaskStorage.saveTasksToFile(username, manager.getTasks());
                    System.out.println("Tasks saved successfully. Goodbye");

                    System.out.println("The program has been ended");
                    return;


                default:
                    System.out.println("!!!Invalid option!!!");
                    System.out.println("----Choose a number from the list---");
            }

        }
    }
}