/**
 * File name:PerceptionActionPacman.java
 * Package name: game.controllers.pacman.examples
 * Proyect name: SI_PacmanAI
 */
package game.controllers.pacman.examples;

import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.net.NetworkInterface;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

import game.PacManSimulator;
import game.controllers.ghosts.game.GameGhosts;
import game.controllers.pacman.PacManHijackController;
import game.core.Game;
import utils.file.PAGlobals;
import utils.file.PerceptionActionReader;

public class PerceptionActionPacman extends PacManHijackController {

	private ArrayList<ArrayList<Integer>> PATable;

	public PerceptionActionPacman() {
		// TODO Auto-generated constructor stub
		try {
			PerceptionActionReader perceptionActionReader = new PerceptionActionReader();
			PATable = perceptionActionReader.table();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void tick(Game game, long timeDue) {
		int[] neightbours = this.game.getPacManNeighbours();
		
		/*for (int i = 0; i < neightbours.length; i++) {
			if (neightbours[i] != -1)
				System.out.print(this.game.getPillIndex(neightbours[i])+",");
			else if(neightbours[i] == -1)
				System.out.print(neightbours[i]+",");
		}
		System.out.println("");*/
		
		boolean stop = false;
		for (int i = 0; i < PATable.size(); i++) {
			if (stop == true)
				break;
			for (int j = 0; j < PATable.get(i).size(); j++) {
				if (j == 4) {
					pacman.set(PATable.get(i).get(j));
					stop = true;
				} else {
					if (neightbours[j] == Game.EMPTY) {
						if (PATable.get(i).get(j) != PAGlobals.WALL)
							break;
					} else {
						if (this.game.getPillIndex(neightbours[j]) == Game.EMPTY
								&& PATable.get(i).get(j) != PAGlobals.EMPTY)
							break;
						/*if (this.game.getPillIndex(neightbours[j]) != Game.EMPTY
								&& PATable.get(i).get(j) != PAGlobals.PILL)
							break;*/
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		PacManSimulator.play(new PerceptionActionPacman(), new GameGhosts(false));
	}
}
