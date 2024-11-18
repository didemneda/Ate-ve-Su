import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener{
    private GamePanel gamePanel;

    public Input(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int i = e.getKeyCode();
        if(i == KeyEvent.VK_A){
            gamePanel.getPlayer().changeMove("left");

        }
        if(i == KeyEvent.VK_W){
            gamePanel.getPlayer().changeMove("up");

        }
        if(i == KeyEvent.VK_D){
            gamePanel.getPlayer().changeMove("right");

        }
        if(i == KeyEvent.VK_S){

            gamePanel.getPlayer().changeMove("down");

        }
        if( i == KeyEvent.VK_1){
            gamePanel.getPlayer().changeColor(1);
        }
        if( i == KeyEvent.VK_2){
            gamePanel.getPlayer().changeColor(2);
        }
        if( i == KeyEvent.VK_3){
            gamePanel.getPlayer().changeColor(3);
        }
        if( i== KeyEvent.VK_SPACE){
            gamePanel.getPlayer().Setshoot("shoot");

        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

        int i = e.getKeyCode();
        if(i == KeyEvent.VK_A){
            gamePanel.getPlayer().changeMove("left_null");
        }
        if(i == KeyEvent.VK_W){
            gamePanel.getPlayer().changeMove("up_null");
        }
        if(i == KeyEvent.VK_D){
            gamePanel.getPlayer().changeMove("right_null");
        }
        if(i == KeyEvent.VK_S){
            gamePanel.getPlayer().changeMove("down_null");
        }
        if( i== KeyEvent.VK_SPACE){
            gamePanel.getPlayer().Setshoot("not");

        }

    }
}
