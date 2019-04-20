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

    public enum Gender {
        MALE, FEMALE
    }
    private int studentId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String note;
    private int age;
    private Type type;
    private Gender gender;

    public Student(int studentId, String firstName, String middleName, String lastName, String email, String note, int age) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.note = note;
        this.age = age;
    }

    public Student(String firstName, String middleName, String lastName, String email, String note, int age) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.note = note;
        this.age = age;
    }

}
