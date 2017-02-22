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
    protected BufferedImage source;
    protected BufferedImage image;
    private final int DESIRED_WIDTH = 40;

    public Sprite(int x, int y){
        this.x = x;
        this.y = y;
        vis = true;
    }

    protected void loadImage(String imageName){
        //revise load image
        try{
            source = loadImageFromFile();
            int h = getNewHeight(source.getWidth(), source.getHeight());
            image = resizeImage(source, DESIRED_WIDTH, h, BufferedImage.TYPE_INT_ARGB);
        }catch (IOException ex){
            Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
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

    private int getNewHeight(int w, int h){
        double ratio = DESIRED_WIDTH / (double) w;
        int newHeight = (int) (h * ratio);
        return newHeight;
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int width, int height, int type) throws IOException{
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0,0,width, height,null);
        g.dispose();

        return resizedImage;
    }

    private BufferedImage loadImageFromFile() throws IOException{
        BufferedImage bimg = ImageIO.read(new File("ball.png"));
        return bimg;
    }

}
