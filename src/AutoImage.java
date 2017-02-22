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

    public AutoImage(String fileName) throws IOException{
        source = loadImageFromFile(fileName);
    }

    private int getNewHeight(int w, int h){
        double ratio = DESIRED_WIDTH / (double) w;
        int newHeight = (int) (h * ratio);
        return newHeight;
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int width, int height, int type) throws IOException {
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0,0,width, height,null);
        g.dispose();

        return resizedImage;
    }

    private BufferedImage loadImageFromFile(String fileName) throws IOException{
        BufferedImage bimg = ImageIO.read(new File(fileName));
        return bimg;
    }
}
