package edu.project4.transformation;

import edu.project4.Point;

public class SphericalTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double radius = Math.pow(point.x(), 2) + Math.pow(point.y(), 2);

        double x = point.x() / radius;
        double y = point.y() / radius;

        return new Point(x, y);
    }
}
