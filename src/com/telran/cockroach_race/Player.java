package com.telran.cockroach_race;

public class Player {

	private static int instanceCounter = 0;

	private final String name;
	private int balance;
	private final int id;
	private int nGames = 0;

	public Player(String name, int balance) {

		this.name = name;
		this.balance = balance;
		id = ++instanceCounter;

	}

	@Override
	public String toString() {
		return "Player " + name + " has balance=" + balance + ", id=" + id + ", nGames="+nGames;
	}

	public int credit(int amount) throws NoMoneyException {
		if (balance == 0) {
			throw new NoMoneyException(name, id);
		}

		int result;

		if (balance - amount >= 0) {
			result = amount;
		} else {
			result = balance;
		}

		balance -= result;

		nGames++;
		return result;
	}

	public void debit(int amount) {
		balance += amount;
	}

	public static int getInstanceCounter() {
		return instanceCounter;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Player))
			return false;
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	

}
