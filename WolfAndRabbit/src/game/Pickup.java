package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the bird to collect things.
 */
public class Pickup implements CollisionListener {
    private Rabbit rabbit;

    public Pickup(Rabbit rabbit) {
        this.rabbit = rabbit;
    }

    @Override
    public void collide(CollisionEvent e) {
        //System.out.println("collision!");
        if (e.getReportingBody() instanceof Cabbage && e.getOtherBody() == rabbit) {
            rabbit.incrementCabbageCount();
            e.getReportingBody().destroy();
        } else{
            if (e.getReportingBody() instanceof Wolf && e.getOtherBody() == rabbit) {
                rabbit.decrementliveCount();
                e.getReportingBody().destroy();
            } else{
                if (e.getReportingBody() instanceof Carrot && e.getOtherBody() == rabbit) {
                    rabbit.incrementliveCount();
                    e.getReportingBody().destroy();
                }

        }

        }

    }
}

