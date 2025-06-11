import java.util.Scanner;
//===================333333333333333
public class Task {

    Scanner sc = new Scanner(System.in);

    private String title;
    private String description;


    // private int priority;
    // private boolean isCompleted;

    //  (Constructor)
    public Task(String title, String description) {//هاي عشان البديكا للعنوان لما يدخلها المستخدم
        //    this.title = set.title;
        this.title = setTitle(title);
        this.description = description;
    }
    //rrr

    //  Getters و Setters
    public String getTitle() {
        return title;
    }

    //true false
    public void checktitle(String title){
        boolean found_null = false;
        if (title==null){
            found_null= true;
            while (found_null==true){

                System.out.println("The Title can not be empty");
                System.out.print("Enter the task title : ");
                title = sc.nextLine();
                checktitle(title);//عشان يرجع يعمل بديكا للعنوان
            }
//P


        }else {
            setTitle(title) ;


        }


}


        public String setTitle(String title) {
            checktitle(title)  ;
            this.title = title;
            return title;

        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }



        public String toString() {
            return "title : " + title + "\ndescription : " + description;
        }
    }