package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Triangle;

public class TriangleAdapter implements IShape
{
    private Triangle triangle;
    private Triangle tryAngle;
    private boolean triangleFilled;

    public TriangleAdapter(Triangle triangle) { this.triangle = triangle; }

    @Override
    public IShape setThickness(double value) {
        triangle.setThickness(value);
        return this;
    }

    @Override
    public IShape setColor(Color value) {
        tryAngle = new Triangle(triangle.getX(), triangle.getY(), triangle.getWidth(), triangle.getHeight(), triangle.getThickness(), value);
        triangle = tryAngle;
        return this;
    }

    @Override
    public IShape setFilled(boolean value) {
        tryAngle = new Triangle(triangle.getX(), triangle.getY(), triangle.getWidth(), triangle.getHeight(), triangle.getThickness(), triangle.getColor());
        triangle = tryAngle;
        triangleFilled = value;
        return this;
    }

    @Override
    public double getXCoordinate() { return triangle.getX(); }

    @Override
    public double getYCoordinate() { return triangle.getY(); }

    @Override
    public double getThickness() { return triangle.getThickness(); }

    @Override
    public Color getColor() { return triangle.getColor(); }

    @Override
    public boolean getFilled() { return this.triangleFilled; }

    @Override
    public void drawShape(GraphicsContext graphics) {
        graphics.setStroke(Color.RED);
        graphics.setLineWidth(this.getThickness());

//        if (this.getFilled())
//            {
                graphics.setFill(Color.RED);
                graphics.fillPolygon(new double[] {0, triangle.getWidth()/2, triangle.getWidth()},
                                     new double[] {triangle.getHeight(), 0, triangle.getHeight()},3);
            //}
    }
}
