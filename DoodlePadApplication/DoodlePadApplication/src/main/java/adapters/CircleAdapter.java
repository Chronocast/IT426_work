package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Circle;

public class CircleAdapter implements IShape
{
    private Circle round;

    public CircleAdapter(Circle circle) { this.round = circle; }

    @Override
    public IShape setThickness(double value) {
        return null;
    }

    @Override
    public IShape setColor(Color value) {
        return null;
    }

    @Override
    public IShape setFilled(boolean value) {
        return null;
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
