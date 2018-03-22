package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Circle;

public class CircleAdapter implements IShape
{
    private Circle round;
    private boolean circleFilled;
    private Circle sphere;

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
        sphere = new Circle(round.getRadius(), round.getX(), round.getY(), round.getThickness(), value);
        round = sphere;
        return this;
    }

    @Override
    public IShape setFilled(boolean value)
    {
        sphere = new Circle(round.getRadius(), round.getX(), round.getY(), round.getThickness(), round.getColor());
        round = sphere;
        circleFilled = value;
        return this;
    }

    public double getRadius() { return round.getRadius(); }

    @Override
    public double getXCoordinate() { return round.getX(); }

    @Override
    public double getYCoordinate() { return round.getY(); }

    @Override
    public double getThickness() { return round.getThickness(); }

    @Override
    public Color getColor() { return round.getColor(); }

    @Override
    public boolean getFilled() { return this.circleFilled; }

    @Override
    public void drawShape(GraphicsContext graphics) {
        graphics.setStroke(Color.RED);
        graphics.setLineWidth(this.getThickness());

//        if (this.getFilled())
//        {
            graphics.setFill(Color.BLUE);
            graphics.fillOval(this.getXCoordinate(), this.getYCoordinate(), this.getRadius(), this.getRadius());
        //}
    }
}
