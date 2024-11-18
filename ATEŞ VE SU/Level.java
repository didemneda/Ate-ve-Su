import java.awt.*;
import java.util.ArrayList;

public class Level {

    private int[][] plan;
    private int height=50,width=50;
    public static int  blok_height =15, blok_width =15;
    //private ArrayList<Enemy> enemyArrayList;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Level(){

        plan = new int[height][width];
        SetLevel();
    }
    private void SetLevel(){
        for(int i =0 ; i<plan.length; i++){
            for(int j=0;j<plan[i].length ; j++){

                if(i==2){

                    if(j==0)
                        plan[i][j]=7;
                }
                else if(i==3){

                    if(j==21 || j== 39)
                        plan[i][j]=1;
                    if(j==0)
                        plan[i][j]=7;

                }
                else if(i==4){

                    if(j<8 || (j <11) || (j>16 && j <44))
                        plan[i][j]=1;
                    else if(j>10 && j<17)
                        plan[i][j]=4;
                }

                else if(i== 14){

                    if(j>46)
                        plan[i][j]=3;
                }
                else if(i== 16){

                    if(j==6 || j==44)
                        plan[i][j]=1;
                }
                else if(i== 17){

                    if((j>5 && j<45) || (j<3))
                        plan[i][j]=1;
                }
                else if(i== 21){

                    if(j==48 || j==47)
                        plan[i][j]=1;
                }
                else if(i== 24){

                    if((j<16) || (j>21 && j<30) || (j>37 && j<44))
                        plan[i][j]=1;
                    else if(j>15 && j<22)
                        plan[i][j]=4;
                    else if(j>29 && j<38)
                        plan[i][j]=5;
                    else if(j>43 )
                        plan[i][j]=6;
                }
                else if(i== 29) {

                    if (j == 17 || j == 18 || j == 21 || j == 22)
                        plan[i][j] = 1;
                }
                else if(i==30 && (j==7 || j==36))
                    plan[i][j]=1;
                else if(i==31 && (j==7 || j==36))
                    plan[i][j]=1;

                else if(i==32){

                    if(j<3)
                        plan[i][j]=6;
                    else if(j>2 && j<14)
                        plan[i][j]=1;
                    else if(j>25  && j<39)
                        plan[i][j]=1;
                    else if(j>13 && j<26)
                        plan[i][j]=2;
                }

                else if(i==33  || i==35 ||i==36){
                    if(j==27 || j==28 )
                        plan[i][j]=1;
                }
                else if(i==34){

                    if(j==43 || j== 42 || j==27 || j==28)
                        plan[i][j]=1;
                }
                else if(i==37){

                    if(j==27 || j==28 || j==48 ||j==49  )
                        plan[i][j]=1;
                }
                else if(i>37 && i<41){

                    if((j>23 && j<29)|| (j==48 || j==49))
                        plan[i][j]=1;
                }
                else if(i==41){
                    if((j>19 && j<29) ||(j >44))
                        plan[i][j]=1;
                }
                else if(i==42){
                    if((j==20) ||(j >44))
                        plan[i][j]=1;
                }
                else if(i==43){
                    if((j>4 && j<21) ||(j >44))
                        plan[i][j]=1;
                }
                else if(i>43 &&i<49){
                    if(j>42)
                        plan[i][j]=1;
                }
                else if(i==49){

                    if(j<16 ||j>23)
                        plan[i][j]=1;
                    else if(j>15 && j<24)
                        plan[i][j]=4;
                }
                else
                    plan[i][j] =0;



            }
        }
    }
    public void paintLevel(Graphics g){
        for(int i =0 ; i< plan.length ; i++){
            for(int j=0;j< plan[i].length ; j++){
                if(plan[i][j] == 1)
                {
                    g.setColor(Color.WHITE);
                    g.fillRect(j*blok_width,i*blok_height,blok_width,blok_height);
                }
                if(plan[i][j] == 2)
                {
                    g.setColor(Color.ORANGE);
                    g.fillRect(j*blok_width,i*blok_height,blok_width,blok_height);
                }
                if(plan[i][j] == 3)
                {
                    g.setColor(Color.GRAY);
                    g.fillRect(j*blok_width,i*blok_height,blok_width,blok_height);
                }
                if(plan[i][j] == 4)
                {
                    g.setColor(Color.RED);
                    g.fillRect(j*blok_width,i*blok_height,blok_width,blok_height);
                }
                if(plan[i][j] == 5)
                {
                    g.setColor(Color.BLUE);
                    g.fillRect(j*blok_width,i*blok_height,blok_width,blok_height);
                }
                if(plan[i][j] == 6)
                {
                    g.setColor(Color.GREEN);
                    g.fillRect(j*blok_width,i*blok_height,blok_width,blok_height);
                }
                if(plan[i][j] == 7)
                {
                    g.setColor(Color.PINK);
                    g.fillRect(j*blok_width,i*blok_height,blok_width,blok_height);
                }
            }
        }

    }
    public void updateLevel(Graphics g){
        paintLevel(g);
    }


    public int[][] getPlan() {
        return plan;
    }
}
