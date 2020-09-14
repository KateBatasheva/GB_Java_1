package Lesson8;

import javax.swing.*;
import java.awt.*;

public class Step extends JFrame {
    private GameWindow gameWindow;
    static final int WINDOW_X = GameWindow.WINDOW_X + 50;
    static final int WINDOW_Y = GameWindow.WINDOW_Y + 50;
    static final int WINDOW_WIDTH = 300;
    static final int WINDOW_HEIGHT = 200;

    public Step (GameWindow gameWindow, String player){
        this.gameWindow = gameWindow;
        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Переход хода");
        JButton OK = new JButton("OK");
        add(new JLabel(player));
        add(OK, BorderLayout.SOUTH);

        OK.addActionListener(e -> {
                    setVisible(false);
    });
    }
}
