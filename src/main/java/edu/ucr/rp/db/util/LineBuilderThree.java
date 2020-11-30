package edu.ucr.rp.db.util;

import edu.ucr.rp.db.domain.LineThree;

public class LineBuilderThree {

    private int idCard;
    private String address;

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

    public LineThree build(){
        return new LineThree(idCard,address);
    }
}
