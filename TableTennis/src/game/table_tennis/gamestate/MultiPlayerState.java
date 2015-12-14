package game.table_tennis.gamestate;


import game.table_tennis.entity.BallM;
import game.table_tennis.entity.Racquet;
import game.table_tennis.entity.Racquet2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class MultiPlayerState extends GameState {
	public static Racquet racquet;
	public static Racquet2 racquet2;
	public static BallM ball;

	public static int p1Score, p2Score;
	public static int counter;
	
	Image background = Toolkit.getDefaultToolkit().createImage("lastgifs/background.png");
	public MultiPlayerState(GameStateManager gsm){
		super(gsm);
	}

	
	public void init() {
		
		racquet = new Racquet(20,150);
		racquet2 = new Racquet2(20,150);
		ball = new BallM();

		
	}

	
	public void tick() {
		racquet.tick();
		racquet2.tick();
		ball.tick();

		
	}

	
	public void draw(Graphics g) {
		g.drawImage(background,0, 0, null);
		
		ball.draw(g);

		
		racquet.draw(g);
		racquet2.draw(g);
		
		g.setColor(Color.BLUE);
		g.setFont(new Font("Arial",Font.PLAIN, 24));
		g.drawString("Player 1 : " + p1Score, 30, 30);
		g.drawString("Player 2 : " + p2Score, 810, 30);
		
	}
	
	public void keyPressed(int k) {
		racquet.keyPressed(k);
		racquet2.keyPressed(k);
	}


	public void keyReleased(int k) {
		racquet.keyReleased(k);
		racquet2.keyReleased(k);
		
	}
}