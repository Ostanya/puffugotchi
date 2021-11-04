package world.ucode.controls;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import world.ucode.utils.Utils;
import world.ucode.scenes.NewScene;

public class MenuControl {

    public Button new_game;
    public Button loadButton;
    public Button settingsButton;
    public Button exitButton;

    @FXML
    public void newGame() {
        Utils.playSound("click.mp3");
        (new NewScene("newGameFX.fxml")).setScene();
    }

    @FXML
    public void loadGame() {
        Utils.playSound("click.mp3");
        (new NewScene("Loader.fxml")).setScene();
    }

    @FXML
    public void options() {
        Utils.playSound("click.mp3");
        (new NewScene("Options.fxml")).setScene();
    }

    @FXML
    public void exit() {
        Utils.playSound("click.mp3"); 
        System.exit(0); 
    }
}