package edu.ucr.rp.db.util;

import edu.ucr.rp.db.domain.LineFour;

public class LineBuilderFour {

    private int numberLine;
    private int idCard;
    private String phone;
    private String CRS;
    private String UVS;

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

    public LineFour build(){
        return new LineFour(numberLine, idCard, phone, CRS, UVS);
    }
}
