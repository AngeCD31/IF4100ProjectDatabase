package edu.ucr.rp.db.domain;

public class LineOne {

    private int numberLine;
    private String lineType;
    private int pointsEarned;
    private int idCard;

    public LineOne(int numberLine, String lineType, int pointsEarned, int idCard) {
        this.numberLine = numberLine;
        this.lineType = lineType;
        this.pointsEarned = pointsEarned;
        this.idCard = idCard;
    }

    public int getNumberLine() {
        return numberLine;
    }

    public void setNumberLine(int numberLine) {
        this.numberLine = numberLine;
    }

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
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
