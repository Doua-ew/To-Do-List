import java.util.LinkedList;
public class Task_Manger {
    private LinkedList<Task> tasks;

    public Task_Manger() {
        tasks = new LinkedList<>();
    }
//ugvouljyhvb kljkljklklkllkjmij

    public void addTask ( String title,String description){
        //
        Task newTask = new Task( title,  description);
        tasks.add(newTask);
        System.out.println("The task has been added successfully");
    }



    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks currently");
            return;
        }

        System.out.println("To do list :");
        int index = 1;

//        for (int i = 0; i < tasks.size(); i++) {
//            Task task = tasks.get(i);     (غير مختصرة )ها الحل القبل

        for (Task task : tasks) {
            System.out.println("Task" + index);
            System.out.println("title " + task.getTitle());
            System.out.println("description " + task.getDescription());
            System.out.println("--------------------------");
            index++;
        }
    }



    public void deleteTask(int index) {
        if (index <= 0 || index > tasks.size()) {
            System.out.println("The task number is incorrect");
            return;
        }

        Task removedTask = tasks.remove(index - 1); // لأن الفهرس يبدأ من 0
        System.out.println("Task deleted" + removedTask.getTitle());
    }












}
