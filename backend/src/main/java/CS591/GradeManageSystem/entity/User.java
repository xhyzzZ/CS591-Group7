package CS591.GradeManageSystem.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;

    private String username;

    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
