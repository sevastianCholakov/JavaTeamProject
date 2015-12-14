package game.table_tennis.main;


import game.table_tennis.entity.FallingBlocks;
import game.table_tennis.gamestate.BlockModeState;
import game.table_tennis.gamestate.GameStateManager;
import game.table_tennis.gamestate.MultiPlayerState;
import game.table_tennis.gamestate.SinglePlayerState;
import game.table_tennis.sound.Sound;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable, KeyListener {
	
	public static final long serialVersionUID = 1L;
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 700;
	
	public static Thread thread;
	private boolean isRunning = false;
	
	private int FPS = 60;
	private long targetTime = 1000/FPS;
	
	private GameStateManager gsm;
	public GamePanel(){
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		addKeyListener(this);
		setFocusable(true);
		
		start();
	}
	
	private void start(){    //
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	
	
	public void keyTyped(KeyEvent e) {
		
		
	}


	public void keyPressed(KeyEvent e) {
		gsm.keyPressed(e.getKeyCode());
		
	}

	
	public void keyReleased(KeyEvent e) {
		gsm.keyReleased(e.getKeyCode());
		
	}

	public void run() { // our gameloop
		long start,elapsed,wait;
		Sound.playSinglePlayerStart();
		
		gsm = new GameStateManager();
		while (isRunning) { // if isRunning is false the game will terminate
			start = System.nanoTime();
			
			tick();
			repaint();
			
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;/* if it does everything in less than 60 FPS 
													we are going to sleep the thread a little 
													bit so it doesn't run faster on better computers
*/			
			if (wait<=0) {
				wait = 5;
			}
			try {
				Thread.sleep(5);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void tick(){
		gsm.tick();
	    if (FallingBlocks.lives <= 0) {
	    	Sound.playGameOverSound();
	    	gameOverB();
	    }
	    
	    if (SinglePlayerState.p1Score == 10) {
	    	Sound.playGameOverSound();  
	    	gameOverS1();
	    }
	    if (SinglePlayerState.compScore == 10) {
	    	Sound.playGameOverSound();
	    	gameOverS2();
	    }
	    
	    if (MultiPlayerState.p1Score == 10 ) {
	    	Sound.playGameOverSound();
			gameOverS1();
	    }
	    if (MultiPlayerState.p2Score == 10 ) {
	    	Sound.playGameOverSound();
	    	gameOverM2();
	    }
	}
	private void gameOverB() {
        JOptionPane.showMessageDialog(this, "Your score is " + BlockModeState.p1Score,
                "Game Over", JOptionPane.YES_NO_OPTION);

        System.exit(0);
	}
	private void gameOverS1() {
        JOptionPane.showMessageDialog(this, "Player1 wins",
                "Game Over", JOptionPane.YES_NO_OPTION);

        System.exit(0);
	}
	private void gameOverS2() {
        JOptionPane.showMessageDialog(this, "Computer wins",
                "Game Over", JOptionPane.YES_NO_OPTION);

        System.exit(0);
	}
	private void gameOverM2() {
        JOptionPane.showMessageDialog(this, "Player2 wins",
                "Game Over", JOptionPane.YES_NO_OPTION);
        
        System.exit(0);
	}
	
	
	public void paintComponent(Graphics g ){
		super.paintComponent(g);
		
		g.clearRect(0, 0, WIDTH, HEIGHT); // clears the whole screen before it redraws it
		gsm.draw(g);
	}
}
