package edu.ucr.rp.db.util;

import edu.ucr.rp.db.domain.LineThree;

public class LineBuilderThree {

    private int idCard;
    private String address;
    private String CRS;
    private String UVS;

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

    public LineThree build(){
        return new LineThree(idCard, address, CRS, UVS);
    }
}
