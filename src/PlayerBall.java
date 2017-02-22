import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;

/**
 * Created by user_name on 21.02.2017.
 */
public class PlayerBall extends Sprite {
    private int dx;
    private int dy;

    public PlayerBall(int x, int y){
        super(x, y);

        initBall();
    }

    private void initBall(){
        loadImage("Ball.png",40);
        getImageDimension();
    }

    public void move(){
        x += dx;
        y += dy;
    }

    public int getX(){ return x;}
    public int getY(){ return y;}

    public Image getImage(){return image;}

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT){
            dx = -1;
        }

        if(key == KeyEvent.VK_RIGHT){
            dx = 1;
        }

        if(key == KeyEvent.VK_DOWN){
            dy = 1;
        }

        if(key == KeyEvent.VK_UP){
            dy = -1;
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT){
            dx = 0;
        }

        if(key == KeyEvent.VK_RIGHT){
            dx = 0;
        }

        if(key == KeyEvent.VK_UP){
            dy = 0;
        }

        if(key == KeyEvent.VK_DOWN){
            dy = 0;
        }
    }


}
