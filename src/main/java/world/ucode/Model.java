package world.ucode;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Model extends Pane {
    public int max;
    public int id;
    private String name;
    private String type;
    private String time;

    private int age;
    private int hunger;
    private int thirst;
    private int tired;
    private int happiness;
    private int cleanliness;
    private int health;
    private int coin;
    private int imunity;
    public boolean isAlive;
    public boolean isSick;

    public Model(ImageView imageView) {
        Database.loadModel(this);
    }

    public void setCoin(int num) {
        this.coin = num;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) { this.type = type; }
    public void setTime(String time) {
        this.time = time;
    }
    public void setMax(int max) {
        this.max = max;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
    public void setThirst(int thirst) {
        this.thirst = thirst;
    }
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }
    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setAlive(boolean alive) {
        isAlive = alive;
    }
    public void setSick(boolean sick) {
        isSick = sick;
    }

    public void setTired(int tired) {
        this.tired = tired;
    }

    public int getTired() {
        return tired;
    }

    public int getCoin() {
        return coin;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getTime() {
        return time;
    }
    
    public void setImunity(int imunity) {
        this.imunity = imunity;
    }

    public int getImunity() {
        return imunity;
    }

    public int getHunger() {
        return hunger;
    }
    public int getThirst() {
        return thirst;
    }
    public int getHappiness() {
        return happiness;
    }
    public int getCleanliness() {
        return cleanliness;
    }
    public int getHealth() {
        return health;
    }
    public int getAliveInt() {
        return isAlive ? 1 : 0;
    }
    public int getSickInt() {
        return isSick ? 1 : 0;
    }

    public void aging() { age++; }
    public int getAge() { return age; }
}