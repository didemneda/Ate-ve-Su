import java.awt.*;
import java.util.ArrayList;
import java.util.EventListener;

public class Player extends Entity{

    private int score =0;
    private boolean up,left,right,down;
    private float havalandırma =2f;
    private int sayac=0;
    private float airSpeed =3f;
    private float magenta_airSpeed = 7f;
    private float gravity = 0.2f;
    private  boolean inAir = false;
    private Mermi  mermiler = new Mermi(color,x,y);
    private boolean shoot;
    private ArrayList<Mermi> playerSilah = Mermi.getSilah();
    private int atılanMermiSayısı=0;
    private Mermi mermi;



    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public Player(float x, float y, GamePanel gamePanel) {
        super(x, y,gamePanel);
        can=1;
        speed = 0.1f;
    }
    public int getPlayerCan() {
        return can;
    }
    public void updatePlayer(Graphics g){

            if(deadPlayer())
                System.out.println("Öldün");
            MovePlayer();
            havalandırma();
            ısınlan();
            g.setColor(color);
            g.fillRect((int)x*width_entity ,(int)y*height_entity , width_entity,height_entity);
            UpdateSilah(g);


    }
    public void UpdateSilah(Graphics g ){
        int[][]  ar = gamePanel.getLevel().getPlan();
        if(shoot && atılanMermiSayısı<playerSilah.size() && color !=Color.MAGENTA){
             mermi = playerSilah.get(atılanMermiSayısı);

                 while(mermi.getX()<ar[0].length-1 && ar[(int)mermi.getY()][(int)(mermi.getX() + mermi.getSpeed())] ==0 ){
                     mermi.setX(mermi.getX()+mermi.getSpeed());
                     mermi.drawMermi(g);


                     if(deadEnemy())
                         break;
                     else if(enemyVarMı())
                         break;
                 }


                 atılanMermiSayısı++;
                 shoot=false;
        }


        }


    public boolean deadEnemy(){
        ArrayList<Enemy> enemyArrayList = Enemy.enemyArrayList;
        for(Enemy e : enemyArrayList)
        {
            if((int)e.x-(int)mermi.getX()<=1 && (int)e.x-(int)mermi.getX()>=0  && (int)mermi.getY() - (int)e.y ==0 && mermi .getColor() == e.getColor()){
                e.setCan(e.getCan()-1);
                return true;
            }
            else if((int)mermi.getX()==(int)e.x &&  (int)mermi.getY() - (int)e.y ==0 && mermi.getColor() == Color.RED && e.getColor() == Color.BLUE){
                e.setCan(e.getCan()+1);
                return true;
            }
            else if((int)mermi.getX()==(int)e.x &&  (int)mermi.getY() - (int)e.y ==0 && mermi.getColor() == Color.BLUE && e.getColor() == Color.RED){
                e.setCan(e.getCan()+1);
                return true;
            }


        }
        return false;
    }

