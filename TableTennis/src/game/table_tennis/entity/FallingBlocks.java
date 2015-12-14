package game.table_tennis.entity;


import game.table_tennis.gamestate.BlockModeState;
import game.table_tennis.main.GamePanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class FallingBlocks extends Rectangle {

	
	private static final long serialVersionUID = 1L;
	public int x = Random(100, 600);
	public double y = 0;
	private int color1 = 1;
	private int color2 = 5;
	Random r = new Random();
	private int xa = r.nextInt(2) + (-2);
	private int ya = 1;
	public static int lives = 20;

	public FallingBlocks(int width,int height){
		setBounds(350,0,width,height);
	}
	public void tick(){
		if (x + xa>0 && x + xa <GamePanel.HEIGHT - height) {
			y  = y + ya;
		}
		if (collision()) {
			lives--;
		}
		if (y+ ya > GamePanel.HEIGHT - height) {
			lives--;	
		}
		
	}
	private boolean collision() {
		return BlockModeState.racquet3.getBounds().intersects(getBounds());
	}
	

	
	
	private int Random(int min, int max) {
		Random rnd = new Random();
		int randomNum = rnd.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	public void draw(Graphics g){
		if (Random(color1, color2) == 1) {
			g.setColor(Color.BLUE);
		}
		if (Random(color1, color2) == 2) {
			g.setColor(Color.red);
		}
		if (Random(color1, color2) == 3) {
			g.setColor(Color.yellow);
		}
		if (Random(color1, color2) == 4) {
			g.setColor(Color.green);
		}
		
		g.fillRect(x,(int) y,width,height);
	}
	
	public Rectangle getBounds() {
        return new Rectangle(x, (int) y, width, height);
	}
}
