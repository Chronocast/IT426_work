package launchers;

import drawing.IShape;

public class Adam
{
    public void printShape(IShape shape)
    {
        String shapeToString =
                "Color: R-" + shape.getColor().getRed() +
                      " G-" + shape.getColor().getGreen() +
                      " B-" + shape.getColor().getBlue() +
                //"\nRadius: " + shape.get +
                "\nX-Coord: " + shape.getXCoordinate() +
                "\nY-Coord: " + shape.getYCoordinate() +
                "\nThikness: " + shape.getThickness() +
                "\nFilled: " + shape.getFilled();
        System.out.println(shapeToString);
    }
}
