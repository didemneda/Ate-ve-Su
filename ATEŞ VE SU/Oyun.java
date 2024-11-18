public class Oyun implements Runnable{
    private GamePanel gamePanel;
    private GameFrame gameFrame;
    private Thread gameThread;
    private final int FPS = 120;

    public  Oyun(){
        gamePanel = new GamePanel();
        gameFrame = new GameFrame(gamePanel);
        gamePanel.requestFocus();
        startGame();
    }

    public void startGame(){
        gameThread=new Thread(this);
        gameThread.start();

    }

    public static void main(String[] args) {
        Oyun oyun = new Oyun();
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS;
        long lastFrame = System.nanoTime();
        long now;

        while(true){
                now = System.nanoTime();
            if(now - lastFrame >= timePerFrame){
                gamePanel.repaint();
                lastFrame = now;
            }
        }

    }
}
