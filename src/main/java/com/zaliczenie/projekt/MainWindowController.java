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
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable{


    ObservableList<String> obsList;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageCopiesList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        imageCopiesList.itemsProperty().bind(listProperty);
        obsList = FXCollections.observableArrayList(listOfDuplicates);
        listProperty.set(obsList);
    }

    @FXML
    private Button chooseImageFile;
    @FXML
    private Button chooseImageFolder;
    @FXML
    private Button searchImagesCopies;


    @FXML
    private TextField imagePathField;
    @FXML
    private TextField imageFolderPathField;


    @FXML
    private ListView<String> imageCopiesList;


    @FXML
    private MenuItem removeFileOption;

    @FXML
    public void chooseImageFileOnClick(ActionEvent actionEvent) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("View Pictures");
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All Images", "*.*"),
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("GIF", "*.gif"),
                    new FileChooser.ExtensionFilter("BMP", "*.bmp"),
                    new FileChooser.ExtensionFilter("PNG", "*.png")
            );
            File in = fileChooser.showOpenDialog(new Stage());
            imagePathField.setText(in.getAbsolutePath());
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    public void chooseImageFolderOnClick(ActionEvent actionEvent) {
        try {
            final DirectoryChooser dc = new DirectoryChooser();
            dc.setTitle("View Pictures");
            final File wdir = dc.showDialog(null);
            if (wdir != null) {
                imageFolderPathField.setText(wdir.getAbsolutePath());
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }


    protected List<String> listOfDuplicates = new ArrayList<>();
    protected ListProperty<String> listProperty = new SimpleListProperty<>();
    @FXML
    public void searchImagesCopiesOnClick(ActionEvent actionEvent) {
        try {
            File pattern = new File(imagePathField.getText());
            File dir = new File(imageFolderPathField.getText());
            File[] listFile = dir.listFiles();
            listOfDuplicates.clear();
            listProperty.clear();

            if(listFile != null)
            {
                for(File f : listFile){
                    listProperty.add(f.getAbsolutePath());
                }
            }
            //listProperty.set(FXCollections.observableArrayList(listOfDuplicates));
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    public void removeFileOptionOnClick(ActionEvent actionEvent) {
        ObservableList<Integer> ll = imageCopiesList.getSelectionModel().getSelectedIndices();
        for(Integer i: ll)
        {
            System.out.println(i);
        }
        String selected_path = imageCopiesList.getSelectionModel().getSelectedItem();
    }
}
