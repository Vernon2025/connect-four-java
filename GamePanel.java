import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    //SCREEN SETTINGS
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int SCREEN_WIDTH = tileSize * maxScreenCol; // 768 pixels
    public final int SCREEN_HEIGHT = tileSize * maxScreenRow; // 576 pixels

    // FPS
    int FPS = 16; // 16 milliseconds = 60 FPS

    // DISK
    int diskSpeed = 5;
    int diskPositionY;
    int diskSize = 40;

    // SYSTEM
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;


    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }


    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {
        while (gameThread != null) {
            update();
            repaint();
            try {
                Thread.sleep(FPS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        
    }




    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.RED);
        g2D.fillOval(0, 0, 100, 100);
        g2D.dispose();
    }



}