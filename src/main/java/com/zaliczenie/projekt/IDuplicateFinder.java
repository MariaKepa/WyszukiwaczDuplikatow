package com.zaliczenie.projekt;

import java.io.File;
import java.util.List;

public interface IDuplicateFinder {
    List<File> findDuplicates(File pattern, File folder);
}
