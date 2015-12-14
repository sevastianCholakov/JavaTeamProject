package game.table_tennis.entity;


import game.table_tennis.gamestate.BlockModeState;
import game.table_tennis.main.GamePanel;
import game.table_tennis.sound.Sound;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Random;

public class BallB extends Rectangle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x = 700;
	int y = 100;
	int xa = 2;
	int ya = 3;
	Image image = Toolkit.getDefaultToolkit().createImage(
			"lastgifs/mini-angry-bird.gif");

	public BallB() {
		setBounds(400, 275, image.getWidth(null), image.getHeight(null));
	}

	public void tick() {

		if (x + xa < 0) {
			xa = 2;
			
		}
		if (x + xa > GamePanel.WIDTH - image.getWidth(null)){
			xa = -2;
		}
		if (y + ya < 0)
			ya = -ya;

		if (y + ya > GamePanel.HEIGHT - image.getHeight(null)){
			ya = -ya;
			FallingBlocks.lives--;
		}
	
		if (collision()) {
			ya = -ya;
			if (ya > -11)
				ya--;
			y = 680 - image.getHeight(null) ;
			Sound.playBlockHit();
		}
		if (collision2()) {
			ya = -ya;
			BlockModeState.block = new FallingBlocks(Random(15, 120),Random(15, 120));
			BlockModeState.p1Score++;
			Sound.playBlockHit();
			if (BlockModeState.p1Score %10 ==0) {
				FallingBlocks.lives +=10;
			}
		}
		if (collision3()) {
			ya = -ya;
			BlockModeState.block2 = new FallingBlocks(Random(15, 120),Random(15, 120));
			BlockModeState.p1Score++;
			Sound.playBlockHit();
			if (BlockModeState.p1Score %10 ==0) {
				FallingBlocks.lives +=10;
			}
		}
		if (collision4()) {
			ya = -ya;
			BlockModeState.block3 = new FallingBlocks(Random(15, 120),Random(15, 120));
			BlockModeState.p1Score++;
			Sound.playBlockHit();
			if (BlockModeState.p1Score %10 ==0) {
				FallingBlocks.lives +=10;
			}
		}
		if (collision5()) {
			ya = -ya;
			BlockModeState.block4 = new FallingBlocks(Random(15, 120),Random(15, 120));
			BlockModeState.p1Score++;
			Sound.playBlockHit();
			if (BlockModeState.p1Score %10 ==0) {
				FallingBlocks.lives +=10;
			}
		}
		if (collision6()) {
			ya = -ya;
			BlockModeState.block5 = new FallingBlocks(Random(15, 120),Random(15, 120));
			BlockModeState.p1Score++;
			Sound.playBlockHit();
			if (BlockModeState.p1Score %10 ==0) {
				FallingBlocks.lives +=10;
			}
		}
		x = x + xa;
		y = y + ya;

	}
	private int Random(int min, int max) {
		Random rnd = new Random();
		int randomNum = rnd.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	private boolean collision() {
		return BlockModeState.racquet3.getBounds().intersects(getBounds());
		
	}
	private boolean collision2() {
		return BlockModeState.block.getBounds().intersects(getBounds());
	}
	private boolean collision3() {
		return BlockModeState.block2.getBounds().intersects(getBounds());
	}
	private boolean collision4() {
		return BlockModeState.block3.getBounds().intersects(getBounds());
	}
	private boolean collision5() {
		return BlockModeState.block4.getBounds().intersects(getBounds());
	}
	private boolean collision6() {
		return BlockModeState.block5.getBounds().intersects(getBounds());
	}

	public void draw(Graphics g) {
		g.drawImage(image, x, y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
	}
}