package edu.ucr.rp.db.domain;

public class LineFour {

    private int numberLine;
    private int idCard;
    private String phone;

    public LineFour(int numberLine, int idCard, String phone) {
        this.numberLine = numberLine;
        this.idCard = idCard;
        this.phone = phone;
    }

    public int getNumberLine() {
        return numberLine;
    }

    public void setNumberLine(int numberLine) {
        this.numberLine = numberLine;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
