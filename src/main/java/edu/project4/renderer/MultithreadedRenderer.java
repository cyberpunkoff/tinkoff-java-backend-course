package edu.project4.renderer;

import edu.project4.FractalImage;
import edu.project4.Rect;
import edu.project4.transformation.ColorTransformation;
import edu.project4.transformation.Transformation;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadedRenderer implements Renderer {
    private final int threadCount;

    public MultithreadedRenderer(int threadCount) {
        this.threadCount = threadCount;
    }

    @Override
    public FractalImage render(
        FractalImage canvas,
        Rect world,
        List<Transformation> variations,
        List<ColorTransformation> affine,
        int samples,
        short iterPerSample,
        long seed
    ) {

        ExecutorService threadPool = Executors.newFixedThreadPool(threadCount);
        threadPool.submit(() -> new SingleThreadRenderer().render(
            canvas,
            world,
            variations,
            affine,
            samples / threadCount,
            iterPerSample,
            seed
        ));

        threadPool.shutdown();

        return canvas;

    }
}
