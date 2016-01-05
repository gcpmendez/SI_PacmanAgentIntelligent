/**
 * File name:MovesSecuencePacman.java
 * Package name: game.controllers.pacman.examples
 * Proyect name: SI_PacmanAI
 */
package game.controllers.pacman.examples;

import java.io.IOException;
import java.util.ArrayList;
import game.PacManSimulator;
import game.controllers.ghosts.game.GameGhosts;
import game.controllers.pacman.PacManHijackController;
import game.core.Game;
import utils.file.MovesSecuenceReader;

public class MovesSecuencePacman extends PacManHijackController{
	private int aux;
	private ArrayList<Integer> secuence;
	private boolean first;
	
	public MovesSecuencePacman() {
		// TODO Auto-generated constructor stub
		try {
			MovesSecuenceReader moveSecuenceReader = new MovesSecuenceReader();
			secuence = moveSecuenceReader.secuence();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aux = 1;
		first = true;
	}
	
	@Override
	public void tick(Game game, long timeDue) {	//set flag as true to include reversals	
		//pacman.set(Game.RIGHT);
		if(first) {
			pacman.set(secuence.get(0));
			first = false;
		}
		int[] directions = game.getPossiblePacManDirs(false);		//set flag as false to prevent reversals
		ArrayList<Integer> list = new ArrayList<Integer>(directions.length);
		for (int i = 0; i < directions.length; i++)
		  list.add(Integer.valueOf(directions[i]));		
		
		if(aux >= secuence.size())
			aux = 0;
		
		if (directions.length > 1 && list.contains(secuence.get(aux))) {
			pacman.set(secuence.get(aux));
			aux++;
			//System.out.println(secuence.get(aux));	
		} 	
	}
	
	@Override
	public void reset(Game game) {
		super.reset(game);
		aux = 1;
		first = true;
	}
	
	public static void main(String[] args) {
		PacManSimulator.play(new MovesSecuencePacman(), new GameGhosts(false));
	}
}
