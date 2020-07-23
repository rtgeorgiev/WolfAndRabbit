package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel {

    private static final int NUM_CABBAGES = 3;

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
        /*Shape leftWallShape = new BoxShape(0.5f, 6, new Vec2(-11.5f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 6, new Vec2(11.5f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);
         */


        // make platforms
        Body platform1 = new Platform(this, 4, 0.5f);
        platform1.setPosition(new Vec2(-7, 5.5f));
        Body platform2 = new Platform(this, 4, 0.5f);
        platform2.setPosition(new Vec2(5, -2.5f));


        for (int i = 0; i < 11; i++) {
            Body cabbage = new Cabbage(this);
            cabbage.setPosition(new Vec2(i*2-10, 10));
            cabbage.addCollisionListener(new Pickup(getRabbit()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
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
        return 1;
    }

    @Override
    public Image getBackgroundImage() {
        return new ImageIcon("data/game-background.jpg").getImage();
    }

}

