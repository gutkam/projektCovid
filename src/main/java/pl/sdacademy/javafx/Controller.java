package pl.sdacademy.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField menuText;
    @FXML
    private TextField dateText;
    @FXML
    private Button dataButton;
    @FXML
    private Button chartButton;

    public void initialize(){
        System.out.println("Initialization of controller");
        menuText.setText("Menu główne");
        dateText.setText("Dane zaktualizowane: ");
    }
}
