package Tetris.View;

import Tetris.Handler.FieldPrinter;
import Tetris.Handler.GameHandler;
import Tetris.Handler.InputHandler;
import Tetris.Model.Map.GameMap;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-August-03
 */

public class GameFrame extends JFrame {
    private GameMap map;
    private GameHandler gameHandler;
    private InputHandler inputHandler;
    private JPanel mainPanel, gamePanel;
    private Timer timer;
    private int globalSpeed;


    public GameFrame(){
        //TODO de satvik wot music

        map = new GameMap();
        gameHandler = new GameHandler(this);
        inputHandler = new InputHandler(this);
        inputHandler.addObserver(gameHandler);
        mainPanel = new JPanel();
        gamePanel = new JPanel();

        globalSpeed = 500;

        init();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tetris");
        setResizable(false);
        setSize(600, 850);
        setLocationRelativeTo(null);
        setVisible(true);

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                gameHandler.gameRepeat();
            }
        }, 1000, globalSpeed);
    }

    private void init() {
        //TODO show points
        //TODO show next shape
        //TODO make it look better
        getContentPane().add(mainPanel);

        mainPanel.setLayout(new BorderLayout(10,10));
        mainPanel.add(gamePanel, BorderLayout.CENTER);

        gamePanel.setLayout(new BorderLayout());
        gamePanel.add(new FieldPrinter(map));
    }

    public JPanel getGamePanel() {
        return gamePanel;
    }

    public GameMap getMap() {
        return map;
    }

    public void pauseTimer(){

    }

    public void setGlobalSpeed(int globalSpeed){
        this.globalSpeed = globalSpeed;
    }
}
