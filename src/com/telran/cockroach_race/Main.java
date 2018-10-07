package com.telran.cockroach_race;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		HashSet<Player> players = PlayersInterface.getSet();
		if (players.isEmpty()) {
			System.out.println("No players received");
			System.exit(1);
		}
		HashSet<Cockroach> cockroachs = CockroachInterface.getSet();
		if (cockroachs.size() < 2) {
			System.out.println("No cockroachs received");
			System.exit(1);
		}
		
		Game game = new Game(players, cockroachs);
		game.play();
		game.printStatistics();
	}

}
