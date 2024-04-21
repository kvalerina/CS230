package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A singleton service for the game engine
 * 
 * @author karina.aronov@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();
	private static List<Team> teams = new ArrayList<>();
    private static List<Player> players = new ArrayList<>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	/*
	 * Holds the next team identifier
	 */
	private static long nextTeamId = 1;
		
	/* 
	 * Holds the next player identifier
	 */
	private static long nextPlayerId = 1;

	/**
	 *  The Private Static makes it so the instance of GameService 
	 *  is stored in service if it doesn't already exist
	 */  
	 
	private static GameService service = null;
		
	/** A singleton pattern ensures that only one instance of this class
	 *  is created and accessible in this application. This is important for
	 *  GameService because it centralizes the management of game instances, 
	 *  ensuring consistent and unified access to the games list across the 
	 *  entire application.
	 *  
	 *  The Iterator pattern is used to move through the games list efficiently and safely, 
	 *  without exposing it's internal structure and providing a standardized method 
	 *  to access elements.
	 */
		
	// Empty constructor
	private GameService() {}
		
	/**
	* Checks if an existing GameService instance
	* exists. If not it makes one, if so then it 
	* returns the instance.
	* 
	* @return the gameservice instance (new or existing)
	*/
	public static GameService getInstance() {
			
		if (service == null) {
			service = new GameService();
		}
		return service;
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

		// iterate Games to look for existing game with the same name and if found return the existing instance
		for (Game existingGame : games) {
	        if (existingGame.getName().equals(name)) {
	            game = existingGame; // Assign the existing game to the local variable
	            break; // Exit the loop as we've found the game we were looking for
	        }
	    }

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * 
	 * Scope is package/local for testing purposes.
	 * 
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
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

		// looks through games to see if id exists
	    for (Game existingGame : games) {
	        if (existingGame.getId() == id) {
	            game = existingGame; // Assign the found game to the local variable
	            break; // Exit the loop as we've found the game we were looking for
	        }
	    }
		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// looks through games to see if name exists
	    for (Game existingGame : games) {
	        if (existingGame.getName().equals(name)) {
	            game = existingGame; // Assign the found game to the local variable
	            break; // Exit the loop as we've found the game we were looking for
	        }
	    }

	return game;
	} 

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	public Team addTeam(String name) {
	    Iterator<Team> iterator = teams.iterator();
	    while (iterator.hasNext()) {
	        Team team = iterator.next();
	        if (team.getName().equals(name)) {
	            // Team with the given name already exists, so return it
	            return team;
	        }
	    }
	    // No existing team found with the given name, create a new one
	    Team newTeam = new Team(nextTeamId++, name);
	    teams.add(newTeam);
	    return newTeam;
	}

	public Player addPlayer(String name) {
	    Iterator<Player> iterator = players.iterator();
	    while (iterator.hasNext()) {
	        Player player = iterator.next();
	        if (player.getName().equals(name)) {
	            // Player with the given name already exists, so return it
	            return player;
	        }
	    }
	    // No existing player found with the given name, create a new one
	    Player newPlayer = new Player(nextPlayerId++, name);
	    players.add(newPlayer);
	    return newPlayer;
	}
}
