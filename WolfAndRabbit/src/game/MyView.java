package game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;

/**
 * extended view
 */
public class MyView extends UserView {

    Rabbit rabbit;

    GameLevel currentLevel;

    public MyView(World world, Rabbit rabbit, int width, int height) {
        super(world, width, height);
        this.rabbit = rabbit;

    }

    public void setCurrentLevel(GameLevel world){
        currentLevel = world;
    }

    @Override
    protected void paintBackground(Graphics2D g) {

        super.paintBackground(g);

        g.drawImage(currentLevel.getBackgroundImage(), 0, 0, null);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawString("Score:" + ((GameLevel)this.getWorld()).getRabbit().getCabbageCount(), 30, 40);
        g.drawString("Lives:" + ((GameLevel)this.getWorld()).getRabbit().getLiveCount(), 30, 55);
        if((((GameLevel)this.getWorld()).getRabbit().getLiveCount()) == 0){
            g.drawString("Game Over!", getWidth()/2-25, getHeight()/2-25);
            getWorld().stop();
        }
    }
}
