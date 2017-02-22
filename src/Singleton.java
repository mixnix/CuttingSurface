import javax.swing.*;
import java.awt.*;

/**
 * Created by user_name on 21.02.2017.
 */
public class Singleton extends JFrame{
    public Singleton(){
        initUI();
    }

    private void initUI(){
        add(new Board());

        setSize(1000,500);
        setResizable(false);

        setTitle("CuttingSurface");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Singleton game = new Singleton();
                game.setVisible(true);
            }
        });
    }
}