    public boolean enemyVarMı(){
        ArrayList<Enemy> enemyArrayList = Enemy.enemyArrayList;
        for(Enemy e : enemyArrayList)
        {
            if((int)e.x -(int)mermi.getX()<=1 && (int)e.x -(int)mermi.getX()>=0 && (int)mermi.getY() - (int)e.y ==0 ){

                return true;
            }

        }
        return false;
    }
    public void ısınlan(){
        int[][]  ar = gamePanel.getLevel().getPlan();
        if(ar[(int)y+1][(int)x] == 6 && x<3){
            y = 20;
            x= 49;
        }
        else if(ar[(int)y+1][(int)x] == 6 && x>44){
            y=25;
            x=2;
        }
    }
    public void havalandırma(){
        int[][]  ar = gamePanel.getLevel().getPlan();
        if(x>46 && y<14 && y>3)
            y-=havalandırma;
    }
    public boolean deadPlayer(){
        ArrayList<Enemy> enemyArrayList = Enemy.enemyArrayList;
        int[][]  ar = gamePanel.getLevel().getPlan();

        for(Enemy e : enemyArrayList)
        {
            if((int)e.x==(int)x &&  (int)e.y - (int)y ==0 ){
                can--;
                return true;
            }

        }
        if(ar[(int)y+1][(int)x] == 2){
            can--;
            return true;
        }
        if((this.color == Color.RED || this.color == Color.MAGENTA) && ar[(int)y+1][(int)x] == 5){
            can--;
            return true;
        }
        if((this.color == Color.BLUE || this.color == Color.MAGENTA) && ar[(int)y+1][(int)x] == 4){
            can--;
            return true;
        }
        return false;
    }
    public void MovePlayer(){
        int[][]  ar = gamePanel.getLevel().getPlan();

        if(up && color == Color.MAGENTA){
            float f = canMoveHere((int)x,(int)y,magenta_airSpeed) ;
            inAir = true;
            sayac++;
            if (y >= f  && sayac==1 && ar[(int)(y-f)][(int)x] == 0 )
                y =  (y - f);


            if(left ) {

                if (x >= speed) {
                    x = x - speed;
                    if (ar[(int)y][(int)x] != 0) {
                        x = x+ speed;
                    }
                }
                if(isOnFloor((int)x,(int)y))
                    inAir=false;
                else{
                    inAir=true;
                    y= y +gravity;
                }

                mermiler.setX(x);
            }
            if(right){

                if(x <= ar[0].length -2 ){
                    x = x + speed;
                    if( ar[(int)y][(int)x] != 0 ){
                        x -=speed;
                    }
                }
                if(isOnFloor((int)x,(int)y))
                    inAir=false;
                else
                { inAir=true;
                    y= y +gravity;}
                mermiler.setX(x);
            }
            mermiler.setX(x);
        }

        else if(up ) {
            float f = canMoveHere((int)x,(int)y,airSpeed);
            inAir = true;
            sayac++;
            if (y >= f && sayac ==1) {
                y =  (y - f);
                if (ar[(int)y][(int)x] != 0 ) {
                    y = y + f;
                }
            }

             if(left ) {
            
                 if (x >= speed) {
                     x = x - speed;
                     if (ar[(int)y][(int)x] != 0) {
                         x = x+ speed;
                     }
                 }
                  if(isOnFloor((int)x,(int)y))
                      inAir=false;
                  else{
                      inAir=true;
                      y= y +gravity;
                  }

                 mermiler.setX(x);
             }
             if(right){
            
                 if(x <= ar[0].length -2 ){
                     x = x + speed;
                     if( ar[(int)y][(int)x] != 0 ){
                         x -=speed;
                     }
                 }
                 if(isOnFloor((int)x,(int)y))
                     inAir=false;
                 else
                 { inAir=true;
                     y= y +gravity;}
                 mermiler.setX(x);
             }
            mermiler.setX(x);
        }
        if(left ) {

            if (x >= speed) {
                x = x - speed;
                if (ar[(int)y][(int)x] != 0) {
                    x = x+ speed;
                }
            }
             if(isOnFloor((int)x,(int)y))
                 inAir=false;
             else
                 inAir=true;
            mermiler.setX(x);
        }
        if(right){

            if(x <= ar[0].length -2 ){
                x = x + speed;
                if( ar[(int)y][(int)x] != 0 ){
                    x -=speed;
                }
            }
            if(isOnFloor((int)x,(int)y))
                inAir=false;
            else
                inAir=true;
            mermiler.setX(x);
        }
        if(!up){


               if(!isOnFloor((int)x,(int)y)){
                   y= y +gravity;

               }
               else
                   sayac=0;

        }
        mermiler.setY(y);

    }


    public void changeMove(String yön){
        if(yön.equals("up"))
            up= true;
        if(yön.equals("down"))
            down=true;
        if(yön.equals("right"))
            right=true;
        if(yön.equals("left"))
            left=true;
        if(yön.equals("up_null"))
            up= false;
        if(yön.equals("down_null"))
            down=false;
        if(yön.equals("right_null"))
            right=false;
        if(yön.equals("left_null"))
            left=false;
    }
    public void changeColor(int i){
        if(i ==1)
            color = Color.RED;
        if(i== 2)
            color = Color.BLUE;
        if(i== 3)
            color = Color.MAGENTA;
        mermiler.setColor(color);
    }
    public boolean isOnFloor(int x,int y){
        int[][] ar = gamePanel.getLevel().getPlan();
        y = y+1;
        if(ar[y][x] != 0){
            return true;
        }

        return false;
    }
    public float canMoveHere(int x,int y,float speed){
              int[][] ar = gamePanel.getLevel().getPlan();
              float s =speed;
              float f = 0;
              while(f<=s){
                  if(y-f>=0  && ar[(int)(y-f)][x] == 0)
                      f+=0.1f;
                  else
                      break;

              }

        return f - 0.1f;
    }


    public void Setshoot(String str) {
        if(str.equals("shoot"))
        {
            shoot=true;
            mermiler.setShoot(true);


        }
    }


}
