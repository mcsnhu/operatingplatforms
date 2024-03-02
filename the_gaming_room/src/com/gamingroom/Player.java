package com.gamingroom;

/**
 * A simple class to hold information about a player
 * @author matthew cohen
 *
 */
public class Player extends Entity{
	
	/*
	 * Constructor with an identifier and name
	 */
	public Player(long id, String name) {
		super(id, name);
	}

	@Override
	public String toString() {
		return "Player [id=" + getId() + ", name=" + getName() + "]";
	}
}
