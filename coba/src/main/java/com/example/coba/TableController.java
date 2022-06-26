package com.example.coba;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TableController implements Initializable {
    static Integer temp = 0;

    @FXML
    private TableView<Members> ViewTable = new TableView<>();

    @FXML
    private TableColumn<Members, String> idCol = new TableColumn<>();

    @FXML
    private TableColumn<Members, String> nameCol = new TableColumn<>();

    @FXML
    private TableColumn<Members, String> telpCol = new TableColumn<>();


    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Members member = null;

    ObservableList<Members> memberList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void AddMenu() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("addMember.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    @FXML
    void Exit(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }

    @FXML
    void Refresh() throws SQLException {
        memberList.clear();
        query = "SELECT * FROM MEMBERS";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            memberList.add(
                    new Members(
                            resultSet.getString("MEMBER_ID"),
                            resultSet.getString("MEMBER_NAME"),
                            resultSet.getString("MEMBER_TELP")
                    )
            );
        }
        if (! resultSet.next()){
        }else ViewTable.setItems(memberList);
    }
    @FXML
    void Delete() throws SQLException{
        if (ViewTable.getSelectionModel().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please choose which row to delete");
            alert.showAndWait();
        }else {
            member = ViewTable.getSelectionModel().getSelectedItem();
            query = "DELETE FROM MEMBERS WHERE id = " + member.getId();
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            Refresh();
        }
    }
    @FXML
    void Update() throws SQLException {
        member = ViewTable.getSelectionModel().getSelectedItem();
        if (ViewTable.getSelectionModel().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please choose which row to update");
            alert.showAndWait();
        }else {
            member = ViewTable.getSelectionModel().getSelectedItem();
            query = "DELETE FROM MEMBERS WHERE id = " + member.getId();
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
        }

    }

    @FXML
    public void loadData() throws SQLException {
        connection = DBUtil.getConnection();
        Refresh();
        idCol.setCellValueFactory(new PropertyValueFactory<>("MEMBER_ID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("MEMBER_NAME"));
        telpCol.setCellValueFactory(new PropertyValueFactory<>("MEMBER_TELP"));
//                        editIcon.setOnMouseClicked((MouseEvent event) -> {
//
//                            user = ViewTable.getSelectionModel().getSelectedItem();
//                            FXMLLoader loader = new FXMLLoader ();
//                            loader.setLocation(getClass().getResource("addStudent.fxml"));
//                            try {
//                                loader.load();
//                            } catch (IOException ex) {
//                                ex.printStackTrace();
//                            }
//
//                            AddController addStudentController = loader.getController();
//                            addStudentController.setUpdate(true);
//                            addStudentController.setTextField(student.getId(), student.getName(),
//                                    student.getBirth().toLocalDate(),student.getAdress(), student.getEmail());
//                            Parent parent = loader.getRoot();
//                            Stage stage = new Stage();
//                            stage.setScene(new Scene(parent));
//                            stage.initStyle(StageStyle.UTILITY);
//                            stage.show();
//
//
//
//
//                        });
//                        HBox managebtn = new HBox(editIcon, deleteIcon);
//                        managebtn.setStyle("-fx-alignment:center");
//                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
//                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));
//
//                        setGraphic(managebtn);
//
//                        setText(null);
//
//                    }
//
//                }
//            };
//            return cell;
//        };
//        editCol.setCellFactory(cellFoctory);
//        ViewTable.setItems(userList);
    }
}
