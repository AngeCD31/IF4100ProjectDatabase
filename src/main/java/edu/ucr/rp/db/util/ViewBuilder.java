package edu.ucr.rp.db.util;

import edu.ucr.rp.db.domain.LineOne;
import edu.ucr.rp.db.domain.View;

public class ViewBuilder {

    private int numberLine;
    private String email;
    private String address;
    private int pointsEarned;
    private int idCard;

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

    public View build(){
        return new View(numberLine, email, address, pointsEarned, idCard);
    }
}
