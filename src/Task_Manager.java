import java.util.LinkedList;
public class Task_Manager {
    private LinkedList<Task> tasks;



    public Task_Manager() {
        tasks = new LinkedList<>();
    }


    public LinkedList<Task> getTasks() {
        return tasks;
    }


    public void setTasks(LinkedList<Task> newTasks) {
        this.tasks = newTasks;
    }


    public void addTask(String title, String description, boolean isCompleted) {
        Task newTask = new Task(title, description, isCompleted);
        tasks.add(newTask);
        newTask.setDescription(description);
        newTask.setCompleted(isCompleted);
        System.out.println("The task has been added successfully! ✅");
    }


    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks currently.");
            return;
        }

        System.out.println(" My TO DO List 📝 ");
        int index = 1;

//        for (int i = 0; i < tasks.size(); i++) {
//            Task task = tasks.get(i);     (غير مختصرة )ها الحل القبل

        for (Task task : tasks) {
            System.out.println("Tasks #" + index);
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("isCompleted: " + task.getCompleted());
            System.out.println("--------------------------");
            index++;
        }
        System.out.println("===========================");
    }


    public void markTaskAsCompleted(int tasknum){
        if (tasknum <= 0 || tasknum > tasks.size()) {
            System.out.println("The task number is incorrect.");
            return;
        }

        Task task = tasks.get(tasknum - 1);

        if (task.getCompleted()==true) {
            System.out.println("This task is already marked as completed ✅.");
        } else {
            task.setCompleted(true);
            System.out.println("Task marked as completed ✅: " + task.getTitle());
        }

    }


    public void deleteTask(int index) {
        if (index <= 0 || index > tasks.size()) {
            System.out.println(" The task number is incorrect ❌");
            return;
        }

        Task removedTask = tasks.remove(index - 1); // لأن الفهرس يبدأ من 0
        System.out.println("The Task " + removedTask.getTitle() + "Has been deleted ✅");
    }


    public void updateTask(int index, String newTitle, String newDescription, boolean newCompletedStatus) {


        Task task = tasks.get(index - 1);
        task.setTitle(newTitle);
        task.setDescription(newDescription);
        task.setCompleted(newCompletedStatus);

        System.out.println("✅ Task updated successfully.");
    }


}