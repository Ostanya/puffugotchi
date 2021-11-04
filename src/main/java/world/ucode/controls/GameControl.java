package world.ucode.controls;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import world.ucode.Character;
import world.ucode.scenes.NewScene;
import world.ucode.utils.*;
import java.net.URL;
import world.ucode.Database;
import world.ucode.Model;

import java.util.ResourceBundle;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Rectangle2D;

import java.util.Calendar;

public class GameControl implements Initializable {

    public Button blue;
    public Button exitButton;
    public Button pink;
    public Button red;
    public int score = 0;
    public Rectangle removeRect = null;
    public Calendar start;
    public Calendar now;
    public long milliseconds;
    public long milliseconds_buf;
    public long arr_time[] = {0, 0, 0, 0};
    public long diff[] = {0, 0, 0, 0};
    

    private Model pet;

    @FXML public ImageView backgr;
    @FXML public Label name_pet;
    @FXML public ImageView hero;
    @FXML public Label helsi;
    @FXML public Pane rootPane;
    @FXML public Label coin;
    @FXML public Label satiety;
    @FXML public Label joy;
    @FXML public Label purity;
    @FXML public Label thirst;
    @FXML public Label imunity;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pet = new Model(hero);
        String s_arr_time[] = pet.getTime().split(" ");
        for (int count = 0; count < 4; count++) {
            arr_time[count] = Long.parseLong(s_arr_time[count]);
        }
        hero.setImage(new Image("/img/" + pet.getType() + ".png"));
        timecontrol("start");
        name_pet.setText(pet.getName());
        helsi.setText("health: " + String.valueOf(pet.getHealth()));
        coin.setText(String.valueOf(pet.getTired()));
        animation_type(1);
    }
    
    public void animation_type(int type) {
        if (type == 1)
            standart_animation();
        else if (type == 2)
            standart_animation();
        else if (type == 3)
            standart_animation();
    }

    public void standart_animation() {
        if (pet.getType().equals(pink)) {
            hero.setViewport(new Rectangle2D(0,0,39,41));
        } else if (pet.getType().equals(blue)) {
            hero.setViewport(new Rectangle2D(0,0,39,41));
        } else if (pet.getType().equals(red)) {
            hero.setViewport(new Rectangle2D(0, 0, 39, 41));
        }
    }

    @FXML
    public void pill() {
        if (pet.getTired() > 10) {
            timecontrol("pill");
            Utils.playSound("levelup.mp3");
            coin.setText(String.valueOf(pet.getTired() - 10));
            pet.setTired(pet.getTired() - 10);
        }
    }

    @FXML
    public void water() {
        if (pet.getTired() > 10) {
            timecontrol("water");
            Utils.playSound("drink.mp3");
            coin.setText(String.valueOf(pet.getTired() - 10));
            pet.setTired(pet.getTired() - 10);
        }
    }

    @FXML
    public void soap() {
        if (pet.getTired() > 10) {
            timecontrol("soap");
            animation_type(2);
            Utils.playSound("splash2.mp3");
            coin.setText(String.valueOf(pet.getTired() - 5));
            pet.setTired(pet.getTired() - 10);
        }
    }

    @FXML
    public void back() {
        Database.saveModel(pet);
        (new NewScene("MenuBar.fxml")).setScene();
    }

    @FXML
    public void play() {
        if(pet.getTired() > 10) {
            timecontrol("play");
            Utils.playSound("playGame.mp3");
            pet.setTired(pet.getTired() + 1);
            coin.setText(String.valueOf(pet.getTired() + 10));
            pet.setTired(pet.getTired() - 10);
        }
    }

    public long check_all() {
        start = Calendar.getInstance();
        milliseconds = start.getTimeInMillis();
        milliseconds_buf = milliseconds;
        diff[0] += (milliseconds - arr_time[0]) / 1000;
        long time_count;
        if (diff[0] > 60) {
            time_count = diff[0] / 60;
            diff[0] -= 60 * time_count;
            arr_time[0] = milliseconds_buf;
            pet.setHunger(pet.getHunger() - (int)time_count);
            satiety.setText(String.valueOf(pet.getHunger() - (int)time_count));
        }
        diff[1] += (milliseconds - arr_time[1]) / 1000;
        if (diff[1] > 60) {
            time_count = diff[1] / 60;
            diff[1] -= 60 * time_count;
            arr_time[1] = milliseconds_buf;
            pet.setCleanliness(pet.getCleanliness() - (int)time_count);
            purity.setText(String.valueOf(pet.getCleanliness() - (int)time_count));
        }
        diff[2] += (milliseconds - arr_time[2]) / 1000;
        if (diff[2] > 60) {
            time_count = diff[2] / 60;
            diff[2] -= 60 * time_count;
            arr_time[2] = milliseconds_buf;
            pet.setThirst(pet.getThirst() - (int)time_count);
            thirst.setText(String.valueOf(pet.getThirst() - (int)time_count));
        }
        diff[3] += (milliseconds - arr_time[3]) / 1000;
        if (diff[3] > 60) {
            time_count = diff[3] / 60;
            diff[3] -= 60 * time_count;
            arr_time[3] = milliseconds_buf;
            pet.setHunger(pet.getHunger() - (int)time_count);
            imunity.setText(String.valueOf(pet.getHunger() - (int)time_count));
        }
        return milliseconds_buf;
    }

    public void rep_helsi() {
        if(pet.getHealth() == 0 || pet.getHunger() == 0 || pet.getThirst() == 0 || pet.getCoin() > 5) {
            Database.deleteModel(pet.id);
            (new NewScene("GameOver.fxml")).setScene();
        }
    }

    public void timecontrol(String type) {
        milliseconds_buf = check_all();
        rep_helsi();
        if (type.equals("eat")) {
            if (pet.getHunger() < 10 && pet.getCleanliness() > 0) {
                satiety.setText(String.valueOf(pet.getHunger() + 1));
                pet.setHunger(pet.getHunger() + 1);
                purity.setText(String.valueOf(pet.getCleanliness() - 1));
                pet.setCleanliness(pet.getCleanliness() - 1);
                arr_time[0] = milliseconds_buf;
            }
        } else if (type.equals("soap")) {
            if (pet.getCleanliness() < 10) {
                purity.setText(String.valueOf(pet.getCleanliness() + 2));
                pet.setCleanliness(pet.getCleanliness() + 2);
                arr_time[1] = milliseconds_buf;
            }
        } else if (type.equals("water")) {
            if (pet.getThirst() < 10) {
                thirst.setText(String.valueOf(pet.getThirst() + 1));
                pet.setThirst(pet.getThirst() + 1);
                arr_time[2] = milliseconds_buf;
            }
        } else if (type.equals("pill")) {
            if (pet.getImunity() < 10) {
                imunity.setText(String.valueOf(pet.getImunity() + 1));
                pet.setImunity(pet.getImunity() + 1);
                arr_time[3] = milliseconds_buf;
            }
        }
    }

    @FXML
    public void eat() {
        if (pet.getTired() > 10) {
            timecontrol("eat");
            Utils.playSound("eat2.mp3");
            coin.setText(String.valueOf(pet.getTired() - 10));
            pet.setTired(pet.getTired() - 10);
        }
    }
}