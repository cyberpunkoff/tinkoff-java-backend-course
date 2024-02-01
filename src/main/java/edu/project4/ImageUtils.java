package edu.project4;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import javax.imageio.ImageIO;

public final class ImageUtils {
    private final static int RED = 16;
    private final static int GREEN = 8;

    private ImageUtils() {
    }

    public static void save(FractalImage image, Path filename, ImageFormat format) {
        BufferedImage result = new BufferedImage(image.width(), image.height(), BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < image.width(); i++) {
            for (int j = 0; j < image.height(); j++) {
                if (image.contains(i, j)) {
                    Pixel pixel = image.pixel(i, j);
                    int rgb = (pixel.r() << RED) | (pixel.g() << GREEN) | pixel.b();
                    result.setRGB(i, j, rgb);
                } else {
                    result.setRGB(i, j, 0);
                }
            }
        }

        try {
            Path fullPath = Path.of(filename.toString() + format.name().toLowerCase());
            File outputFile = fullPath.toFile();
//            Files.createDirectories(fullpath.getParent());
//            File outputfile = addExtensionToPath(filename, format.name().toLowerCase()).toFile();
            ImageIO.write(result, format.name().toLowerCase(), outputFile);
//            LOGGER.info("Изображение сохранено в " + fullpath);
        } catch (IOException e) {
//            LOGGER.error(e.getMessage());
        }
    }
}
