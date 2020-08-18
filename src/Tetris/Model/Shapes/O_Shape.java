package Tetris.Model.Shapes;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-August-04
 */

public class O_Shape extends Shape{
    int[][] rot0123;

    public O_Shape() {
        super("y");

        rot0123 = new int[][]{
                {0,0,1,1},
                {0,1,0,1}
        };
    }

    @Override
    public int[][] getPrintShape(int rotation) {
        setHeight(2);
        setWidth(2);
        return rot0123;
    }
}
