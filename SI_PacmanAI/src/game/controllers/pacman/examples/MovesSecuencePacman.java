/**
 * File name:MovesSecuencePacman.java
 * Package name: game.controllers.pacman.examples
 * Proyect name: SI_PacmanAI
 */
package game.controllers.pacman.examples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import game.PacManSimulator;
import game.controllers.ghosts.game.GameGhosts;
import game.controllers.pacman.PacManHijackController;
import game.core.G;
import game.core.Game;
import utils.file.MovesSecuenceReader;

public class MovesSecuencePacman extends PacManHijackController{
	private int aux;
	private ArrayList<Integer> secuence;
	
	public MovesSecuencePacman() {
		pacman.set(G.RIGHT);
		// TODO Auto-generated constructor stub
		try {
			MovesSecuenceReader moveSecuenceReader = new MovesSecuenceReader();
			secuence = moveSecuenceReader.secuence();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aux = 0;
	}
	
	@Override
	public void tick(Game game, long timeDue) {	//set flag as true to include reversals	
		int[] directions = game.getPossiblePacManDirs(false);		//set flag as false to prevent reversals
		ArrayList<Integer> list = new ArrayList<Integer>(directions.length);
		for (int i = 0; i < directions.length; i++)
		  list.add(Integer.valueOf(directions[i]));
		
		if (directions.length > 1 && list.contains(secuence.get(aux))) {
			pacman.set(secuence.get(aux));
			System.out.println(secuence.get(aux));
			this.aux++;
		} 
		
		if(this.aux >= secuence.size())
			this.aux = 0;
	}
	
	public static void main(String[] args) {
		PacManSimulator.play(new MovesSecuencePacman(), new GameGhosts(false));
	}
}
