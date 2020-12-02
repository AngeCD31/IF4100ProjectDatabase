package edu.ucr.rp.db.util;

import edu.ucr.rp.db.domain.LineTwo;

public class LineBuilderTwo {

    private int idCard;
    private String email;
    private String CRS;
    private String UVS;

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

    public String getCRS() {
        return CRS;
    }

    public void setCRS(String CRS) {
        this.CRS = CRS;
    }

    public String getUVS() {
        return UVS;
    }

    public void setUVS(String UVS) {
        this.UVS = UVS;
    }

    public LineTwo build(){
        return new LineTwo(idCard, email, CRS, UVS);
    }
}
