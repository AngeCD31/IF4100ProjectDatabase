package edu.ucr.rp.db.util;

import edu.ucr.rp.db.domain.LineTwo;

public class LineBuilderTwo {

    private int idCard;
    private String email;

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

    public LineTwo build(){
        return new LineTwo(idCard, email);
    }
}
