package game.table_tennis.gamestate;


import java.awt.Graphics;
import java.util.Stack;


public class GameStateManager { /*manages all the states in the game and updates
 									whichever one is currently on top of the stack
 									and after that we implemeted  in the GamePanel Class which is inside the methods of the Game State Manager Class*/ 
	
	
	
	public Stack<GameState> states; // we create a stack of game states
	public GameStateManager(){
		states = new Stack<GameState>();
		states.push(new MenuState(this));// pushes a state on top of the stack
	}
	public void tick(){
		states.peek().tick(); //its going to look at the top of the stack, so whatever state we add, we pushed under the stack and deleted tha last one we pushed under the stack 	and its gonna update that
	}
	public void draw(Graphics g){
		states.peek().draw(g);
	}

	public void keyPressed(int k){
		states.peek().keyPressed(k);
	}
	public void keyReleased(int k){
		states.peek().keyReleased(k);
	}
}
