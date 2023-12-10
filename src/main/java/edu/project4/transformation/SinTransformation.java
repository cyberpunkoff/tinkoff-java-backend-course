package edu.project4.transformation;

import edu.project4.Point;

public class SinTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = Math.sin(point.x());
        double y = Math.sin(point.y());

        return new Point(x, y);
    }
}
