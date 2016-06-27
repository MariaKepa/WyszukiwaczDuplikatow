package com.zaliczenie.projekt;

import javafx.stage.FileChooser;

import java.util.Arrays;
import java.util.List;

public class ExtensionFilterFactory {
    static public List<FileChooser.ExtensionFilter> GetFiltersForImages()
    {
        return Arrays.asList(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("GIF", "*.gif"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp"),
                new FileChooser.ExtensionFilter("PNG", "*.png"));
    }
}
