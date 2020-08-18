package Tetris.Handler;

import Tetris.Model.Map.GameMap;
import Tetris.Model.Shapes.Shape;

import java.util.Observable;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-August-04
 */

public class ShapeHandler extends Observable {
    private GameMap gameMap;
    private ImpactHandler impactHandler;

    public ShapeHandler(GameMap gameMap, ImpactHandler impactHandler) {
        this.gameMap = gameMap;
        this.impactHandler = impactHandler;
    }

    public void allShapeHandler(Shape shape) {
        printShapeOnMap(shape);
    }

    public void printShapeOnMap(Shape shape) {
        printShape(shape);

        if ((shape.getyPos() >= (20 - shape.getHeight())) || impactHandler.clearUnderBlock(shape)) {
            setChanged();
            notifyObservers("new");
        } else {
            shape.fall();
        }
    }

    public void printShape(Shape shape){
        gameMap.coppySetMap();
        int[][] info = shape.getPrintShape(shape.getRotation());
        for (int i = 0; i < 4; i++) {
            gameMap.setField(shape.getyPos() + info[0][i], shape.getxPos() + info[1][i], shape.getShapeColor());
        }
    }
}
