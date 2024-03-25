import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static Hogwarts hogwarts;

    public static void main(String[] args) {
        hogwarts = new Hogwarts();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
        Parent root = loader.load();
        MainViewController controller = loader.getController();
        controller.setHogwarts(hogwarts);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hogwarts School of Witchcraft and Wizardry");
        primaryStage.show();
    }
}
