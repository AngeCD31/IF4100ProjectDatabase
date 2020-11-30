package edu.ucr.rp.db.domain;

public class LineTwo {


    private int idCard;
    private String email;

    public LineTwo(int idCard, String email) {
        this.idCard = idCard;
        this.email = email;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
