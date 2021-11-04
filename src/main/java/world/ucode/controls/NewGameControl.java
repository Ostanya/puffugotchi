package world.ucode.controls;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import world.ucode.scenes.NewScene;
import javafx.scene.control.TextField;
import world.ucode.utils.Utils;
import world.ucode.Database;

public class NewGameControl {

    public String type = "pink";
    public TextField petNameBox;
    public TextField petHealthBox;
    public Button red;
    public Button blue;
    public Button pink;
    public Button exitButton;
    public Button backButton;


    @FXML
    public void red() {
        Utils.playSound("red.mp3");
        this.type = "red";
    }

    @FXML
    public void blue() {
        Utils.playSound("blue.mp3");
        this.type = "blue";
    }

    @FXML
    public void pink() {
        Utils.playSound("pink.mp3");
        this.type = "pink";
    }


    @FXML
    public void play() {
        Utils.playSound("click.mp3");
        String health = petHealthBox.getText();
        if (health.equals("")) {
            health = "10";
        }
        else if(health.isEmpty()) {
           System.out.println("Enter health rate");
        }
        String nameBox = petNameBox.getText();
        Database.insertNewDB(nameBox, type,
                            Integer.parseInt(health));
        (new NewScene("GamePlay.fxml")).setScene();
    }

    @FXML
    public void back() {
        Utils.playSound("click.mp3");
        (new NewScene("MenuBar.fxml")).setScene();
    }
}