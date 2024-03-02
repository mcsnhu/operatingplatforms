package com.gamingroom;

import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * 
 * @author matthew cohen
 *
 */
public class Team extends Entity{
	private List<Player> players;

	/**
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		super(id, name);
	}
	
	public Player addPlayer(String name) {
		GameService gs = GameService.getInstance();
		Player player = null;
		Iterator<Player> it = players.iterator();
		while(it.hasNext()) {
			if(it.next().getName().equals(name)) {
				player = it.next();
				break;
			}
		}
		
		if (player == null) {
			player = new Player(gs.getNextPlayerId(), name);
			players.add(player);
		}
		return player;
	}

	@Override
	public String toString() {
		
		return "Team [id=" + getId() + ", name=" + getName() + "]";
	}
}
