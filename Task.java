//===================
public class Task {

        private String title;
        private String description;


        // private int priority;
        // private boolean isCompleted;

        //  (Constructor)
        public Task(String title, String description) {
        //    this.title = set.title;
            this.title = setTitle(title);
            this.description = description;
        }

        //  Getters و Setters
        public String getTitle() {
            return title;
        }

//true false
        public String setTitle(String title) {
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

