package edu.project4;

public record Rect(double x, double y, double width, double height) {
    public boolean contains(Point p) {
        double pointX = p.x();
        double pointY = p.y();

        return pointX > x && pointX < x + width && pointY > y && pointY <  y + height;
    }
}
