package com.example.coba;

public class Members {
    String id;
    String name,notelp;

    public Members(String id,String username, String notelp) {
        this.id = id;
        this.name = username;
        this.notelp = notelp;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
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
