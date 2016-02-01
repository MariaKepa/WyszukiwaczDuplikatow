package com.zaliczenie.projekt;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class DuplicatesModel {

    public DuplicatesModel()
    {
        getListProperty().set(FXCollections.observableArrayList(new ArrayList<>()));
    }

    private ListProperty<String> listProperty = new SimpleListProperty<>();


    void deleteFile(Path path){
        try {
            Files.delete(path);
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", path);
        } catch (IOException x) {
            // File permission problems are caught here.
            System.err.println(x);
        }
    }

    public ListProperty<String> getListProperty() {
        return listProperty;
    }

    public void updateDuplicateList(List<File> listFile) {
        listProperty.clear();
        if(listFile != null)
        {
            listProperty.addAll(listFile.stream().map(File::getAbsolutePath).collect(Collectors.toList()));
        }
    }

    public void deleteDuplicates(List<Integer> selectedIndices) {
        Collections.reverse(selectedIndices);
        for (int i: selectedIndices) {
            File f = new File(listProperty.get(i));
            deleteFile(f.toPath());
            listProperty.remove(i);
        }
    }
}
