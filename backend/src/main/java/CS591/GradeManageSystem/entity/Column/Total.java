package CS591.GradeManageSystem.entity.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Total extends Column {

    private String columnName;

    private int columnId;
}
