package game.table_tennis.gamestate;


import game.table_tennis.entity.BallB;
import game.table_tennis.entity.FallingBlocks;
import game.table_tennis.entity.Racquet3;
import game.table_tennis.entity.Wall;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

public class BlockModeState extends GameState {
	public static Racquet3 racquet3;
	public static BallB ball;
	public static FallingBlocks block;
	public static FallingBlocks block2;
	public static FallingBlocks block3;
	public static FallingBlocks block4;
	public static FallingBlocks block5;
	public static Wall wall;
	public static int p1Score;

	Image background = Toolkit.getDefaultToolkit().createImage(
			"lastgifs/background.png");

	public BlockModeState(GameStateManager gsm) {
		super(gsm);
	}

	public void init() {
		racquet3 = new Racquet3(150, 20);
		ball = new BallB();
		wall = new Wall(1000,20);
		block = new FallingBlocks(Random(20, 100), Random(20, 100));
		block2 = new FallingBlocks(Random(20, 100), Random(20, 100));
		block3 = new FallingBlocks(Random(20, 100), Random(20, 100));
		block4 = new FallingBlocks(Random(20, 100), Random(20, 100));
		block5 = new FallingBlocks(Random(20, 100), Random(20, 100));
	}

	private int Random(int min, int max) {
		Random rnd = new Random();
		int randomNum = rnd.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public void tick() {
		racquet3.tick();
		wall.tick();
		ball.tick();
		block.tick();
		block2.tick();
		block3.tick();
		block4.tick();
		block5.tick();

	}

	public void draw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		ball.draw(g);
		wall.draw(g);
		racquet3.draw(g);
		block.draw(g);
		block2.draw(g);
		block3.draw(g);
		block4.draw(g);
		block5.draw(g);

		g.setColor(Color.BLUE);
		g.setFont(new Font("Arial", Font.PLAIN, 24));
		g.drawString("Player Score: " + p1Score, 30, 650);
		g.drawString("Lives:" + FallingBlocks.lives, 900, 650);
	}

	public void keyPressed(int k) {
		racquet3.keyPressed(k);
		wall.keyPressed(k);
	}

	public void keyReleased(int k) {
		racquet3.keyReleased(k);
		wall.keyReleased(k);
	}
	
}