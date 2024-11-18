import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Entity{

    private Random random= new Random();
    public static ArrayList<Enemy> enemyArrayList = new ArrayList<>() ;
    private boolean left;

    public Color getColor() {
        return color;
    }

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }

    public Enemy(float x, float y, GamePanel gamePanel) {
        super(x, y, gamePanel);
        can=3;
        speed = 0.05f;
        int r = random.nextInt(3);

        if(r == 0)
            color = Color.BLUE;
        else if(r == 1)
            color = Color.RED;
        else if(r == 2)
            color = Color.ORANGE;

        enemyArrayList.add(this);

    }
    public void updateEnemy(Graphics g){
        MoveEnemy();
        g.setColor(color);
        g.fillRect((int) x * width_entity, (int) y * height_entity, width_entity, height_entity);
    }


    public void MoveEnemy(){
        int[][]  ar = gamePanel.getLevel().getPlan();

        if( (x>= 0 && x<1) || ar[(int)y][(int)(x-1)] != 0)
            left =false;
        else if((x < ar[0].length - 1 && ar[(int)y][(int)(x+1)] != 0) || (x>=49 && x<50))
            left =true;


        if (x > 0 && left )
            {
                x -= speed;
                if(x> 0 && ar[(int) y][(int) (x - 1)] != 0 )
                    left = false;

            }
        else if (x < ar[0].length - 1 && !left ){
                x+=speed;
                if(x < ar[0].length - 1 && ar[(int) y][(int) (x + 1)] != 0 )
                    left = true;

            }

        if (y < ar.length - 1 && ar[(int) (y + speed)][(int) x] == 0)
                y+=speed;


    }

}
