package CS591.GradeManageSystem.entity;

import com.sun.tools.javac.jvm.Gen;
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

    public enum Gender {
        MALE, FEMALE
    }
    private int studentId;
    private int courseId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String note;
    private int age;
    private Type type;
    private Gender gender;

    public Student(int courseId, String firstName, String middleName, String lastName, String email, String note, int age, String type, String gender) {
        this.courseId = courseId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.note = note;
        this.age = age;
        this.type = Type.valueOf(type);
        this.gender = Gender.valueOf(gender);
    }

}
