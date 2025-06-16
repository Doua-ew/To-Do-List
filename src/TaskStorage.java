import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.LinkedList;

public class TaskStorage {
    private static final Gson gson = new Gson();

    public static void saveTasksToFile(String username, LinkedList<Task> tasks) {
        try (FileWriter writer = new FileWriter(username + ".json")) {
            gson.toJson(tasks, writer);
            System.out.println(" Tasks saved to " + username + " .json");
        } catch (IOException e) {
            System.out.println("Failed to save: " + e.getMessage());
        }
    }

    public static LinkedList<Task> loadTasksFromFile(String username) {
        File file = new File(username + ".json");

        // ✅ 1. إذا الملف مش موجود أو فاضي → رجّع قائمة جديدة
        if (!file.exists() || file.length() == 0) {
            System.out.println("⚠ No existing file or file is empty. Creating new task list.");
            return new LinkedList<>();
        }

        // ✅ 2. إذا الملف موجود وفيه محتوى → نقرأه
        try (FileReader reader = new FileReader(file)) {
            Type type = new TypeToken<LinkedList<Task>>(){}.getType();
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            System.out.println("❌ Failed to load tasks: " + e.getMessage());
            return new LinkedList<>();
        }
    }













}
