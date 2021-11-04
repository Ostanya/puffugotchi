package world.ucode.scenes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class NewScene extends AbstractScene {
    public static final String scenePath = "/controls/";
    public static final String userError = "user error";

    public NewScene(String str) {
        String css = scenePath;
        String theme = getClass().getResource(css).toExternalForm();
        try {
            FXMLLoader fxmlLoad = new FXMLLoader(getClass().getResource(scenePath + str));
            Parent root = fxmlLoad.load();
            this.scene = new Scene(root);
            this.scene.getStylesheets().add(theme);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println(userError);
        }
    }
}