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

public class UpdateController implements Initializable {
    @FXML
    private TextField usernameField;
    @FXML
    private TextField notelpField;

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void submit() throws SQLException {
        connection = DBUtil.getConnection();
        String name = usernameField.getText();
        String notelp = notelpField.getText();
        if (name.isEmpty() || notelp.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the data!!");
            alert.showAndWait();
        } else {
            insert();
            usernameField.setText(null);
            notelpField.setText(null);
            TableController.temp = 0;

        }
    }
    public String getQuery(){
        return "UPDATE users SET " +
                "name=?,"+
                "notelp=? WHERE id = "+ TableController.temp+"";
    }
    public void insert() throws SQLException {
        preparedStatement = connection.prepareStatement(getQuery());
        preparedStatement.setString(1,usernameField.getText());
        preparedStatement.setString(2,notelpField.getText());
        preparedStatement.executeQuery();
    }
}
