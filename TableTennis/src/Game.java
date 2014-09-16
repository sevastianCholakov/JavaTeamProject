import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
@SuppressWarnings("serial")
public class Game extends JPanel {
 
        Ball ball = new Ball(this);
        Racquet racquet = new Racquet(this);
        Racquet2 racquet2 = new Racquet2(this);
        private static Image background;
        /*int speed = 1;
        private int getScore(){
                return speed -1;
        }*/
        public static int count = 0;
        public static int  threadSpeed = 10;
        public Game() {
                addKeyListener(new KeyListener() {
                        @Override
                        public void keyTyped(KeyEvent e) {
                        }
 
                        @Override
                        public void keyReleased(KeyEvent e) {
                                racquet.keyReleased(e);
                                racquet2.keyReleased(e);
                        }
 
                        @Override
                        public void keyPressed(KeyEvent e) {
                                racquet.keyPressed(e);
                                racquet2.keyPressed(e);
                        }
                        
                       
                });
                loadBackground();
                setFocusable(true);
        }
       
        private void move() {
                ball.move();
                racquet.move();
                racquet2.move();
  
        }
        
        private static void loadBackground(){
        	ImageIcon ii = new ImageIcon("lastgifs/background.png");
        	background = ii.getImage();
        }
        
        @Override
        public void paint(Graphics g) {
                super.paint(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);
                g.drawImage(background,0, 0, null);
                g.setColor(Color.BLUE);
                ball.paint(g2d);
                racquet.paint(g2d);
                racquet2.paint(g2d);
           
        }

        public void gameOver() {
                JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
                System.exit(ABORT);
        }
 
        public static void main(String[] args) throws InterruptedException {
                JFrame frame = new JFrame("Mini Tennis");
                Game game = new Game();
                frame.add(game);
                frame.setSize(1000,700);
                frame.setVisible(true);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                while (true) {
                		//game.tick();
                        game.move();
                        game.repaint();
                        Thread.sleep(threadSpeed);
                        
                }
        }
}