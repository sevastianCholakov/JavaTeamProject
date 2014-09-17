package TeamAuburn.GameProject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class BallB extends Rectangle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x = 700;
	int y = 100;
	int xa = 1;
	int ya = 3;
	Image image = Toolkit.getDefaultToolkit().createImage(
			"lastgifs/mini-angry-bird.gif");

	public BallB() {
		setBounds(400, 275, image.getWidth(null), image.getHeight(null));
	}

	void tick() {
		
		if (x + xa < 0) {
			xa = 1;

		}
		if (x + xa > GamePanel.WIDTH - image.getWidth(null)){
			xa = -1;

		}
		if (y + ya < 0)
			ya = -ya;
		if (y + ya > GamePanel.HEIGHT - image.getHeight(null))
			ya = -ya;
		if (collision()) {
			//Sound.playHitSound();
			ya = -ya;
			if (ya > -11)
				ya--;
			y = 680 - image.getHeight(null) ;
			

		}
		x = x + xa;
		y = y + ya;

	}

	private boolean collision() {
		return BlockModeState.racquet3.getBounds().intersects(getBounds());
	}



	public void draw(Graphics g) {
		g.drawImage(image, x, y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
	}
}