package com.example.coba;

public class Discounts {
    String id;
    float pct;

    public Discounts(String id, float pct) {
        this.id = id;
        this.pct = pct;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getPct() {
        return pct;
    }

    public void setPct(float pct) {
        this.pct = pct;
    }
}
