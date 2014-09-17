package teamproject.menu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class BallB extends Rectangle {

	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	int speed = 0;
	Image image = Toolkit.getDefaultToolkit().createImage(
			"lastgifs/mini-angry-bird.gif");

	public BallB() {
		setBounds(980, 375, image.getWidth(null), image.getHeight(null));
	}

	void tick() {

		if (x + xa < 0) {
			xa = 1;
		}
		if (x + xa > GamePanel.WIDTH - image.getWidth(null)){
			xa = -1;
		}
		if (y + ya < 0)
			ya = 1;
		if (y + ya > GamePanel.HEIGHT - image.getHeight(null))
			if (BlockModeState.Lives != 0) {
				ya = -1;
				BlockModeState.Lives--;
			} else
			{
				GamePanel.gameOver();
			}

		if (collision()) {
			ya = -1;
		}

		x = x + xa;
		y = y + ya;
	}

	private boolean collision() {
		return BlockModeState.racquet.getBounds().intersects(getBounds());
	}

	public void draw(Graphics g) {
		g.drawImage(image, x, y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
	}
}