public class Task {


    private String title;
    private String description;
    private boolean isCompleted;



    //  (Constructor)
    public Task(String title, String description,boolean isCompleted) {

        this.title = title ;
        this.description = description;
        this.isCompleted= isCompleted;
    }


    //  Getters و Setters

    public void setTitle(String title) {
        this.title = Cheak_sc.checktitle(title) ;

    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
            return description;
        }

    public String CompletionStatus(boolean completed){
        String status;
        if (completed==true)
            status="yes";

        else
            status="No";


       return status;
    }


    public boolean getCompleted() {
        return isCompleted;
    }


    public String toString() {
        return "title : " + title + "\ndescription : " + description
                + "\nCompleted "+CompletionStatus(getCompleted());
    }



    }