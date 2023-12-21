package models;

import java.time.LocalDate;

public class Student extends User {
    private int subjectId;
    public int courseId;

    public Student(int userId, String name, String dateOfBirth, int courseId, int subjectId) {
        super(userId, name, dateOfBirth);
        this.subjectId = subjectId;
        this.courseId = courseId;
    }

    @Override
    public int getSubjectId() {
        return subjectId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "userId=" + userId +
                ", courseId=" + courseId +
                ", subjectId=" + subjectId +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    @Override
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String getUserType() {
        return "Student";
    }
}
