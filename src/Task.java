//import java.util.Scanner;
public class Task {

//    Scanner sc = new Scanner(System.in);

    private String title;
    private String description;
    private boolean isCompleted;



    //  (Constructor)
    public Task(String title, String description,boolean isCompleted) {
        //هاي عشان البديكا للعنوان لما يدخلها المستخدم

        this.title = title ;
        this.description = description;
        this.isCompleted= isCompleted;
    }




    //  Getters و Setters
    public String getTitle() {
        return title;
    }

    //true false
//    public String checktitle(String title){
//
//        if (title!=null&&title.trim().length()>0)
//            return title;
//
//// trim خاصية من جافا بتحذف الفرافات في السترنق وبفحص اذا فاضية او لا عشان جافا ما بتعتبر "" فاضية
//        while (title == null || title.trim().isEmpty()){
//
//                System.out.println("The Title can not be empty!!");
//                System.out.print("Enter the task title : ");
//                title = sc.nextLine();
//
//
//        }
//        return checktitle(title);
//
//
//}



    public void setTitle(String title) {
                this.title = Cheak_sc.checktitle(title) ;

        }


    public String getDescription() {
            return description;
        }


    public void setDescription(String description) {
            this.description = description;
        }


    public boolean getCompleted() {
        return isCompleted;
    }


    public String CompletionStatus(boolean completed){
        String status;
        if (completed==true)
            status="yes";

        else
            status="No";


       return status;
    }



    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }


    public String toString() {
        return "title : " + title + "\ndescription : " + description
                + "\nCompleted "+CompletionStatus(getCompleted());
    }




    }