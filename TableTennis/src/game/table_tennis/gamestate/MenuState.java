package game.table_tennis.gamestate;

import game.table_tennis.main.GamePanel;
import game.table_tennis.sound.Sound;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
public class MenuState extends GameState { // this class takes all the methods of the GameState Class
	private String[] options = {"SinglePlayer","MultiPlayer","BlockMode","Quit"};
	private int currentSelection = 0;
	
	public MenuState(GameStateManager gsm){
		super(gsm);
	};
	public void init(){	}
	
	public void tick(){ }
	public void draw(Graphics g){
		g.setColor(new Color(100,0,50));
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		for (int i = 0; i < options.length; i++) {
			if (i == currentSelection) {
				g.setColor(Color.GREEN );
			}
			else {
				g.setColor(Color.BLUE);
			}
		
			g.setFont(new Font("Arial",Font.PLAIN, 72));
			g.drawString(options[i],GamePanel.WIDTH/2 -200, 100+ i*150);
		
		}
	}
	public void keyPressed(int k){
		if (k == KeyEvent.VK_S || k == KeyEvent.VK_DOWN) {
			Sound.playSelectSound();
			currentSelection++;
			if(currentSelection >= options.length){
				currentSelection = 0;
			}
		}
		else if (k == KeyEvent.VK_W || k == KeyEvent.VK_UP) {
			Sound.playSelectSound();
			currentSelection --;
			if (currentSelection < 0) {
				currentSelection = options.length - 1;
			}
		}
		if (k == KeyEvent.VK_ENTER) {
			if (currentSelection== 0) {
				Sound.playMultiStart();
				try {
					Thread.sleep(1100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				gsm.states.push(new SinglePlayerState(gsm));
			}
			else if (currentSelection==1) {
				Sound.playMultiStart();
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				gsm.states.push(new MultiPlayerState(gsm));
			}
			else if (currentSelection==2) {
				Sound.playMultiStart();
				try {
					Thread.sleep(1100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				gsm.states.push(new BlockModeState(gsm));
			}
			else if (currentSelection == 3) {
				Sound.playGameOverSound();
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
		}
	}
	public void keyReleased(int k){
	
	}


}
