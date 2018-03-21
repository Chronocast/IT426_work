package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Circle;

public class CircleAdapter implements IShape
{
    private Circle round;
    private boolean circleFilled;

    public CircleAdapter(Circle circle) { this.round = circle; }

    @Override
    public IShape setThickness(double value)
    {
        round.setThickness(value);

        return this;
    }

    @Override
    public IShape setColor(Color value)
    {
        Circle sphere = new Circle(round.getRadius(), round.getX(), round.getY(), round.getThickness(), value);

        round = sphere;

        return this;
    }

    @Override
    public IShape setFilled(boolean value)
    {
        Circle sphere = new Circle(round.getRadius(), round.getX(), round.getY(), round.getThickness(), round.getColor());

        round = sphere;

        circleFilled = value;

        return this;
    }

    @Override
    public double getXCoordinate() {
        return round.getX();
    }

    @Override
    public double getYCoordinate() {
        return round.getY();
    }

    @Override
    public double getThickness() {
        return round.getThickness();
    }

    @Override
    public Color getColor() {
        return round.getColor();
    }

    @Override
    public boolean getFilled() {
        return true;
    }

    @Override
    public void drawShape(GraphicsContext graphics) {

    }
}
