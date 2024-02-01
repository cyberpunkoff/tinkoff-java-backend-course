package edu.project4;

import java.util.HashMap;
import java.util.Map;

public class GammaCorrection implements ImageProcessor {
    public static final double GAMMA = 1.9;

    @Override
    public void process(FractalImage image) {
        double max = 0.0;

        Map<Point, Double> correction = new HashMap<>();

        for (int i = 0; i < image.width(); i++) {
            for (int j = 0; j < image.height(); j++) {
                if (image.contains(i, j)) {
                    Pixel pixel = image.pixel(i, j);
                    double normal = Math.log10(pixel.hitCount());
                    max = Math.max(max, normal);
                    correction.put(new Point(i, j), normal);
                }
            }
        }

        for (var entry : correction.entrySet()) {
            Point point = entry.getKey();
            double normal = entry.getValue();
            normal /= max;

            Pixel pixel = image.pixel((int) point.x(), (int) point.y());

            int newR = (int) (pixel.r() * Math.pow(normal, 1.0 / GAMMA));
            int newG = (int) (pixel.g() * Math.pow(normal, 1.0 / GAMMA));
            int newB = (int) (pixel.b() * Math.pow(normal, 1.0 / GAMMA));

            image.setPixel((int) point.x(), (int) point.y(), new Pixel(newR, newG, newB, pixel.hitCount()));
        }
    }
}
