package library.main.librarymanagementsystem;

import javafx.fxml.FXML;
import library.main.librarymanagementsystem.application.LibraryController;

import java.io.IOException;

public class StartController {

    @FXML
    protected void onStartButtonClick() throws IOException {
        LibraryController.changeScene();
    }
}