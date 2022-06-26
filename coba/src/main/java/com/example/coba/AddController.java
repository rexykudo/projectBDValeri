package com.example.coba;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddController implements Initializable {
    @FXML
    private TextField idField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField emailField;

    Connection connection = null;
    PreparedStatement preparedStatement = null;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void submit() throws SQLException {
        connection = DBUtil.getConnection();
        Integer id = Integer.parseInt(idField.getText());
        String name = usernameField.getText();
        String password = passwordField.getText();
        String email = emailField.getText();
        if (name.isEmpty() || password.isEmpty() || email.isEmpty() || idField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the data!!");
            alert.showAndWait();
        }else {
            insert();
            idField.setText(null);
            usernameField.setText(null);
            passwordField.setText(null);
            emailField.setText(null);

        }
    }

    public String getQuery(){
        return "INSERT INTO users VALUES(?,?,?,?)";
    }
    public void insert() throws SQLException {
        preparedStatement = connection.prepareStatement(getQuery());
        preparedStatement.setInt(1,Integer.parseInt(idField.getText()));
        preparedStatement.setString(2,usernameField.getText());
        preparedStatement.setString(3,passwordField.getText());
        preparedStatement.setString(4,emailField.getText());
        preparedStatement.executeQuery();
    }
}
