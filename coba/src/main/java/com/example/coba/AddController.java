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
    private TextField nameField;
    @FXML
    private TextField telpField;

    Connection connection = null;
    PreparedStatement preparedStatement = null;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void submit() throws SQLException {
        connection = DBUtil.getConnection();
        String id = idField.getText();
        String name = nameField.getText();
        String email = telpField.getText();
        if (name.isEmpty() || email.isEmpty() || id.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the data!!");
            alert.showAndWait();
        }else {
            insert();
            idField.setText(null);
            nameField.setText(null);
            telpField.setText(null);
        }
    }

    public String getQuery(){
        return "INSERT INTO MEMBERS VALUES(?,?,?)";
    }

    public void insert() throws SQLException {
        preparedStatement = connection.prepareStatement(getQuery());
        preparedStatement.setString(1,idField.getText());
        preparedStatement.setString(2,nameField.getText());
        preparedStatement.setString(3,telpField.getText());
        preparedStatement.executeQuery();
    }
}
