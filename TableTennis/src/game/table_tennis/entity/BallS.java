package game.table_tennis.entity;


import game.table_tennis.gamestate.SinglePlayerState;
import game.table_tennis.main.GamePanel;
import game.table_tennis.sound.Sound;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class BallS extends Rectangle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x = 700;
	int y = 100;
	int xa = -3;
	int ya = 1;
	Image image = Toolkit.getDefaultToolkit().createImage(
			"lastgifs/mini-angry-bird.gif");

	public BallS() {
		setBounds(980, 375, image.getWidth(null), image.getHeight(null));
	}

	public void tick() {

		if (x + xa < 0) {
			xa = 3;
			Sound.playScoreSound();
			SinglePlayerState.compScore++;
		}
		if (x + xa > GamePanel.WIDTH - image.getWidth(null)){
			xa = -3;
			Sound.playScoreSound();
			SinglePlayerState.p1Score++;
		}
		if (y + ya < 0)
			ya = 2;
		if (y + ya > GamePanel.HEIGHT - image.getHeight(null))
			ya = -2;
		if (collision()) {
			Sound.playHitSound();
			xa = -xa;
			if (xa < 11)
				xa++;
			x = 20;
			

		}
		if (collision2()) {
			Sound.playHitSound();
			xa = -xa;
			if (xa > -11)
				xa--;
			x = 980 - image.getWidth(null);
			

		}

		x = x + xa;
		y = y + ya;

	}

	private boolean collision() {

		return SinglePlayerState.racquet.getBounds().intersects(getBounds());

	}

	private boolean collision2() {
		
		return SinglePlayerState.racquetAI.getBounds().intersects(getBounds());
	}

	public void draw(Graphics g) {

		g.drawImage(image, x, y, null);
	}

	public Rectangle getBounds() {
		
		return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
	}
}