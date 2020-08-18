package Tetris.Model.Shapes;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-August-04
 */

public class Z_Shape extends Shape{
    int[][] rot02, rot13;

    public Z_Shape() {
        super("r");

        rot02 = new int[][]{
                {0,0,1,1},
                {0,1,1,2}
        };

        rot13 = new int[][]{
                {0,1,1,2},
                {1,0,1,0}
        };
    }

    @Override
    public int[][] getPrintShape(int rotation) {
        switch (rotation){
            case 0:
            case 2:
                setHeight(2);
                setWidth(3);
                return rot02;
            case 1:
            case 3:
                setHeight(3);
                setWidth(2);
                return rot13;
            default:
                return null;
        }
    }
}
