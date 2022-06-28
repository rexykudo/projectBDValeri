package com.example.coba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDetail {
    private String itemID, transactionID;
    private int quantity;
    private Double priceSubtotal;

    private Connection con;
    private PreparedStatement stmt;

    TransactionDetail(String itemID, String transactionID, int quantity) throws SQLException {
        this.itemID = itemID;
        this.transactionID = transactionID;
        this.quantity = quantity;

        con = DBUtil.getConnection();
        stmt = con.prepareStatement("SELECT PRICE FROM ITEMS WHERE item_id = ?");
        stmt.setString(1, itemID);
        stmt.executeQuery();
        ResultSet results = stmt.getResultSet();

        this.priceSubtotal = quantity * results.getDouble("item_price");
        con.close();
    }

    TransactionDetail(String itemID, String transactionID, int quantity, double priceSubtotal) {
        this.itemID = itemID;
        this.transactionID = transactionID;
        this.quantity = quantity;
        this.priceSubtotal = priceSubtotal;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPriceSubtotal() {
        return priceSubtotal;
    }

    public void setPriceSubtotal(Double priceSubtotal) {
        this.priceSubtotal = priceSubtotal;
    }
}
