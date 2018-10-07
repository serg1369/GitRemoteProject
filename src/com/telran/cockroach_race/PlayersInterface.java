package com.telran.cockroach_race;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class PlayersInterface {

	public static HashSet<Player> getSet() {

		HashSet<Player> result = new HashSet<>();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			outer: while (true) {
				System.out.println("Please select: \"add\" or \"exit\"");

				String line = in.readLine().trim().toLowerCase();
				switch (line) {
				case "add": {
					System.out.println("Enter player's name");
					String name = in.readLine().trim();
					System.out.println("Enter player's initial balance");
					String balanceStr = in.readLine().trim();
					if (name.length() == 0) {
						System.out.println("Unacceptable player name");
						continue outer;
					}
					int balance;
					try {
						balance = Integer.parseInt(balanceStr);
					} catch (NumberFormatException e) {
						System.out.println("Unacceptable balance");
						continue outer;
					}
					if (balance <= 0 || balance > 1000) {
						System.out.println("Unacceptable balance");
						continue outer;
					}

					Player player = new Player(name, balance);
					if (result.contains(player)) {
						System.out.println("Unacceptable player name");
						continue outer;
					}
					result.add(player);
				}
					break;
				case "exit":

					break outer;
				default:

					break;
				}

			}

		} catch (IOException e) {

		}
		return result;
	}

}
