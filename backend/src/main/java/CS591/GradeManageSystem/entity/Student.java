package CS591.GradeManageSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    public enum Type {
        GRADUATE, UNDERGRADUATE
    }

    public  enum Gender {
        MALE, FEMALE
    }
    private int studentId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private Gender gender;
    private int age;
    private Type type;
    private String note;
}
