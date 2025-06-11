//import javafx.application.Application;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.*;
//import javafx.stage.Stage;
//
//public class Screen_edit extends Application {
//
//    private ObservableList<String> tasks;
//
//    @Override
//    public void start(Stage stage) {
//        // قائمة المهام
//        tasks = FXCollections.observableArrayList();
//
//        // إنشاء العناصر
//        TextField taskInput = new TextField();
//        taskInput.setPromptText("اكتبي مهمتك هنا");
//
//        Button addButton = new Button("أضيفي");
//        ListView<String> taskListView = new ListView<>(tasks);
//
//        // عند الضغط على زر الإضافة
//        addButton.setOnAction(e -> {
//            String taskText = taskInput.getText();
//            if (!taskText.isEmpty()) {
//                tasks.add(taskText);
//                taskInput.clear();
//            }
//        });
//
//        // عند الضغط مرتين على مهمة يتم حذفها (اختياري)
//        taskListView.setOnMouseClicked(event -> {
//            if (event.getClickCount() == 2) {
//                String selected = taskListView.getSelectionModel().getSelectedItem();
//                tasks.remove(selected);
//            }
//        });
//
//        // تنظيم العناصر
//        VBox layout = new VBox(10);
//        layout.getChildren().addAll(taskInput, addButton, taskListView);
//        layout.setStyle("-fx-padding: 20; -fx-font-size: 14px;");
//
//        // إعداد المشهد
//        Scene scene = new Scene(layout, 300, 400);
//        stage.setScene(scene);
//        stage.setTitle("قائمة المهام - To Do List");
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}