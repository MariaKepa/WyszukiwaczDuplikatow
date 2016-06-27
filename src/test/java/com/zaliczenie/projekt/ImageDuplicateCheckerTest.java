package com.zaliczenie.projekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;

import java.io.File;
import java.net.URL;

import static org.junit.Assert.*;


public class ImageDuplicateCheckerTest{
    IDuplicateChecker checker = new MockImageDuplicateChecker();
    URL pathToResources = ImageDuplicateCheckerTest.class.getClassLoader().getResource("images/");

    @Test
    public void check_for_the_same_images_check_success() throws Exception {
        File im1 = new File(pathToResources + "Koala.jpg");
        File im2 = new File(pathToResources + "Koala.jpg");
        assertEquals(checker.checkIfItemsAreDuplicates(im1, im2), true);
    }

}
