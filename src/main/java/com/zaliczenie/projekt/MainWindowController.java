package com.zaliczenie.projekt;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class MainWindowController implements Initializable{
//    @FXML
//    private Button chooseImageFile;
//    @FXML
//    private Button chooseImageFolder;
//    @FXML
//    private Button searchImagesCopies;
//    @FXML
//    private MenuItem removeFileOption;

    @FXML
    private TextField imagePathField;
    @FXML
    private TextField imageFolderPathField;

    @FXML
    private ListView<String> imageCopiesList;

    private ListProperty<String> listProperty = new SimpleListProperty<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listProperty.set(FXCollections.observableArrayList( new ArrayList<>()));

        imageCopiesList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        imageCopiesList.itemsProperty().bind(listProperty);
    }


    @FXML
    public void chooseImageFileOnClick(ActionEvent actionEvent) {
        try {
            final FileChooser chooser = ChooserComponentFactory.CreateFileChooser("Choose your directory", ExtensionFilterFactory.GetFiltersForImages());
            final File imageFile = chooser.showOpenDialog(null);
            if(imageFile != null)
                imagePathField.setText(imageFile.getAbsolutePath());
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    public void chooseImageFolderOnClick(ActionEvent actionEvent) {
        try {
            final DirectoryChooser chooser = ChooserComponentFactory.CreateDirectoryChooser("Choose your directory");
            final File imageFolder = chooser.showDialog(null);
            if (imageFolder != null)
                imageFolderPathField.setText(imageFolder.getAbsolutePath());
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    public void searchImagesCopiesOnClick(ActionEvent actionEvent) {
        try {
            final File patternFile = new File(imagePathField.getText());
            final File imageDirectory = new File(imageFolderPathField.getText());

            ImageDuplicateFinder finder = new ImageDuplicateFinder(new ImageDuplicateChecker());
            List<File> listFile = finder.findDuplicates(patternFile, imageDirectory);

            listProperty.clear();
            if(listFile != null)
            {
                listProperty.addAll(listFile.stream().map(File::getAbsolutePath).collect(Collectors.toList()));
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    public void removeFileOptionOnClick(ActionEvent actionEvent) {
        List<Integer> ll = imageCopiesList.getSelectionModel().getSelectedIndices();
        ll.forEach(System.out::println);
        String selected_path = imageCopiesList.getSelectionModel().getSelectedItem();
    }
}
