package CS591.GradeManageSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {

    private String note;

    private Double grade;

    public Grade(String note, Double grade) {
        this.note = note;
        this.grade = grade;
    }

}
