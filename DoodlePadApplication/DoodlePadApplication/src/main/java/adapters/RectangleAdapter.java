package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Rectangle;

public class RectangleAdapter implements IShape
{
    private Rectangle rectangle;
    private Rectangle tanglesWreck;
    private boolean rectangleFilled;

    public RectangleAdapter(Rectangle rectangle) { this.rectangle = rectangle; }

    @Override
    public IShape setThickness(double value)
    {
        rectangle.setThickness(value);
        return this;
    }

    @Override
    public IShape setColor(Color value)
    {
        tanglesWreck = new Rectangle(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight(), rectangle.getThickness(), value);
        return this;
    }

    @Override
    public IShape setFilled(boolean value)
    {
        tanglesWreck = new Rectangle(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight(), rectangle.getThickness(), rectangle.getColor());
        rectangle = tanglesWreck;
        rectangleFilled = value;
        return this;
    }

    @Override
    public double getXCoordinate() { return rectangle.getX(); }

    @Override
    public double getYCoordinate() { return rectangle.getY(); }

    @Override
    public double getThickness() { return rectangle.getThickness(); }

    @Override
    public Color getColor() { return rectangle.getColor(); }

    @Override
    public boolean getFilled() { return this.rectangleFilled; }

    @Override
    public void drawShape(GraphicsContext graphics) {
        graphics.setStroke(Color.YELLOW);
        graphics.setLineWidth(this.getThickness());

//        if (this.getFilled())
//            {
        graphics.setFill(Color.YELLOW);
        graphics.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        //}
    }
}
