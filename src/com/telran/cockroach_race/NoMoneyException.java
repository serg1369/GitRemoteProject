package com.telran.cockroach_race;

public class NoMoneyException extends Exception {

	private final int id;
	
	public NoMoneyException(String name, int id) {
		super("Player "+name+" doesn't have enough money");
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
