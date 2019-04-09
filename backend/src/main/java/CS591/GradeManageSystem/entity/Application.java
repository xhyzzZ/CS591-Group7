package CS591.GradeManageSystem.entity;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application {

    private Map<String, User> users;

    private Map<String, Course> courses;
}
