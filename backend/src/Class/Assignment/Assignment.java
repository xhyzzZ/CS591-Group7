package Class.Assignment;

import Class.Interface.Calculable;

public abstract class Assignment implements Calculable {

    public String assisngmentName;
    public String assignementId;
    public Boolean extraBonus;  //extra bonus
    public Integer assignementWeight;
    public Boolean addPoints;

    public Assignment() {
        this.assisngmentName = assisngmentName;
        this.assignementId = assignementId;
        this.extraBonus = extraBonus;
        this.assignementWeight = assignementWeight;
        this.addPoints = addPoints;
    }

    public String getAssisngmentName() {
        return assisngmentName;
    }

    public String getAssignementId() {
        return assignementId;
    }

    public Boolean getExtraBonus() {
        return extraBonus;
    }

    public Integer getAssignementWeight() {
        return assignementWeight;
    }

    public Boolean getAddPoints() {
        return addPoints;
    }

    public void setAssisngmentName(String assisngmentName) {
        this.assisngmentName = assisngmentName;
    }

    public void setAssignementId(String assignementId) {
        this.assignementId = assignementId;
    }

    public void setExtraBonus(Boolean extraBonus) {
        this.extraBonus = extraBonus;
    }

    public void setAssignementWeight(Integer assignementWeight) {
        this.assignementWeight = assignementWeight;
    }

    public void setAddPoints(Boolean addPoints) {
        this.addPoints = addPoints;
    }

}
