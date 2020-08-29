package pl.sdacademy.javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerEx {
    @FXML
    private TextField myTextField;
    @FXML
    private Button newWindowButton;

    //żeby wypróbować działanie należy zmienić w pom.xml
    //<mainClass>pl.sdacademy.javafx.Main</mainClass> na <mainClass>pl.sdacademy.javafx.MainEx</mainClass>
    public void initialize() {
        System.out.println("Initialization of controller");
        myTextField.setText("New window");
        newWindowButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Main window");
                    stage.setScene(new Scene(root, 450, 450));
                    stage.show();
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
