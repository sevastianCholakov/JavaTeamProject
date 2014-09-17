package teamproject.menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class BlockModeState extends GameState {
	public static RacquetB racquet;
	public static BallB ball;
	public static int Lives = 5;
	//public static int counter;
	
	Image background = Toolkit.getDefaultToolkit().createImage("lastgifs/background.png");
	public BlockModeState(GameStateManager gsm){
		super(gsm);
	}
	
	public void init() {	
		racquet = new RacquetB(200,15);
		ball = new BallB();
	}
	
	public void tick() {
		racquet.tick();
		ball.tick();	
	}

	public void draw(Graphics g) {
		g.drawImage(background,0, 0, null);
		ball.draw(g);
		racquet.draw(g);
		g.setColor(Color.BLUE); 
		g.drawString("You have " + Lives + " lives left", 0, 10);
	}
	
	public void keyPressed(int k) {
		racquet.keyPressed(k);
	}

	public void keyReleased(int k) {
		racquet.keyReleased(k);
	}
}