package CS591.GradeManageSystem.entity;

import CS591.GradeManageSystem.entity.Column.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model {

    private String userName;

    private Double courseName;

    private List<Column> list;

    public Model(String userName, Double courseName, List<Column> list) {
        this.userName = userName;
        this.courseName = courseName;
        this.list = list;
    }
}
