package com.telran.cockroach_race;

public class Cockroach {

	private final String name;
	private int nWins = 0;
	
	public Cockroach(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getnWins() {
		return nWins;
	}
	
	public void incrementWins() {
		nWins++;
	}

	@Override
	public String toString() {
		return "Cockroach " + name + " won " + nWins + " times";
	}
	
	
}
