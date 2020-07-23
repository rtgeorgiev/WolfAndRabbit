package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * A level of the game.
 */
public abstract class GameLevel extends World {
    private Rabbit rabbit;
    private Wolf wolf;
    private Carrot carrot;
    
    public Rabbit getRabbit() {
        return rabbit;
    }
    public Wolf getWolf() { return wolf; }
    public Carrot getCarrot() {return carrot; }

    public void setRabbit(Rabbit r){ rabbit = r ; }
    
    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     */
    public void populate(Game game) {
        rabbit = new Rabbit(this);
        rabbit.setPosition(startPosition());

        wolf = new Wolf(this);
        wolf.setPosition(new Vec2(-6, -10));
        wolf.addCollisionListener(new Pickup(rabbit));

        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));

        carrot = new Carrot(this);
        carrot.setPosition(new Vec2(-6, 7));
        carrot.addCollisionListener(new Pickup(rabbit));
    }
    
    /** The initial position of the player. */
    public abstract Vec2 startPosition();
    
    /** The position of the exit door. */
    public abstract Vec2 doorPosition();
    
    /** Is this level complete? */
    public abstract boolean isCompleted();

    public abstract int getLevelNumber();

    public abstract Image getBackgroundImage();
}
