package CS591.GradeManageSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Model {

    private int modelId;
    private String modelName;
    private String columnName;
    private int weight;
    private boolean addPoint;
    private boolean extraBonus;
    private boolean fix;

    public Model(String modelName, String columnName, int weight, boolean addPoint, boolean extraBonus, boolean fix) {
        this.modelName = modelName;
        this.columnName = columnName;
        this.weight = weight;
        this.addPoint = addPoint;
        this.extraBonus = extraBonus;
        this.fix = fix;
    }
}
