package com.example.coba;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RecordTransactionController implements Initializable {
    @FXML
    private Button homeButton;
    @FXML
    private Button submitButton;
    @FXML
    private TextField transactionID;
    @FXML
    private TextField memberID;
    @FXML
    private CheckBox isMember;
    @FXML
    private TextField cashierID;
    @FXML
    private TableView<TransactionDetail> tableView;
    @FXML
    private Label subtotalText;
    @FXML
    private Label pajakText;
    @FXML
    private Label totalText;

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Parent parent = null;
                try {
                    parent = FXMLLoader.load(getClass().getResource("tableView.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            }
        });

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    connection = DBUtil.getConnection();
                    preparedStatement = connection.prepareStatement("INSERT INTO TRANSACTIONS VALUES (?,?,?,?)");
//                    preparedStatement.setString(1,idField.getText());
//                    preparedStatement.setString(2,nameField.getText());
//                    preparedStatement.setString(3,telpField.getText());
                    preparedStatement.executeQuery();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
