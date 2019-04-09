package CS591.GradeManageSystem.entity.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Info extends Column {

    private String columnName;

    private String columnId;
}
