package world.ucode;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Character extends Pane {

    ImageView imageView;
    int count = 3;
    int columns = 3;
    int offsetX = 0;
    int offsetY = 0;
    int width = 32;
    int height = 32;
    int score = 0;
    Rectangle removeRect = null;

    public Character(ImageView imageView){
        this.imageView = imageView;
        this.imageView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        getChildren().addAll(imageView);
    }
    public void moveX(int x){
        boolean right = x>0?true:false;
        for(int i = 0; i < Math.abs(x); i++) {
            if (right) this.setTranslateX(this.getTranslateX() + 1);
            else this.setTranslateX(this.getTranslateX() - 1);
        }
    }
    public void moveY(int y) {
        boolean down = y > 0 ? true : false;
        for (int i = 0; i < Math.abs(y); i++) {
            if (down) this.setTranslateY(this.getTranslateY() + 1);
            else this.setTranslateY(this.getTranslateY() - 1);
        }
    }
}