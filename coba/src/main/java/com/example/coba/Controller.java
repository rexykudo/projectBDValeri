//package com.example.coba;
//
//import java.sql.Connection;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//
//public class Controller  {
//    @FXML
//    private TextField userName;
//    @FXML
//    private TextField password;
//    @FXML
//    private Label lebel;
//    PreparedStatement pstmt=null;
//    Connection con=null;
//    ResultSet rs=null;
//
//    public void Login(ActionEvent event){
//        try {
//            con=DBUtil.getConnection();
//            con.createStatement();
//
//            String sql = "select * from login where username=? and password=?";
//
//            pstmt = con.prepareStatement(sql);
//            pstmt.setString(1,userName.getText());
//            pstmt.setString(2, password.getText());
//
//            rs = pstmt.executeQuery();
//            System.out.println(rs);
//
//            if(rs.next()) {
//                lebel.setText("Login Sucessfully!");
//            }else{
//                lebel.setText("Login Not Sucessfully!");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//}






package com.example.coba;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Label lebel;

    @FXML
    private PasswordField password;

    @FXML
    private TextField userName;

    @FXML
    void Login(ActionEvent event) {

    }

}
