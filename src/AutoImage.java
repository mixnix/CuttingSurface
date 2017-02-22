import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by user_name on 22.02.2017.
 */
public class AutoImage {

    private BufferedImage source;
    private BufferedImage currentImage;
    public int desired_width = 600;
    public int desired_height = 300;

    public AutoImage(String fileName, int width) throws IOException{
        source = loadImageFromFile(fileName);
        desired_width = width;
        desired_height = getNewHeight();
        currentImage = resizeImage(BufferedImage.TYPE_INT_ARGB);

    }

    public BufferedImage getTransformed(){
        return currentImage;
    }

    private BufferedImage loadImageFromFile(String fileName) throws IOException{
        BufferedImage bimg = ImageIO.read(new File(fileName));
        return bimg;
    }

    private int getNewHeight(){
        double ratio = this.desired_width / (double) source.getWidth();
        int newHeight = (int) (source.getHeight() * ratio);
        return newHeight;
    }

    private BufferedImage resizeImage(int type) throws IOException {
        BufferedImage resizedImage = new BufferedImage(desired_width, desired_height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(source, 0,0,desired_width, desired_height,null);
        g.dispose();

        return resizedImage;
    }


}
