package edu.ucr.rp.db.util;

import edu.ucr.rp.db.domain.Line;

public class LineBuilder {

    private int numberLine;
    private String lineType;
    private int pointsEarned;
    private int idCard;
    private String name;
    private String lastName;
    private String email;
    private String address;
    private String phone;

    public void setNumberLine(int numberLine) {
        this.numberLine = numberLine;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public void setPointsEarned(int pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Line build(){
        return new Line(numberLine, lineType, pointsEarned, idCard, name, lastName,
                   email, address, phone);
    }
}
