package Tetris.Model.Shapes;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-August-03
 */

public class Shape {
    protected String shapeColor;
    protected int rotation, yPos, xPos, height, width;

    public Shape(String shapeColor){
        this.shapeColor = shapeColor;
        rotation = 0;
        yPos = 0;
        xPos = 5;
    }

    public int[][] getPrintShape(int rotation){
        return null;
    }

    public void turnRight(){
        if (rotation == 3){
            rotation = 0;
        } else {
            rotation++;
        }
    }

    public void turnLeft(){
        if (rotation == 0){
            rotation = 3;
        } else {
            rotation--;
        }
    }

    public String getShapeColor() {
        return shapeColor;
    }

    public int getRotation(){
        return rotation;
    }

    public void setRotation(int rotation){
        this.rotation = rotation;
    }

    public int getyPos(){
        return yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public void fall(){
        yPos++;
    }

    public void aDirection(){
        xPos--;
    }

    public void dDirection(){
        xPos++;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
