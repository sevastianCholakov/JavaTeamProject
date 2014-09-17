

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class SinglePlayerState extends GameState {
	public static Racquet racquet;
	public static RacquetAI racquetAI;
	
	public static BallS ball;
	
	public static int p1Score, compScore;
	
	Image background = Toolkit.getDefaultToolkit().createImage("lastgifs/background.png");
	public SinglePlayerState(GameStateManager gsm){
		super(gsm);
	}

	
	public void init() {
		racquet = new Racquet(20,150);
		racquetAI = new RacquetAI(20,150);
		ball = new BallS();
		
	}

	
	public void tick() {
		racquet.tick();
		racquetAI.tick();
		ball.tick();

	}

	
	public void draw(Graphics g) {
		g.drawImage(background,0, 0, null);
		
		racquet.draw(g);
		racquetAI.draw(g);
		ball.draw(g);
		
		g.setColor(Color.BLUE); 
		g.setFont(new Font("Arial",Font.PLAIN, 24));
		g.drawString("Player1 : " + p1Score, 30, 30);
		g.drawString("Computer : " + compScore, 800, 30);
		
	}



	public void keyPressed(int k) {
		racquet.keyPressed(k);
		
	}


	public void keyReleased(int k) {
		racquet.keyReleased(k);
	}
}