package edu.project4.renderer;

import edu.project4.FractalImage;
import edu.project4.Pixel;
import edu.project4.Point;
import edu.project4.Rect;
import edu.project4.transformation.ColorTransformation;
import edu.project4.transformation.Transformation;
import java.util.List;
import java.util.Random;

public class SingleThreadRenderer implements Renderer {
    private static final int PRE_ITERATIONS = 20;

    @Override
    public FractalImage render(
        FractalImage canvas,
        Rect world,
        List<Transformation> variations,
        List<ColorTransformation> affine,
        int samples,
        short iterPerSample,
        long symmetry
    ) {
        for (int num = 0; num < samples; ++num) {
            Random random = new Random();
//            Point pw = random(world);

            double newX = random.nextDouble(world.x(), world.x() + world.width());
            double newY = random.nextDouble(world.y(), world.y() + world.height());

            Point point = new Point(newX, newY);

            for (short step = -PRE_ITERATIONS; step < iterPerSample; ++step) {
                Transformation variation = variations.get(random.nextInt(variations.size()));
                ColorTransformation affineTransformation = affine.get(random.nextInt(affine.size()));

//                pw = transform(pw, ...);
                point = affineTransformation.apply(point);
                point = variation.apply(point);

                double theta2 = 0.0;
                for (int s = 0; s < symmetry; theta2 += Math.PI * 2 / symmetry, ++s) {
                    point = rotate(point, theta2);

                    if (world.contains(point) && step >= 0) {
                        int x = map(canvas.width(), world.x(), world.x() + world.width(), point.x());
                        int y = map(canvas.height(), world.y(), world.y() + world.height(), point.y());

                        if (x < canvas.width() && y < canvas.height()) {
                            if (canvas.contains(x, y)) {
                                Pixel oldPixel = canvas.pixel(x, y);

                                Pixel newPixel = affineTransformation.applyColor(oldPixel);
                                canvas.setPixel(x, y, newPixel);
                            } else {
                                canvas.setPixel(x, y, new Pixel(affineTransformation.r, affineTransformation.g,
                                    affineTransformation.b, 1
                                ));
                            }
                        }
                    }
                }

//                double theta2 = 0.0;
//                for (int s = 0; s < symmetry; theta2 += Math.PI * 2 / symmetry, ++s) {
//                    var pwr = rotate(pw, theta2);
//                    if (!world.contains(pwr)) continue;
//
//                    Pixel pixel = map_range(world, pwr, canvas);
//                    if (pixel == null) continue;
//
//
//                    // 1. делаем лок на время работы с пикселем
//                    // 2. подмешиваем цвет и увеличиваем hit count
//                }
            }
        }

        return canvas;
    }

    private int map(int size, double min, double max, double point) {
        return size - (int) Math.ceil(
            (max - point) / (max - min) * size
        );
    }

    private Point rotate(Point pw, double theta) {
        double xNew = pw.x() * Math.cos(theta) - pw.y() * Math.sin(theta);
        double yNew = pw.x() * Math.sin(theta) + pw.y() * Math.cos(theta);
        return new Point(xNew, yNew);
    }
}
