package game.table_tennis.main;


import game.table_tennis.sound.Sound;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class Game {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Sound.playBackGroundLooped();
		JFrame frame = new JFrame("AngryTennis");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.add(new GamePanel(),BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
