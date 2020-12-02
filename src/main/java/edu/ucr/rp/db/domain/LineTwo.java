package edu.ucr.rp.db.domain;

public class LineTwo {


    private int idCard;
    private String email;
    private String CRS;
    private String UVS;

    public LineTwo(int idCard, String email, String CRS, String UVS) {
        this.idCard = idCard;
        this.email = email;
        this.CRS = CRS;
        this.UVS = UVS;
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
}
