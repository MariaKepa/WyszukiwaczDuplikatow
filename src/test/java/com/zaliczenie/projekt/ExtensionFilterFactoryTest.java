package com.zaliczenie.projekt;a

import javafx.stage.FileChooser;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class ExtensionFilterFactoryTest {

    @Test
    public void testGetFiltersForImages_exact_filters() throws Exception {

        List<FileChooser.ExtensionFilter> resultExpected =  Arrays.asList(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("GIF", "*.gif"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp"),
                new FileChooser.ExtensionFilter("PNG", "*.png"));

        List<FileChooser.ExtensionFilter> result = ExtensionFilterFactory.GetFiltersForImages();
        for(int i = 0; i < result.size(); ++i)
        {
            assertArrayEquals(resultExpected.get(i).getExtensions().toArray(), result.get(i).getExtensions().toArray());
        }
    }

    @Test
    public void testGetFiltersForImages_check_nr_of_filters() throws Exception {
        List<FileChooser.ExtensionFilter> result = ExtensionFilterFactory.GetFiltersForImages();
        assertEquals(result.size(), 4);
    }
}
