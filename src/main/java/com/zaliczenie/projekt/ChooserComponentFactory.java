package com.zaliczenie.projekt;a

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public class ChooserComponentFactory {
    // Fabryka wzorzec
    static public FileChooser CreateFileChooser(String title, List<FileChooser.ExtensionFilter> filters)
    {
        return CreateFileChooser(title, null, filters);
    }


    static public FileChooser CreateFileChooser(String title, String initialDirectory, List<FileChooser.ExtensionFilter> filters)
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(title);
        if(initialDirectory != null)
            fileChooser.setInitialDirectory(new File(initialDirectory));

        fileChooser.getExtensionFilters().addAll(filters);
        return fileChooser;
    }

    // Fabryka wzorzec
    static public DirectoryChooser CreateDirectoryChooser(String title)
    {
        return CreateDirectoryChooser(title, null);
    }

    static public DirectoryChooser CreateDirectoryChooser(String title, String initialDirectory)
    {
        final DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle(title);
        if(initialDirectory != null)
            dc.setInitialDirectory(new File(initialDirectory));
        return dc;
    }
}
