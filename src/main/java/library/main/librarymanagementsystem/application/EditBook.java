package library.main.librarymanagementsystem.application;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class EditBook {

    private final String result;

    public String getResult() {
        return this.result;
    }

    public EditBook() {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Редактирование");
        dialog.setHeaderText("Редактировать книгу");

        ButtonType confirm = new ButtonType("Редактировать");
        dialog.getDialogPane().getButtonTypes().add(confirm);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField author = new TextField();
        author.setPromptText("Автор");

        TextField title = new TextField();
        title.setPromptText("Название книги");

        TextField isbn = new TextField();
        isbn.setPromptText("Номер книги");

        TextField category = new TextField();
        category.setPromptText("Категория");

        grid.add(new Label("Автор:"), 0, 0);
        grid.add(author, 1, 0);

        grid.add(new Label("Название книги:"), 0, 1);
        grid.add(title, 1, 1);

        grid.add(new Label("Номер книги:"), 0, 2);
        grid.add(isbn, 1, 2);

        grid.add(new Label("Категория:"), 0, 3);
        grid.add(category, 1, 3);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == confirm) {
                return author.getText() + "; " + title.getText() + "; " + isbn.getText() + "; " + category.getText();
            }
            return null;
        });

        Optional<String> rslt = dialog.showAndWait();
        this.result = rslt.orElse(null);
    }
}
