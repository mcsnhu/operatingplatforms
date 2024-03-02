package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author matthew cohen
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	private static long nextPlayerId = 0;
	private static long nextTeamId = 0;
 
	private static GameService instance = null;
	// The purpose of the singleton is to guarantee that there is only ever one instance of the class. 
	// In this case it ensures that there is only ever one instance of GameService.
	
	
	private GameService() {
		
	}
	
	public static GameService getInstance() {
		if(instance==null) {
			instance = new GameService();
		}
		return instance;
	}


	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		Iterator<Game> it = games.iterator();
		while(it.hasNext()) {
			if(it.next().getName().equals(name)) {
				game = it.next();
				break;
			}
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId, name);
			nextGameId++;
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;
		
		if(!games.isEmpty()) {
			game = games.get(0);
		}

		Iterator<Game> it = games.iterator();
		while(it.hasNext()) {
			if(it.next().getId()==id) {
				game = it.next();
				break;
			}
		}

		return game;
	}
	// The purpose of the iterator is to conveniently iterate over a collection. 
	// This way we don’t need to check for boundaries since boundary checks will be performed by the iterator. 
	// In this case it iterates over our list of games to find a game with the same ID or name as what was given.

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		Iterator<Game> it = games.iterator();
		while(it.hasNext()) {
			if(it.next().getName().equals(name)) {
				game = it.next();
				break;
			}
		}

		return game;
	}
	
	public long getNextPlayerId() {
		nextPlayerId++;
		return nextPlayerId;
	}
	
	public long getNextTeamId() {
		nextTeamId++;
		return nextTeamId;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}
