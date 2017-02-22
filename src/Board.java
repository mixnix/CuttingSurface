import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by user_name on 21.02.2017.
 */
public class Board extends JPanel implements ActionListener {
    private final int ICRAFT_X = 40;
    private final int ICRAFT_Y = 60;
    private final int B_WIDTH = 1000;
    private final int B_HEIGHT = 500;
    private final int DELAY = 15;
    private Timer timer;
    private PlayerBall player;
    private boolean ingame;



    public Board(){
        initBoard();
    }

    private void initBoard(){
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.black);
        ingame = true;

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        player = new PlayerBall(ICRAFT_X, ICRAFT_Y);

        timer = new Timer(DELAY, this);
        timer.start();
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        drawObjects(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics g){
        if(player.isVisible()){
            g.drawImage(player.getImage(), player.getX(), player.getY(), this);
        }

        g.setColor(Color.white);
    }

    @Override
    public void actionPerformed(ActionEvent e){


        updatePlayer();

        repaint();
    }

    private void updatePlayer(){
        if(player.isVisible()){
            player.move();
        }
    }



    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e){
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e){
            player.keyPressed(e);
        }
    }
}
