package game.table_tennis.entity;


import game.table_tennis.gamestate.BlockModeState;
import game.table_tennis.main.GamePanel;
import game.table_tennis.sound.Sound;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Wall extends Rectangle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xa=7;
	public int x =0;
	public int y =700 ;
	
    
	
	public Wall(int width,int height){
		setBounds(350,0,width,height);
	}
	public void tick(){
		if (x + xa>0 && x + xa <GamePanel.WIDTH - width) {
				x = x + xa;	
		}
		if (collision2()) {
			BlockModeState.block = new FallingBlocks(Random(15, 120),Random(15, 120));
			FallingBlocks.lives--;
			Sound.playBlockHit();
		}
		if (collision3()) {
			BlockModeState.block2 = new FallingBlocks(Random(15, 120),Random(15, 120));
			FallingBlocks.lives--;
			Sound.playBlockHit();
		}
		if (collision4()) {
			BlockModeState.block3 = new FallingBlocks(Random(15, 120),Random(15, 120));
			FallingBlocks.lives--;
			Sound.playBlockHit();
		}
		if (collision5()) {
			BlockModeState.block4 = new FallingBlocks(Random(15, 120),Random(15, 120));
			FallingBlocks.lives--;
			Sound.playBlockHit();
		}
		if (collision6()) {
			BlockModeState.block5 = new FallingBlocks(Random(15, 120),Random(15, 120));
			FallingBlocks.lives--;
			Sound.playBlockHit();
		}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(x,y,width,height);
	}
	private int Random(int min, int max) {
		Random rnd = new Random();
		int randomNum = rnd.nextInt((max - min) + 1) + min;
		return randomNum;
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
	public void keyPressed(int k){
		if (k == KeyEvent.VK_LEFT)
            xa = -7;
		if (k == KeyEvent.VK_RIGHT)
            xa = 7;
	}
	public void keyReleased(int k){
		xa = 0;
	}
	
	public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
	}
}
