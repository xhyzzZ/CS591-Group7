package CS591.GradeManageSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statistics implements Calculable {
    private int assignmentId;
    private Double median;
    private Double mean;
    private Double max;
    private Double min;
    private Double stdDev;

}
