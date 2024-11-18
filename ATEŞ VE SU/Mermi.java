import java.awt.*;
import java.util.ArrayList;

public class Mermi {
    private static ArrayList<Mermi> silah = new ArrayList<>();
    private static int mermi_sayısı =100000;
    private float speed = 0.4f;
    private float x,y;
    private Color color;
    private boolean shoot = false;
    //private boolean left,right = true;


    public Color getColor() {
        return color;
    }

    public Mermi(Color color, float x, float y){
        this.x=x;
        this.y=y;
        this.color = color;
        for(int i =0 ; i<mermi_sayısı ; i++)
            silah.add(this);
    }
   /* public static int getMermi_sayısı() {
        return mermi_sayısı;
    }*/

    public void drawMermi(Graphics g){

            g.fillRect((int)x*Level.blok_width ,(int) y*Level.blok_height, 10,10);
    }


    public static ArrayList<Mermi> getSilah() {
        return silah;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getSpeed() {
        return speed;
    }

   /* public boolean isShoot() {
        return shoot;
    }*/

    public void setShoot(boolean shoot) {
        this.shoot = shoot;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
