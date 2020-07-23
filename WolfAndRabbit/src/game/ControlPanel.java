package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlPanel{

    private JButton resumeButton;
    private JButton quitButton;
    public JPanel mainPanel;
    private JButton pauseButton;

    private Game game;

    public ControlPanel(Game game) {
        this.game = game;
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("pause");
                game.pause();
            }
        });
        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("restart");
                game.restart();
             }
        });
    }
}




