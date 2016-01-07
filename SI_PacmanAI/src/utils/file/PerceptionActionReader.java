/**
 * File name:PerceptionActionReader.java
 * Package name: utils.file
 * Proyect name: SI_PacmanAI
 */
package utils.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import game.core.Game;

public class PerceptionActionReader {

	private ArrayList<ArrayList<Integer>> table;
	
	public PerceptionActionReader() throws IOException {
		table = new ArrayList<>();
		String line = "";
		FileReader f = new FileReader("src/configs/Prove_PerceptionActionPacman.txt");
		BufferedReader b = new BufferedReader(f);
		while ((line = b.readLine()) != null) {
			String[] splited = line.split("\\s+");
			ArrayList<Integer> auxArray = new ArrayList<>();
			for(int i = 0; i < splited.length; i++) {
				String str = splited[i];
				switch (str) {
				case "UP":
					auxArray.add(Game.UP);
					break;

				case "RIGHT":
					auxArray.add(Game.RIGHT);
					break;

				case "DOWN":
					auxArray.add(Game.DOWN);
					break;

				case "LEFT":
					auxArray.add(Game.LEFT);
					break;

				case "EMPTY":
					auxArray.add(PAGlobals.EMPTY);
					break;

				case "PILL":
					auxArray.add(PAGlobals.PILL);
					break;
					
				case "WALL":
					auxArray.add(PAGlobals.WALL);
					break;
					
				default:
					System.out.println("Error en los datos introducidos");
					break;
				}
			}
			table.add(auxArray);
		}
		b.close();
		System.out.println(table.toString());
	}
	
	public ArrayList<ArrayList<Integer>> table(){
		return table;
	}
}
