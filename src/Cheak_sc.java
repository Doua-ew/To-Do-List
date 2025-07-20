import java.util.Scanner;

public class Cheak_sc {


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


    public static void waitForEnter() {
        System.out.println("⏸️ Press Enter to back to menu.....");
        Scanner sc = new Scanner(System.in);
        sc.nextLine(); // يوقف حتى يضغط المستخدم Enter
    }
























}
