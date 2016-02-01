package com.zaliczenie.projekt;

import javafx.application.Platform;
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
import java.io.IOException;
import java.net.URL;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
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

    DuplicatesModel model = new DuplicatesModel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageCopiesList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        imageCopiesList.itemsProperty().bind(model.getListProperty());
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

            model.updateDuplicateList(listFile);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    public void removeFileOptionOnClick(ActionEvent actionEvent) {
        model.deleteDuplicates(imageCopiesList.getSelectionModel().getSelectedIndices());
    }

    @FXML
    public void closeApplication(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    public void showAboutInfo(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("O programie");
        alert.setHeaderText(null);
        alert.setContentText("To jest proggram będący projektem zaliczeniowym.\nAutor: Maria Kępa");

        alert.showAndWait();
    }
}
