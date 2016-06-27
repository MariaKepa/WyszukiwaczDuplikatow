package com.zaliczenie.projekt;a

import java.io.File;


public class MockImageDuplicateChecker implements IDuplicateChecker {
    @Override
    public boolean checkIfItemsAreDuplicates(File file1, File file2) {
        return (file1.getName().equals(file2.getName()));
    }
}
