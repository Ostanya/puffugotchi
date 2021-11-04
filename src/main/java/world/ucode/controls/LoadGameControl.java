package world.ucode.controls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import world.ucode.Database;
import world.ucode.utils.Utils;
import world.ucode.scenes.NewScene;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoadGameControl implements Initializable {
    public ChoiceBox<String> difficultySettings;
    public Button play;
    public Button back;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> listNames = Database.selectNames();
        
        if (listNames.isEmpty()) {
            play.setDisable(true);
        } else {
            ObservableList<String> names = FXCollections.observableArrayList(listNames);
            difficultySettings.setItems(names);
            difficultySettings.setValue(listNames.get(0));
        }
    }

    @FXML
    public void play() {
        Utils.playSound("click.mp3");
        String name = difficultySettings.getValue();
        int id = Integer.parseInt(name.substring(0, name.indexOf('.')));
        Database.updateActive(id);
        (new NewScene("GamePlay.fxml")).setScene();
    }

    @FXML
    public void back() {
        Utils.playSound("click.mp3");
        (new NewScene("MenuBar.fxml")).setScene();
    }

}