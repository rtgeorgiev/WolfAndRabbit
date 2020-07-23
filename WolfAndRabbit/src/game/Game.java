package game;

import city.cs.engine.*;

import java.awt.*;
import java.util.List;

import javax.naming.ldap.Control;
import javax.swing.*;

import org.jbox2d.common.Vec2;

/**
 * The computer game.
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel world;

    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private MyView view;

    private int level;

    private Controller controller;

    private Tracker tracker;

    private final JFrame frame;

    JFrame debugView;
    /**
     * Initialise a new Game.
     */
    public Game() {

        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);

        view = new MyView(world, world.getRabbit(), 500, 500);
        view.setZoom(20);
        // make a view
        view.setCurrentLevel(world);
        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        // display the view in a frame
        frame = new JFrame("Event handling");

        ControlPanel p = new ControlPanel(this);
        frame.add(p.mainPanel, BorderLayout.EAST);

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));


        controller = new Controller(world.getRabbit(), world, this);
        frame.addKeyListener(controller);

        tracker = new Tracker((world.getWolf()));
        world.addStepListener(tracker);

        // uncomment to make the view track the bird
        // world.addStepListener(new Tracker(view, world.getPlayer()));

        // uncomment this to make a debugging view
        //debugView = new DebugViewer(world, 500, 500);

        // start!
        world.start();
    }

    public void pause() {
        world.stop();
    }

    public void restart() {
        world.start();
    }

    /**
     * The player in the current level.
     */
    public Rabbit getPlayer() {
        return world.getRabbit();
    }

    /**
     * Is the current level of the game finished?
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    public void goToLevel(GameLevel lev){
        world.stop();
        Rabbit oldRabbit = world.getRabbit();
        level = lev.getLevelNumber();

        //get a new world
        world = lev;

        //switch the controls to the new player
        controller.setBody(world.getRabbit());

        view.setCurrentLevel(world);

        //show the new world
        view.setWorld(world);

        world.start();
    }
    /**
     * Advance to the next level of the game.
     */
    public void goNextLevel() {
        world.stop();
        Wolf oldWolf = world.getWolf();
        Rabbit oldRabbit = world.getRabbit();
        //Carrot oldCarrot = world.getCarrot();
        if (level == 3) {
            System.out.println("You win!");
            JDialog diaScore = new JDialog(frame, true);
            HighScore highScore = new HighScore(this);
            diaScore.getContentPane().add(highScore.getPnlScores());
            diaScore.pack();
            diaScore.setVisible(true);
        } else if (level == 1) {
            level++;
            // get a new world
            world = new Level2();
            view.setCurrentLevel(world);
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getRabbit());
            controller.setWorld(world);

            tracker.setWolf(world.getWolf());
            world.addStepListener(tracker);

            // get the score and lives transferred to the new level
            world.getRabbit().setCabbageCount(oldRabbit.getCabbageCount());
            world.getRabbit().setLiveCount(oldRabbit.getLiveCount());
            // change the position of the pickup item
            world.getCarrot().setPosition(new Vec2(6, -1));
            // show the new world in the view
            view.setWorld(world);
            world.start();

            //debugView.dispose();
            //debugView = new DebugViewer(world, 500, 500);
        } else if (level == 2) {
            level++;
            // get a new world
            world = new Level3();
            view.setCurrentLevel(world);
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getRabbit());
            controller.setWorld(world);

            tracker.setWolf(world.getWolf());
            world.addStepListener(tracker);

            // get the score and lives transferred to the new level
            world.getRabbit().setCabbageCount(oldRabbit.getCabbageCount());
            world.getRabbit().setLiveCount(oldRabbit.getLiveCount());
            // show the new world in the view
            view.setWorld(world);
            world.start();

            //debugView.dispose();
            //debugView = new DebugViewer(world, 500, 500);
            }
        }



    /**
     * Run the game.
     */
    public static void main(String[] args) {
        new Game();
    }
}
