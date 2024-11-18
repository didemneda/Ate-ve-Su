import java.awt.*;

public abstract class Entity {
    protected float  x,y;
    protected GamePanel gamePanel;
    protected int can=0;
    protected Color color = Color.BLUE;
    protected int width_entity=15,height_entity=15;
    protected float speed;
    public Entity(float x, float y,GamePanel gamePanel){
        this.x=x;
        this.y=y;
        this.gamePanel=gamePanel;
    }
}
