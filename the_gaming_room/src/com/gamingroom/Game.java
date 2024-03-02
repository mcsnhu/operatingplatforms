package com.gamingroom;

import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * @author matthew cohen
 *
 */
public class Game extends Entity{
	private List<Team> teams;

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		super(id, name);
	}
	
	public Team addTeam(String name) {
		GameService gs = GameService.getInstance();
		Team team = null;
		Iterator<Team> it = teams.iterator();
		while(it.hasNext()) {
			if(it.next().getName().equals(name)) {
				team = it.next();
				break;
			}
		}
		
		if (team == null) {
			team = new Team(gs.getNextTeamId(), name);
			teams.add(team);
		}
		return team;
	}

	@Override
	public String toString() {
		
		return "Game [id=" + getId() + ", name=" + getName() + "]";
	}

}
