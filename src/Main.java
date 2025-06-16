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
            int choice  = Task_Manager.check_input_string_int(input);

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
                    int choice_1_final  = Task_Manager.check_input_string_int(choice1_2);
                    boolean isCompleted = Task_Manager.check_input_boolean(choice_1_final);


                    manager.addTask(title, description,isCompleted);
                    break;
                case 2:
                    manager.displayTasks();
                    break;

                case 3 :
                    manager.displayTasks(); // نعرض المهام أولًا
                    System.out.print("Enter the number of the task to mark as completed: ");
                    String inputnum = sc.nextLine();
                    int tasknum = Task_Manager.check_input_string_int(inputnum);
                    manager.markTaskAsCompleted(tasknum);


                case 4:
                    manager.displayTasks();
                    System.out.print("ENTER THE TASK’S NUMBER TO DELETE: ");
                    int index = sc.nextInt();
                    String input_delete = sc.nextLine();
                    int task_delete = Task_Manager.check_input_string_int(input_delete);
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