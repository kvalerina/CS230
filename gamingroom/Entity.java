package com.gamingroom;

/**
 * A simple base class to hold common attributes for entities in the game.
 * @author karina.aronov@snhu.edu
 */
public class Entity {

    protected long id;
    protected String name;

    protected Entity() {}
    
    public Entity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + "]";
	}
}
