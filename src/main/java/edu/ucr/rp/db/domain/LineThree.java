package edu.ucr.rp.db.domain;

public class LineThree {

    private int idCard;
    private String address;

    public LineThree(int idCard, String address) {
        this.idCard = idCard;
        this.address = address;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
