import javax.swing.*;

public class GameFrame extends JFrame {

    private int width = 800;
    private int height = 800;
    public GameFrame(GamePanel gamePanel){
        setTitle("Ateş ve Su");


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(gamePanel);
        setResizable(false);
        pack();
        setVisible(true);


    }


}
