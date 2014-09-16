package teamproject.menu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class SinglePlayerState extends GameState {
	public static Racquet racquet;
	public static Ball ball;
	Image background = Toolkit.getDefaultToolkit().createImage("lastgifs/background.png");
	public SinglePlayerState(GameStateManager gsm){
		super(gsm);
	}

	
	public void init() {
		racquet = new Racquet(20,150);
		ball = new Ball();
		
	}

	
	public void tick() {
		racquet.tick();
		ball.tick();
		
	}

	
	public void draw(Graphics g) {
		g.drawImage(background,0, 0, null);
		racquet.draw(g);
		
	}
	
	public void paint(Graphics2D g){
		ball.paint(g);
	}


	public void keyPressed(int k) {
		racquet.keyPressed(k);
	}


	public void keyReleased(int k) {
		racquet.keyReleased(k);
	}
}
