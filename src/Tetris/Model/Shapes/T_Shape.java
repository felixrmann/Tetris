package Tetris.Model.Shapes;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-August-04
 */

public class T_Shape extends Shape{
    int[][] rot0, rot1, rot2, rot3;

    public T_Shape() {
        super("v");

        rot0 = new int[][]{
                {0,1,1,1},
                {1,0,1,2}
        };

        rot1 = new int[][]{
                {0,1,1,2},
                {0,0,1,0}
        };

        rot2 = new int[][]{
                {0,0,0,1},
                {0,1,2,1}
        };

        rot3 = new int[][]{
                {0,1,1,2},
                {1,0,1,1}
        };
    }

    @Override
    public int[][] getPrintShape(int rotation) {
        switch (rotation){
            case 0:
                setHeight(2);
                setWidth(3);
                return rot0;
            case 1:
                setHeight(3);
                setWidth(2);
                return rot1;
            case 2:
                setHeight(2);
                setWidth(3);
                return rot2;
            case 3:
                setHeight(3);
                setWidth(2);
                return rot3;
            default:
                return null;
        }
    }
}
