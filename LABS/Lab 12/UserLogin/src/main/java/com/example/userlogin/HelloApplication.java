package com.example.userlogin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 320, 240);
        stage.setTitle("User Login");
        Text text = new Text("Welcome to User Login");
        Label userNameLabel = new Label("UserName");
        Label passwordLabel = new Label("Password");
        TextField usernameTextField =new TextField();
        TextField passwordTextField =new TextField();
        Button button = new Button("Login");

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.BASELINE_RIGHT);
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        gridPane.add(text,0,0);
        gridPane.add(userNameLabel,0,1);
        gridPane.add(passwordLabel,0,2);
        gridPane.add(usernameTextField,1,1);
        gridPane.add(passwordTextField,1,2);
        gridPane.add(button,1,3);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}