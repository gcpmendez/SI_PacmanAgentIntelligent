/**
 * File name:MovesSecuencePacman.java
 * Package name: game.controllers.pacman.examples
 * Proyect name: SI_PacmanAI
 */
package game.controllers.pacman.examples;

import java.io.IOException;
import java.util.ArrayList;

import filereader.MovesSecuenceReader;
import game.PacManSimulator;
import game.controllers.ghosts.game.GameGhosts;
import game.controllers.pacman.PacManHijackController;
import game.core.G;
import game.core.Game;

public class MovesSecuencePacman extends PacManHijackController{
	private int aux;
	private ArrayList<Integer> secuence;
	
	public MovesSecuencePacman() {
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
		pacman.set(secuence.get(aux));
		aux++;
		if(aux >= secuence.size())
			aux = 0;
	}
	
	public static void main(String[] args) {
		PacManSimulator.play(new MovesSecuencePacman(), new GameGhosts(false));
	}
}
