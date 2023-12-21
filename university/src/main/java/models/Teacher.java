package models;

import java.time.LocalDate;

public class Teacher extends User {
    public int subjectId;

    public Teacher(int userId, String name, String dateOfBirth, int subjectId) {
        super(userId, name, dateOfBirth);
        this.subjectId = subjectId;
    }

    @Override
    public int getSubjectId() {
        return subjectId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "userId=" + userId +
                ", subjectId=" + subjectId +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    @Override
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String getUserType() {
        return "Teacher";
    }
}
