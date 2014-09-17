package TeamAuburn.GameProject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class BallM extends Rectangle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x = 700;
	int y = 100;
	int xa = -4;
	int ya = 2;
	Image image = Toolkit.getDefaultToolkit().createImage(
			"lastgifs/mini-angry-bird.gif");

	public BallM() {
		setBounds(980, 375, image.getWidth(null), image.getHeight(null));
	}

	void tick() {

		if (x + xa < 0) {
			xa = 3;
			MultiPlayerState.p2Score++;
		}
		if (x + xa > GamePanel.WIDTH - image.getWidth(null)){
			xa = -3;
			MultiPlayerState.p1Score++;
		}
		if (y + ya < 0)
			ya = 1;
		if (y + ya > GamePanel.HEIGHT - image.getHeight(null))
			ya = -1;
		if (collision()) {
			xa = -xa;
			if (xa < 11)
				xa++;
			x = 20;

		}

		if (collision2()) {
			xa = -xa;
			if (xa > -11) {
				xa--;
			}
			x = 980 - image.getWidth(null);

		}

		x = x + xa;
		y = y + ya;

	}

	private boolean collision() {
		return MultiPlayerState.racquet.getBounds().intersects(getBounds());
	}

	private boolean collision2() {
		return MultiPlayerState.racquet2.getBounds().intersects(getBounds());
	}

	public void draw(Graphics g) {
		g.drawImage(image, x, y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
	}
}