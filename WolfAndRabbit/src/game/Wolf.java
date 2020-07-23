package game;
import city.cs.engine.*;

public class Wolf extends Walker {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -0.382f,1.118f, 1.621f,0.361f, -0.059f,-1.082f, -1.628f,-0.931f, -0.731f,0.96f);

    private static final BodyImage image =
            new BodyImage("data/wolf.png", 2.25f);

    public Wolf(World world) {
        super(world, shape);
        addImage(image);
    }
}
