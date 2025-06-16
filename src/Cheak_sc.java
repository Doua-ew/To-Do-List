import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
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
            System.out.println("Invalid input!!!!. Please enter a valid number.");
            System.out.print("Enter the task number: ");

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
                System.out.println("Invalid input!!!!. Please enter a valid number.");
                System.out.print("Enter number ( 1:completed or 2: not completed ): ");
                Scanner sc = new Scanner(System.in);
                String input_String = sc.nextLine();
                input = check_input_string_int(input_String);
                return check_input_boolean(input);


        }
        return isCompleted;

    }


    public static String check_then_do_singUP_login(int input){
        String username = null;
        switch (input){

            case 1 :
                username = signUp();
                break;

            case 2 :
                username = login();
                break;

            default:
                System.out.println("Invalid input!!!!. Please enter a valid number.");
                System.out.print("Enter number ( 1:completed or 2: not completed ): ");
                Scanner sc = new Scanner(System.in);
                String input_String = sc.nextLine();
                input = check_input_string_int(input_String);
                return check_then_do_singUP_login(input);


        }
        return username;
    }


    public static String signUp( ) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n===== Sign Up =====");
        String username;
        while (true) {
            System.out.print("Enter a username: ");
            username = sc.nextLine();
            username = checktitle(username);

            // Check if username already exists in users_tasks.json
            Map<String, LinkedList<Task>> allUsers = TaskStorage.getAllUsers();
            if (allUsers.containsKey(username)) {
                System.out.println("❌ Username already exists. Try a different name.");
            } else {
                break;
            }
        }
        System.out.println("✅ Account created successfully!");
        return username;

    }


    public static String login() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== Login =====");
        String username;
        while (true) {
            System.out.print("Enter your username: ");
            username = sc.nextLine();

            // Check if username exists in users_tasks.json
            Map<String, LinkedList<Task>> allUsers = TaskStorage.getAllUsers();
            if (allUsers.containsKey(username)) {
                System.out.println(" Login successful!\n");
                return username;
            } else {
                System.out.println(" Username not found!!! Try again.");
            }
        }
    }



    public static String checktitle(String title){
        Scanner sc = new Scanner(System.in);
        if (title!=null&&title.trim().length()>0)
            return title;

// trim خاصية من جافا بتحذف الفرافات في السترنق وبفحص اذا فاضية او لا عشان جافا ما بتعتبر "" فاضية
        while (title == null || title.trim().isEmpty()){

            System.out.println("The Title can not be empty!!");
            System.out.print("Enter the task title : ");
            title = sc.nextLine();


        }
        return checktitle(title);


    }























}
