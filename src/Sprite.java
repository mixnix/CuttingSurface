import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by user_name on 21.02.2017.
 */
public class Sprite {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean vis;
    protected BufferedImage image;
    private final int DESIRED_WIDTH = 40;

    public Sprite(int x, int y){
        this.x = x;
        this.y = y;
        vis = true;
    }

    protected void loadImage(String imageName, int preferredWidth){
        try{
            AutoImage temp = new AutoImage("ball.png", preferredWidth);
            image = temp.getTransformed();
        }catch (IOException ex){
            Logger.getLogger(AutoImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void getImageDimension(){
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public Image getImage(){
        return image;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean isVisible(){
        return vis;
    }

    public void setVisible(Boolean visible){
        vis = visible;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }
}
