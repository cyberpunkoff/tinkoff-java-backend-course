package edu.hw6.task3.filters;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Arrays;

public abstract class MagicNumberFilter implements AbstractFilter {
    public static MagicNumberFilter magicNumber(byte... magicNumber) {
        return new MagicNumberFilter() {
            @Override
            public boolean accept(Path path) {
                byte[] buffer = new byte[4];
                try (InputStream is = new FileInputStream(path.toString())) {
                    if (is.read(buffer) != buffer.length) {
                        return false;
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                return Arrays.equals(magicNumber, buffer);
            }
        };
    }
}
