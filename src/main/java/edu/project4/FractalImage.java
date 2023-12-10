package edu.project4;

public record FractalImage(Pixel[][] data, int width, int height) {
    public static FractalImage create(int width, int height) {
        return new FractalImage(new Pixel[height][width], width, height);
    }

    public boolean contains(int x, int y) {
        return data[y][x] != null;
    }

    public Pixel pixel(int x, int y) {
        return data[y][x];
    }

    public void setPixel(int x, int y, Pixel pixel) {
        data[y][x] = pixel;
    }
}
