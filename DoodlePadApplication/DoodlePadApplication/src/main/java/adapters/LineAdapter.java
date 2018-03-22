package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Line;

public class LineAdapter implements IShape
{
    private Line line;
    private Line lineman;
    private boolean lineFilled;

    public LineAdapter(Line line) { this.line = line; }

    @Override
    public IShape setThickness(double value)
    {
        line.setThickness(value);
        return this;
    }

    @Override
    public IShape setColor(Color value)
    {
        lineman = new Line(line.getX(), line.getY(), line.getX2(), line.getY2(), line.getThickness(), value);
        return this;
    }

    @Override
    public IShape setFilled(boolean value)
    {
        lineman = new Line(line.getX(), line.getY(), line.getX2(), line.getY2(), line.getThickness(), line.getColor());
        line = lineman;
        lineFilled = value;
        return this;
    }

    @Override
    public double getXCoordinate() { return line.getX(); }

    @Override
    public double getYCoordinate() { return line.getY(); }

    @Override
    public double getThickness() { return line.getThickness(); }

    @Override
    public Color getColor() { return line.getColor(); }

    @Override
    public boolean getFilled() { return this.lineFilled; }

    @Override
    public void drawShape(GraphicsContext graphics) {
        graphics.setStroke(Color.GREEN);
        graphics.setLineWidth(this.getThickness());

//        if (this.getFilled())
//            {
        graphics.setFill(Color.GREEN);
        graphics.strokeLine(line.getX(), line.getY(), line.getX2(), line.getY2());
        //}
    }
}
