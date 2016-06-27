package com.zaliczenie.projekt;a


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ImageDuplicateFinder extends DuplicateFinder {

    ImageDuplicateFinder(IDuplicateChecker checker) {
        super(checker);
    }

    // Strategia, wzorzec
    public void SetDuplicateChecker(IDuplicateChecker newChecker)
    {
        this.checker = newChecker;
    }

    List<File> GetAllFiles(File folder)
    {
        List<File> allFiles = new ArrayList<>();
        File[] fileList = folder.listFiles();
        if(fileList != null)
        {
            for(File f : fileList)
            {
                if(f.isDirectory())
                    allFiles.addAll(GetAllFiles(f));
                else
                    allFiles.add(f);
            }
        }
        return allFiles;
    }

    @Override
    public List<File> findDuplicates(File pattern, File folder) {
        List<File> duplicateList = GetAllFiles(folder).stream().filter(f -> checker.checkIfItemsAreDuplicates(pattern, f)).collect(Collectors.toList());

        return duplicateList;
    }
}
