package edu.ucr.rp.db.util;

import edu.ucr.rp.db.domain.LineOne;

public class LineBuilderOne {

    private int numberLine;
    private String lineType;
    private int pointsEarned;
    private int idCard;

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

    public LineOne build(){
        return new LineOne(numberLine, lineType, pointsEarned, idCard);
    }
}
