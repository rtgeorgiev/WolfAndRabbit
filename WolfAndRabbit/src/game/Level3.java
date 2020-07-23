package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

/**
 * Level 2 of the game
 */
public class Level3 extends GameLevel {

    private static final int NUM_CABBAGES = 21;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Platform ground = new Platform(this, 11, .5f);
        ground.setPosition(new Vec2(0, -11.5f));

        // walls
        //Shape leftWallShape = new BoxShape(0.5f, 6, new Vec2(-11.5f, 5.5f));
        //Fixture leftWall = new SolidFixture(ground, leftWallShape);
        //Shape rightWallShape = new BoxShape(0.5f, 6, new Vec2(11.5f, 5.5f));
        //Fixture rightWall = new SolidFixture(ground, rightWallShape);


        // make some platforms
        Body platform1 = new Platform(this, 4, 0.5f);
        platform1.setPosition(new Vec2(-7, 5.5f));
        //Body platform2 = new Platform(this, 4, 0.5f);
        //platform2.setPosition(new Vec2(5, -2.5f));
        //platform1.setFillColor(Color.blue);


        for (int i = 0; i < NUM_CABBAGES; i++) {
            Body orange = new Cabbage(this);
            orange.setPosition(new Vec2(i * 2 - 10, 10));
            orange.addCollisionListener(new Pickup(getRabbit()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(8, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-10.4f, -9.6f);
    }

    @Override
    public boolean isCompleted() {
        return getRabbit().getCabbageCount() >= NUM_CABBAGES;
    }

    @Override
    public int getLevelNumber() {
        return 3;
    }

    @Override
    public Image getBackgroundImage() {
        return new ImageIcon("data/img3.jpg").getImage();
    }
}
