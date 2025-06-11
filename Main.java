import java.util.Scanner;
public class main {
    public static void main (String []args){
        Scanner sc = new Scanner(System.in);
        Task_Manger manager = new Task_Manger();


            while (true) {
                //فوننتكسياه هدبسا
                System.out.println("1.Add Task");
                System.out.println("2. Display Tasks");
                System.out.println("3. Delete Task ");
                System.out.println("0. Exit");
                System.out.print("Choose  : ");
               int  choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter the task title : ");
                        String title = sc.nextLine();
                        System.out.print("Enter Description of the task ");
                        String description = sc.nextLine();
                        manager.addTask(title, description);
                        break;
                    case 2:
                        manager.displayTasks();
                        break;
                    case 3:
                        System.out.print("Enter the task’s number to delete  ");
                        int index = sc.nextInt();
                        sc.nextLine();
                        manager.deleteTask(index);
                        break;
                    case 0:
                        System.out.println("The program has been ended");
                        return;
                    default:
                        System.out.println(" Invalid option");
                }}
            // هنا لو في شيء بعد الخروج





    }


}
