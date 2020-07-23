package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Pan the view to follow a particular body.
 */
public class Tracker implements StepListener {

    Wolf wolf;
    Tracker(Wolf w){
        wolf=w;
    }


    /** The view */
    //private WorldView view;

    /** The body */
    //private Body body;

    //public Tracker(WorldView iew, Body body) {
        //this.view = view;
        //this.body = body;
   // }


    @Override
    public void preStep(StepEvent e) {
        //System.out.println(wolf.getPosition().y);
        if (wolf.getPosition().x < -4.9)
            wolf.startWalking(2);
        else if (wolf.getPosition().x > 4.9)
        wolf.startWalking(-2);
    }

    @Override
    public void postStep(StepEvent e) {
        //view.setCentre(new Vec2(body.getPosition()));
    }

    public void setWolf (Wolf w){ wolf = w; }
    }


