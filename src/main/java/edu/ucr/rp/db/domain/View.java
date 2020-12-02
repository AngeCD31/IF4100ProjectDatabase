package edu.ucr.rp.db.domain;

public class View {

    private int numberLine;
    private String email;
    private String address;
    private int pointsEarned;
    private int idCard;

    public View(int numberLine, String email, String address, int pointsEarned, int idCard) {
        this.numberLine = numberLine;
        this.email = email;
        this.address = address;
        this.pointsEarned = pointsEarned;
        this.idCard = idCard;
    }

    public int getNumberLine() {
        return numberLine;
    }

    public void setNumberLine(int numberLine) {
        this.numberLine = numberLine;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(int pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }
}
