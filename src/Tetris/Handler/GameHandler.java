package Tetris.Handler;

import Tetris.Model.Map.GameMap;
import Tetris.Model.Shapes.*;
import Tetris.View.GameFrame;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-August-04
 */

public class GameHandler implements Observer {
    private GameFrame gameFrame;
    private GameMap gameMap;
    private Shape currentShape, nextShape;
    private ShapeHandler shapeHandler;
    private ShapeOutHandler shapeOutHandler;
    private ImpactHandler impactHandler;
    private RowHandler rowHandler;
    private boolean takeInput;
    private int points;

    public GameHandler(GameFrame gameFrame){
        this.gameFrame = gameFrame;

        gameMap = gameFrame.getMap();

        impactHandler = new ImpactHandler(gameFrame.getMap());

        shapeHandler = new ShapeHandler(gameFrame.getMap(), impactHandler);
        shapeHandler.addObserver(this);

        shapeOutHandler = new ShapeOutHandler();

        rowHandler = new RowHandler(gameFrame.getMap(), this);

        currentShape = new L_Shape();
        nextShape = shapeOutHandler.getRandomShape();

        shapeHandler.printShape(currentShape);

        takeInput = true;
        points = 0;
    }

    public void gameRepeat(){
        shapeHandler.allShapeHandler(currentShape);

        renderMap();
    }

    public void renderMap(){
        gameFrame.getGamePanel().removeAll();
        gameFrame.getGamePanel().add(new FieldPrinter(gameFrame.getMap()));
        gameFrame.getGamePanel().revalidate();
    }

    public Shape getCurrentShape() {
        return currentShape;
    }

    public Shape getNextShape() {
        return nextShape;
    }

    public void updateShape(){
        currentShape = nextShape;
        nextShape = shapeOutHandler.getRandomShape();
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    @Override
    public void update(Observable o, Object arg) {
        String input = (String)arg;

        switch (input.substring(0,3)){
            case "new":
                updateShape();
                gameFrame.getMap().updateSetMap();
                renderMap();

                takeInput = true;

                rowHandler.checkFullRow();
                break;
            case "key":
                switch (input.substring(3,4)){
                    case "s":
                        if (takeInput){
                            takeInput = false;
                            //TODO change speed of timer
                        }
                        break;
                    case "a":
                        if (takeInput){
                            if (!((currentShape.getxPos() - 1) < 0)){
                                Shape temp = shapeOutHandler.getShape(currentShape.getShapeColor());
                                temp.setRotation(currentShape.getRotation());
                                temp.aDirection();
                                int[][] testArray = temp.getPrintShape(temp.getRotation());
                                boolean check = true;

                                for (int i = 0; i < 4; i++) {
                                    if (!(gameMap.getField(currentShape.getyPos() + testArray[0][i], temp.getxPos() + testArray[1][i]).equals(" "))){
                                        check = false;
                                        break;
                                    }
                                }
                                if (check){
                                    currentShape.aDirection();
                                    shapeHandler.printShape(currentShape);
                                    renderMap();
                                }
                            }
                        }
                        break;
                    case "d":
                        if (takeInput){
                            if (!(currentShape.getxPos() + 1 > (10 - currentShape.getWidth()))){
                                Shape temp = shapeOutHandler.getShape(currentShape.getShapeColor());
                                temp.setRotation(currentShape.getRotation());
                                temp.dDirection();
                                int[][] testArray = temp.getPrintShape(temp.getRotation());
                                boolean check = true;

                                for (int i = 0; i < 4; i++) {
                                    if (!(gameMap.getField(currentShape.getyPos() + testArray[0][i], temp.getxPos() + testArray[1][i]).equals(" "))){
                                        check = false;
                                        break;
                                    }
                                }
                                if (check){
                                    currentShape.dDirection();
                                    shapeHandler.printShape(currentShape);
                                    renderMap();
                                }
                            }
                        }
                        break;
                    case "e":
                        if (takeInput){
                            boolean check = true;
                            Shape temp1 = shapeOutHandler.getShape(currentShape.getShapeColor());
                            temp1.setRotation(currentShape.getRotation());
                            temp1.turnRight();
                            temp1.getPrintShape(temp1.getRotation());
                            int[][] testArray = temp1.getPrintShape(temp1.getRotation());


                            for (int i = 0; i < 4; i++) {
                                if (!(gameMap.getField(currentShape.getyPos() + testArray[0][i], temp1.getxPos() + testArray[1][i]).equals(" "))) {
                                    check = false;
                                    break;
                                }
                            }
                            if (!(currentShape.getxPos() + temp1.getWidth() > 10) && check){
                                currentShape.turnRight();
                                shapeHandler.printShape(currentShape);
                                renderMap();
                            }
                        }
                        break;
                    case "q":
                        if (takeInput){
                            Shape temp2 = shapeOutHandler.getShape(currentShape.getShapeColor());
                            temp2.setRotation(currentShape.getRotation());
                            temp2.turnRight();
                            temp2.getPrintShape(temp2.getRotation());

                            if (!(currentShape.getxPos() + temp2.getWidth() > 10)){
                                currentShape.turnLeft();
                                shapeHandler.printShape(currentShape);
                                renderMap();
                            }
                        }
                        break;
                }
        }
    }
}
