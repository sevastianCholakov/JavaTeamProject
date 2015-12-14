package game.table_tennis.entity;

import game.table_tennis.gamestate.SinglePlayerState;
import game.table_tennis.main.GamePanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class RacquetAI extends Rectangle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x = 980;
	private int y = 275;
	
     
	
	public RacquetAI(int width,int height){
		setBounds(0,375,width,height);
	}
	public void tick(){
		
		if (SinglePlayerState.ball.y<y&& y>=0) { 
			y-=2;
		}
		if (SinglePlayerState.ball.y>y && y  < GamePanel.HEIGHT - height) { 
			y+=2;		
	}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(x,y,width,height);
	}
	public void keyPressed(int k){

	}
	public void keyReleased(int k){

	}
	public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
	}
}
