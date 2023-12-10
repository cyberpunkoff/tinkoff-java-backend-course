package edu.project4.transformation;

import edu.project4.Pixel;
import java.util.concurrent.ThreadLocalRandom;

public abstract class ColorTransformation implements Transformation {
    private final static int MAX_COLOR_VALUE = 255;
    public int r;
    public int g;
    public int b;

    ColorTransformation() {
        r = ThreadLocalRandom.current().nextInt(MAX_COLOR_VALUE);
        g = ThreadLocalRandom.current().nextInt(MAX_COLOR_VALUE);
        b = ThreadLocalRandom.current().nextInt(MAX_COLOR_VALUE);
    }

    public Pixel applyColor(Pixel pixel) {
        return new Pixel((pixel.r() + r) / 2, (pixel.g() + g) / 2, (pixel.b() + b) / 2, pixel.hitCount() + 1);
    }
}
