package TeamAuburn.GameProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet3 extends Rectangle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xa=7;
	public int x =450;
	public int y =680 ;
	
    
	
	public Racquet3(int width,int height){
		setBounds(350,0,width,height);
	}
	public void tick(){
		if (x + xa>0 && x + xa <GamePanel.WIDTH - width) {
				x = x + xa;	
		}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(x,y,width,height);
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
