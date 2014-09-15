import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
 
public class Racquet {
        private static final int X = 0;
        private static final int HEIGHT = 150;
        private static final int WIDTH = 20;
        int y = 275;
        int ya = 0;
        //Image image = Toolkit.getDefaultToolkit().createImage("/home/melloboy89/Game/TableTennis/lastgifs/board.gif");
        private Game game;
 
        public Racquet(Game game) {
                this.game = game;
        }
 
        public void move() {
                if (y + ya > 0 && y + ya < game.getHeight() - HEIGHT)
                        y = y + ya;
        }
 
        public void paint(Graphics2D g) {
        	g.fillRect(X, y, WIDTH,HEIGHT);
        }
 
        public void keyReleased(KeyEvent e) {
                ya = 0;
        }
 
        public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W)
                        ya = -10;
                if (e.getKeyCode() == KeyEvent.VK_S)
                        ya = 10;
        }
 
        public Rectangle getBounds() {
                return new Rectangle(X, y, WIDTH, HEIGHT);
        }
 
        public int getTopX() {
                return X;
        }
}