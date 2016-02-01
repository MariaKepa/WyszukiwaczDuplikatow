package com.zaliczenie.projekt;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

import java.io.File;

public class ImageDuplicateChecker implements IDuplicateChecker {

    @Override
    public boolean checkIfItemsAreDuplicates(File file1, File file2) {
        if(file1.getTotalSpace() == file2.getTotalSpace())
        {
            Image im1 = new Image(file1.toURI().toString());
            Image im2 = new Image(file2.toURI().toString());
            if((im1.getHeight() == im2.getHeight()) && (im1.getWidth() == im2.getWidth()))
            {
                final PixelReader pixelReaderForIm1 = im1.getPixelReader();
                final PixelReader pixelReaderForIm2 = im2.getPixelReader();
                for(int x = 0; x < im1.getWidth(); ++x)
                {
                    for(int y = 0; y < im1.getHeight(); ++y)
                    {
                        if(!pixelReaderForIm1.getColor(x, y).equals(pixelReaderForIm2.getColor(x, y)))
                        {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}
