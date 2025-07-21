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

    // كلاس داخلي لتخزين  المهام للمستخدم
    public static class UserData {
        LinkedList<Task> tasks;

        public UserData( ) {
            this.tasks = new LinkedList<>();
        }
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
            userData = new UserData(); // فارغة لأن لا نعرف كلمة المرور هنا
            userData.tasks = userTasks;
        }
        allUsers.put(username, userData);
        saveAllUsers(allUsers);
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



    public static void createUser(String username, String password) {
        // تحميل كلمات السر من ملف password.json
        Map<String, String> passwords = loadPasswords();

        // التحقق إذا كان اسم المستخدم موجود مسبقًا
        if (passwords.containsKey(username)) {
            System.out.println("User already exists! Choose a different username.");
            return; // خروج من الدالة حتى لا يتم استبدال المستخدم الحالي
        }

        // إضافة اسم المستخدم وكلمة السر الجديدة
        passwords.put(username, password);

        // حفظ التغييرات في ملف كلمات السر
        savePasswords(passwords);

        // تحميل جميع المستخدمين من ملف users_tasks.json
        Map<String, UserData> allUsers = loadAllUsers();

        // إذا المستخدم غير موجود، نضيفه مع قائمة مهام فارغة
        if (!allUsers.containsKey(username)) {
            UserData newUser = new UserData(); // لا نضيف كلمة السر هنا
            allUsers.put(username, newUser);
            saveAllUsers(allUsers); // حفظ التحديثات
        }

        System.out.println("User created successfully.");
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





}
