package edu.project4;

import edu.project4.renderer.MultithreadedRenderer;
import edu.project4.renderer.Renderer;
import edu.project4.transformation.ColorTransformation;
import edu.project4.transformation.LinearTransformation;
import edu.project4.transformation.SphericalTransformation;
import edu.project4.transformation.Transformation;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;

public class FractalImageTest {
    @Test
    void generateImageTest() {
        List<Transformation> transformations = List.of(
            new SphericalTransformation()
//            LinearTransformation.Sp()
//            LinearTransformation.randomTransformation()

//            new SinTransformation()
//             new SinTransformation(
//             )
//            LinearTransformation.randomTransformation()

        );

        List<ColorTransformation> affine = List.of(
//            LinearTransformation.randomTransformation(),
//            LinearTransformation.randomTransformation(),
            LinearTransformation.randomTransformation(),
            LinearTransformation.randomTransformation(),
            LinearTransformation.randomTransformation(),
            LinearTransformation.randomTransformation(),
            LinearTransformation.randomTransformation(),
            LinearTransformation.randomTransformation(),
            LinearTransformation.randomTransformation(),
            LinearTransformation.randomTransformation(),
            LinearTransformation.randomTransformation(),
            LinearTransformation.randomTransformation(),
            LinearTransformation.randomTransformation(),
            LinearTransformation.randomTransformation(),
            LinearTransformation.randomTransformation(),
            LinearTransformation.randomTransformation(),
            LinearTransformation.randomTransformation()
        );

        Renderer renderer = new MultithreadedRenderer(4);
        ImageProcessor gamma = new GammaCorrection();
        FractalImage fractalImage = FractalImage.create(1920, 1080);
        Rect world = new Rect(-1, -1, 2, 2);
        renderer.render(fractalImage, world, transformations, affine, 20000, (short) 1000, 3);


        gamma.process(fractalImage);
        ImageUtils.save(fractalImage, Path.of("kek."), ImageFormat.JPEG);
    }
}
