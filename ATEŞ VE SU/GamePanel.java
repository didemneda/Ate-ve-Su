import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GamePanel extends JPanel  {

    private Input input= new Input(this);
    private Player player = new Player(25 ,35,this);
    private Level level = new Level();
    private Spawner spawner = new Spawner(this);
    private int enemy_number = 0;
    private int panel_height = 15 * level.getHeight();
    private int panel_width = 15 * level.getWidth();
    private ArrayList<Enemy> enemyArrayList = Enemy.enemyArrayList;



    public Level getLevel() {
        return level;
    }

    public GamePanel(){
            setBackground(Color.BLACK);
            setPanelSize();
            addKeyListener(input);
    }

    private void setPanelSize() {
        Dimension dimension = new Dimension(panel_width,panel_height);
        setMinimumSize(dimension);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
    }



    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
            level.updateLevel(g);
            player.updatePlayer(g);
            if(enemy_number<9){
                spawner.EnemySpawner();
                enemy_number=enemyArrayList.size();
                System.out.println("Enemy sayısı :" +enemy_number);
            }

            for(int i = 0; i<enemy_number; i++)
            {
                Enemy e = enemyArrayList.get(i);
                if(e.getCan()==0){
                    enemyArrayList.remove(e);
                    enemy_number=enemyArrayList.size();
                    Spawner.currentEnemy=enemyArrayList.size();
                    player.setScore(player.getScore()+10);
                    System.out.println("Score: "+player.getScore());

                }
                else
                    e.updateEnemy(g);

            }



        }



    @Override
    public void repaint() {
        super.repaint();
    }

    public Player getPlayer(){return player;}


}
