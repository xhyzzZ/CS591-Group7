package CS591.GradeManageSystem.entity.Student;

public abstract class Student {

    public enum type {
        GRADUATE, UNDERGRADUATE
    }

    public abstract String getStudentId();

    public abstract void setStudentId(String id);

    public abstract String getFirstName();

    public abstract void setFirstName(String firstName);

    public abstract String getMiddleName();

    public abstract void setMiddleName(String middleName);

    public abstract String getLastName();

    public abstract void setLastName(String lastName);

    public abstract String getEmail();

    public abstract void setEmail(String email);
}
