package com.gamingroom;

/**
 * A simple class for basic operations
 * @author matthew cohen
 *
 */
public class Entity {
	private long id;
	private String name;
	
	
	/*
	 * Constructor with an identifier and name
	 */
	private Entity() {
		
	}
	
	public Entity(long id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + "]";
	}
}
