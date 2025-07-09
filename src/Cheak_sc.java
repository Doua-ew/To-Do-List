import java.util.Scanner;
import java.util.*;

public class Cheak_sc {


    Scanner sc = new Scanner(System.in);

    public static int  check_input_string_int(String input) {

        boolean isNumber = true;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                isNumber = false;
            }
        }

        if (isNumber == false || input.length() == 0) {
            System.out.println("Invalid input ❌. Please enter a valid number.");
            System.out.print("Enter number  : ");

            Scanner sc = new Scanner(System.in);
            input = sc.nextLine(); //

            return check_input_string_int(input); // רקורסיה
        }

        return Integer.parseInt(input);// خاصية من جافا بتحول النص الى رقم

    }


    public static boolean check_input_boolean(int input) {

        boolean isCompleted = false;
        switch (input) {

            case 1:
                isCompleted = true;
                break;

            case 2:
                isCompleted = false;
                break;


            default:
                System.out.println("Invalid input ❌. Please enter a valid number.");
                System.out.print("Enter number ( 1:completed ✅ (or) 2: not completed ❌ ): ");
                Scanner sc = new Scanner(System.in);
                String input_String = sc.nextLine();
                input = check_input_string_int(input_String);
                return check_input_boolean(input);


        }
        return isCompleted;

    }


    public static String signUp( ) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n===== Sign Up =====");
        String username;

        boolean countinue= continue_or_back();
        if (countinue==false)
            return null;

        while (true) {
            System.out.print("Enter a username: ");
            username = sc.nextLine().trim();
            username = checktitle(username);

            if (TaskStorage.userExists(username)) {
                System.out.println("❌ Username already exists. Try a different name.");
            } else {
                break;
            }
        }

        String password;
        while (true) {
            System.out.print("Enter a password: ");
            password = sc.nextLine().trim();

            if (password.isEmpty()) {
                System.out.println("❌ Password cannot be empty. Please try again.");
            } else {
                break;
            }
        }
        TaskStorage.createUser(username, password);


        System.out.println("✅ Account created successfully!");
        return username;

    }


    public static String login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n===== Login =====");

        boolean countinue = continue_or_back();
        if (!countinue) return null;

        String username;
        String password;

        while (true) {
            System.out.print("Enter your username: ");
            username = sc.nextLine().trim();

            System.out.print("Enter your password: ");
            password = sc.nextLine().trim();

            if (TaskStorage.validateUser(username, password)) {
                System.out.println("✅ Login successful!\n");
                return username;
            } else {
                System.out.println("❌ Incorrect username or password. Try again.");
            }
        }
    }


    public static boolean continue_or_back (){
        boolean countinue =false;
        Scanner sc = new Scanner(System.in);



        System.out.println(" 1. Unter the user name ");
        System.out.println(" 2. Back <------ ");
        System.out.println("    Unter the number of your Choice : ");
        String choice= sc.nextLine();
        int choice_1  = Cheak_sc.check_input_string_int(choice);

        if (choice_1==1){
           return true ;
        }

         else if (choice_1==2){
             return false ;
        }

         else {
             System.out.println("Please Choose 1 or 2");
             continue_or_back();

        }
         return countinue ;

    }


    public static String checktitle(String title){
        Scanner sc = new Scanner(System.in);
        if (title!=null&&title.trim().length()>0)
            return title;

// trim خاصية من جافا بتحذف الفرافات في السترنق وبفحص اذا فاضية او لا عشان جافا ما بتعتبر "" فاضية
        while (title == null || title.trim().isEmpty()){

            System.out.println("The Title can not be empty!!❌");
            System.out.print("Enter the task title : ");
            title = sc.nextLine();


        }
        return checktitle(title);


    }























}
