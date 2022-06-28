package com.example.coba;

public class Cashiers {
    String id, name, telp, add;

    public Cashiers(String id, String name, String telp, String add) {
        this.id = id;
        this.name = name;
        this.telp = telp;
        this.add = add;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
}
