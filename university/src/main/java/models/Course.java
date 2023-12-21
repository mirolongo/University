package models;

public class Course {
    public int courseId;
    public String nameOfCourse;
    public String description;

    public int getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", nameOfCourse='" + nameOfCourse + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getNameOfCourse() {
        return nameOfCourse;
    }

    public void setNameOfCourse(String nameOfCourse) {
        this.nameOfCourse = nameOfCourse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course(int courseId, String nameOfCourse, String description) {
        this.courseId = courseId;
        this.nameOfCourse = nameOfCourse;
        this.description = description;
    }
}
