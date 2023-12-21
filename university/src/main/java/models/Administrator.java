package models;

import java.time.LocalDate;

public class Administrator extends User {
    public String department;

    public Administrator(int userId, String name, String dateOfBirth, String department) {
        super(userId, name, dateOfBirth);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        department = department;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "Department='" + department + '\'' +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }

    @Override
    public void setSubjectId(int subjectId) {
        // implementação específica, se necessário
    }

    @Override
    public String getUserType() {
        return "Administrator";
    }

    @Override
    public int getSubjectId() {
        return 0; // implementação específica, se necessário
    }
}
