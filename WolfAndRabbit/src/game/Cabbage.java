package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;

/**
 *
 * @author greg
 */


/**
 * A cabbage.
 */
public class Cabbage extends DynamicBody {
    private static final Shape shape = new CircleShape(0.2f);
    
    public Cabbage(World world) {
        super(world, shape);
        setFillColor(Color.green);
    }
}
