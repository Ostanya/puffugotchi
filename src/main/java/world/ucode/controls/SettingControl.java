package world.ucode.controls;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import world.ucode.Database;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import world.ucode.scenes.NewScene;
import world.ucode.utils.Utils;


import java.net.URL;
import java.util.ResourceBundle;


public class SettingControl implements Initializable {

    public Button sound_off;
    public Button sound_on;
    public Button backg_f;
    public Button backg_s;
    public ChoiceBox<String> difficultySettings;
    public String background = "/img/back1.png";
    public String sound = "off";
    public Button back;
    public Button play;

    @FXML public ImageView backgrnd;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sound = Database.getSoundSettings();
        System.out.println(background);
        backgrnd.setImage(new Image(background));
        difficultySettings.setValue((Database.getDifficultySettings()));
    }

    @FXML
    public void sound_off() {
        sound = "off";
    }

    @FXML
    public void sound_on() {
        Utils.playSound("click.mp3");
        sound = "on";
    }

    @FXML
    public void back() {
        Utils.playSound("click.mp3");
        (new NewScene("MenuBar.fxml")).setScene();
    }

    @FXML
    public void play() {
        Utils.playSound("click.mp3");
        String diff = difficultySettings.getValue();
        Database.updateSettings(sound, background, diff);
        (new NewScene("Options.fxml")).setScene();
    }
}