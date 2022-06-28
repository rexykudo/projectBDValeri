package com.example.coba;

public class Members {
    String id, name, notelp;

    public Members(String id, String name, String notelp) {
        this.id = id;
        this.name = name;
        this.notelp = notelp;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
