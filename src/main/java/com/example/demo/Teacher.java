package com.example.demo;

public class Teacher {

    private String teacherName;

    private int age;

    private int numberOfstudents;

    public Teacher(String teacherName, int age, int numberOfstudents) {

        this.teacherName = teacherName;
        this.age = age;
        this.numberOfstudents = numberOfstudents;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumberOfstudents() {
        return numberOfstudents;
    }

    public void setNumberOfstudents(int numberOfstudents) {
        this.numberOfstudents = numberOfstudents;
    }
}
