import java.util.Random;

public class Spawner {
    private GamePanel gp;
    public final static int ENEMYNUMBER = 9;
    public static int currentEnemy = 0;


    public Spawner(GamePanel gp){

        this.gp = gp ;



    }
    public void EnemySpawner(){
        int a=0; int b=0; int c=0; int d=0; int e=0; int f=0; int g=0;int h=0; int ı=0;
        while (currentEnemy <ENEMYNUMBER){
        Random r = new Random();

        int i = r.nextInt(9);
        if(i==0 && a==0){
            new Enemy(28,3,gp);
            a++;
            currentEnemy++;
        }
        else if(i==1 && b==0){
            new Enemy(17,16,gp);
            currentEnemy++;
            b++;
        }
        else if(i== 2 && c==0){
            new Enemy(35,16,gp);
            currentEnemy++;
            c++;
        }
        else if(i==3&& d==0){
            new Enemy(10,23,gp);
            currentEnemy++;
            d++;
        }
        else if(i==4&& e==0){
            new Enemy(39,23,gp);
            currentEnemy++;
            e++;
        }
        else if(i==5 && f==0){
            new Enemy(8,31,gp);
            currentEnemy++;
            f++;
        }
        else if(i==6 && g==0) {
            new Enemy(10, 42, gp);

            currentEnemy++;
            g++;
        }
        else if(i==7 && h==0) {
            new Enemy(42, 48, gp);
            currentEnemy++;
            h++;
        }
        else if(i==8 && ı==0) {

            new Enemy(22,40,gp);
            currentEnemy++;
            ı++;
        }
        }
        currentEnemy =Enemy.enemyArrayList.size();
    }


}
