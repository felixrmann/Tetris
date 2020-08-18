package Tetris.Handler;

import Tetris.View.GameFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-August-05
 */

public class InputHandler extends Observable {

    public InputHandler(GameFrame gameFrame){

        gameFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                switch (e.getKeyChar()){
                    case 'a':
                        setChanged();
                        notifyObservers("key" + 'a');
                        break;
                    case 's':
                        setChanged();
                        notifyObservers("key" + 's');
                        break;
                    case 'd':
                        setChanged();
                        notifyObservers("key" + 'd');
                        break;
                    case 'e':
                        setChanged();
                        notifyObservers("key" + 'e');
                        break;
                    case 'q':
                        setChanged();
                        notifyObservers("key" + 'q');
                        break;
                }
            }
        });
    }
}
