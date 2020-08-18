package Tetris.Model.Shapes;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-August-04
 */

public class I_Shape extends Shape{
    int[][] rot02, rot13;

    public I_Shape() {
        super("hb");

        rot02 = new int[][]{
                {0,1,2,3},
                {0,0,0,0}
        };

        rot13 = new int[][]{
                {0,0,0,0},
                {0,1,2,3}
        };
    }

    @Override
    public int[][] getPrintShape(int rotation) {
        switch (rotation){
            case 0:
            case 2:
                setHeight(4);
                setWidth(1);
                return rot02;
            case 1:
            case 3:
                setHeight(1);
                setWidth(4);
                return rot13;
            default:
                return null;
        }
    }
}
