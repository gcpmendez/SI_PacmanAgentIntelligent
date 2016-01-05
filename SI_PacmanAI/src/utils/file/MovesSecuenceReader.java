/**
 * File name:MovesProgrammingReader.java
 * Package name: filereader
 * Proyect name: SI_PacmanAI
 */
package utils.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import game.core.Game;

public class MovesSecuenceReader {

	private ArrayList<Integer> secuence;

	public MovesSecuenceReader() throws IOException {
		secuence = new ArrayList<>();
		String line = "";
		FileReader f = new FileReader("src/configs/Prove_MovesSecuencePacman.txt");
		BufferedReader b = new BufferedReader(f);
		while ((line = b.readLine()) != null) {
			switch (line) {
			case "UP":
				secuence.add(Game.UP);
				break;

			case "RIGHT":
				secuence.add(Game.RIGHT);
				break;

			case "DOWN":
				secuence.add(Game.DOWN);
				break;

			case "LEFT":
				secuence.add(Game.LEFT);
				break;

			default:
				System.out.println("Error en los datos introducidos");
				break;
			}
		}
		b.close();
	}
	
	public ArrayList<Integer> secuence(){
		return secuence;
	}
}
