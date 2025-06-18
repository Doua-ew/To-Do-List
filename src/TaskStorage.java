import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class TaskStorage {
    private static final String FILE_NAME = "users_tasks.json";
    private static final Gson gson = new Gson();

    public static Map<String, LinkedList<Task>> getAllUsers() {
        return loadAllUsers(); // ترجع كل المستخدمين الموجودين في ملف users_tasks.json
    }


    public static LinkedList<Task> loadTasksFromFile(String username) {
        Map<String, LinkedList<Task>> allUsers = loadAllUsers();

        if (!allUsers.containsKey(username)) {
            return new LinkedList<>();
        }

        return allUsers.get(username);
    }


    public static void saveTasksToFile(String username, LinkedList<Task> userTasks) {
        Map<String, LinkedList<Task>> allUsers = loadAllUsers();
        allUsers.put(username, userTasks);
        saveAllUsers(allUsers);
        System.out.println("✔ Tasks saved for user: " + username);
    }


    private static Map<String, LinkedList<Task>> loadAllUsers() {
        File file = new File(FILE_NAME);
        if (!file.exists() || file.length() == 0) {
            return new HashMap<>();
        }

        try (FileReader reader = new FileReader(file)) {
            Type type = new TypeToken<Map<String, LinkedList<Task>>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            System.out.println(" Error reading from file: " + e.getMessage());
            return new HashMap<>();
        }
    }


    private static void saveAllUsers(Map<String, LinkedList<Task>> allUsers) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(allUsers, writer);
        } catch (IOException e) {
            System.out.println(" Failed to save file: " + e.getMessage());
        }
    }
}
