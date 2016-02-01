package com.zaliczenie.projekt;

import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mk on 2016-02-02.
 */
public class ImageDuplicateFinderTest {
    URL pathToResources = ImageDuplicateCheckerTest.class.getClassLoader().getResource("images/");
    ImageDuplicateFinder duplicateFinder = new ImageDuplicateFinder(new MockImageDuplicateChecker());

    @Test
    public void testGetAllFiles() throws Exception {
        List<File> files = duplicateFinder.GetAllFiles(new File(pathToResources.toURI()));
        assertEquals(13, files.size());
    }

    @Test
    public void testFindDuplicates_for_3_koalas() throws Exception {
        List<File> files = duplicateFinder.findDuplicates(new File(pathToResources.toURI() + "/Koala.jpg"), new File(pathToResources.toURI()));
        assertEquals(3, files.size());
    }

    @Test
    public void testFindDuplicates_for_2_chryzantenium() throws Exception {
        List<File> files = duplicateFinder.findDuplicates(new File(pathToResources.toURI() + "/Chrysanthemum.jpg"), new File(pathToResources.toURI()));
        assertEquals(2, files.size());
    }
}