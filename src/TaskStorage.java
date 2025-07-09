import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class TaskStorage {
    private static final String FILE_NAME = "users_tasks.json";
    private static final String PASSWORD_FILE = "password.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // كلاس داخلي لتخزين كلمة المرور والمهام للمستخدم
    public static class UserData {
        String password;
        LinkedList<Task> tasks;

        public UserData(String password) {
            this.password = password;
            this.tasks = new LinkedList<>();
        }
    }

    // تحميل جميع المستخدمين مع بياناتهم
    public static Map<String, UserData> getAllUsers() {
        return loadAllUsers();
    }

    // تحميل المهام لمستخدم معين
    public static LinkedList<Task> loadTasksFromFile(String username) {
        Map<String, UserData> allUsers = loadAllUsers();

        if (!allUsers.containsKey(username)) {
            return new LinkedList<>();
        }

        return allUsers.get(username).tasks;
    }

    // حفظ المهام لمستخدم معين
    public static void saveTasksToFile(String username, LinkedList<Task> userTasks) {
        Map<String, UserData> allUsers = loadAllUsers();
        UserData userData = allUsers.get(username);
        if (userData != null) {
            userData.tasks = userTasks;
        } else {
            userData = new UserData(""); // فارغة لأن لا نعرف كلمة المرور هنا
            userData.tasks = userTasks;
        }
        allUsers.put(username, userData);
        saveAllUsers(allUsers);
    }

    public static void createUser(String username, String password) {
        // 1. نحمّل الملف password.json
        Map<String, String> passwords = loadPasswords();

        // 2. نضيف اسم المستخدم وكلمة السر
        passwords.put(username, password);

        // 3. نحفظ الملف من جديد
        savePasswords(passwords);

        // 4. نحمّل users_tasks.json
        Map<String, UserData> allUsers = loadAllUsers();

        // 5. إذا المستخدم مش موجود، نضيفه مع tasks فقط
        if (!allUsers.containsKey(username)) {
            UserData newUser = new UserData(null);  // ما نحط password هنا
            newUser.password = null;  // نتأكد إنها ما تروح للملف
            allUsers.put(username, newUser); // نضيفه
            saveAllUsers(allUsers);  // نحفظ users_tasks.json
        }
    }


    // التحقق من صحة اسم المستخدم وكلمة السر
    public static boolean validateUser(String username, String password) {
        Map<String, String> passwords = loadPasswords();
        return passwords.containsKey(username) && passwords.get(username).equals(password);
    }

    // فحص هل المستخدم موجود في ملف البيانات أو ملف كلمات السر
    public static boolean userExists(String username) {
        return loadPasswords().containsKey(username) || loadAllUsers().containsKey(username);
    }

    // تحميل جميع بيانات المستخدمين من ملف users_tasks.json
    private static Map<String, UserData> loadAllUsers() {
        File file = new File(FILE_NAME);
        if (!file.exists() || file.length() == 0) {
            return new HashMap<>();
        }

        try (FileReader reader = new FileReader(file)) {
            Type type = new TypeToken<Map<String, UserData>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            System.out.println(" Error reading users_tasks file: " + e.getMessage());
            return new HashMap<>();
        }
    }

    // حفظ جميع بيانات المستخدمين في ملف users_tasks.json
    private static void saveAllUsers(Map<String, UserData> allUsers) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(allUsers, writer);
        } catch (IOException e) {
            System.out.println(" Failed to save users_tasks file: " + e.getMessage());
        }
    }

    // تحميل كلمات السر من ملف auth.json
    private static Map<String, String> loadPasswords() {
        File file = new File(PASSWORD_FILE);
        if (!file.exists() || file.length() == 0) {
            return new HashMap<>();
        }

        try (FileReader reader = new FileReader(file)) {
            Type type = new TypeToken<Map<String, String>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            System.out.println("Error reading passwords file: " + e.getMessage());
            return new HashMap<>();
        }
    }

    // حفظ كلمات السر إلى ملف auth.json
    private static void savePasswords(Map<String, String> passwords) {
        try (FileWriter writer = new FileWriter(PASSWORD_FILE)) {
            gson.toJson(passwords, writer);
        } catch (IOException e) {
            System.out.println("Failed to save passwords file: " + e.getMessage());
        }
    }
}
