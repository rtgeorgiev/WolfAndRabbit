package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author greg
 */

/**
 * A world with some bodies.
 */
public class GameWorld extends World {
    private Rabbit rabbit;
    private Wolf wolf;
    private Carrot carrot;

    public GameWorld() {
        super();
        
        // make the ground
        Shape groundShape = new BoxShape(11, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));
        // walls
        /*Shape leftWallShape = new BoxShape(0.5f, 6, new Vec2(-11.5f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 6, new Vec2(11.5f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);
         */


        // make platforms
        Shape boxShape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-7, 5.5f));
        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(5, -2.5f));


        // make a character
        rabbit = new Rabbit(this);
        rabbit.setPosition(new Vec2(8, -10));

        wolf = new Wolf(this);
        wolf.setPosition(new Vec2(-6, -10));
        wolf.addCollisionListener(new Pickup(rabbit));

        carrot = new Carrot(this);
        carrot.setPosition(new Vec2(-6,7));
        carrot.addCollisionListener(new Pickup(rabbit));


        for (int i = 0; i < 11; i++) {
            Body cabbage = new Cabbage(this);
            cabbage.setPosition(new Vec2(i * 2 - 10, 10));
            cabbage.addCollisionListener(new Pickup(rabbit));
        }
    }
    
    public Rabbit getRabbit() {
        return rabbit
                ;
    }

    public Wolf getWolf(){
        return wolf;
    }
    }


