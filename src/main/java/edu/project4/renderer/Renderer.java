package edu.project4.renderer;

import edu.project4.FractalImage;
import edu.project4.Rect;
import edu.project4.transformation.ColorTransformation;
import edu.project4.transformation.Transformation;
import java.util.List;

// может быть несколько имплементаций интерфейса: однопоточный, многопоточный и т.п.
@FunctionalInterface
public interface Renderer {
    FractalImage render(
        FractalImage canvas,
        Rect world,
        List<Transformation> variations,
        List<ColorTransformation> affine,
        int samples,
        short iterPerSample,
        long seed
    );
}
