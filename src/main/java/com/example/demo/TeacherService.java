package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public void addCourse(Courses course){
        teacherRepository.addCourse(course);
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.addTeacher(teacher);
    }

    public void addCourseTeacherPair(String course, String teacher){
        teacherRepository.pairCourseTeacher(course,teacher);
    }

    public Courses getCourse(String courseName){

        return teacherRepository.getCourseByName(courseName);
    }

    public Teacher getTeacher(String teacherName){
        return teacherRepository.getTeacherByName(teacherName);
    }

    public List<String> getCousreTeacherPair(String teacherName){
        return teacherRepository.getCourseTeacherPair(teacherName);
    }
    public List<String> getAllCourses(){
        return teacherRepository.getAllCourses();
    }

    public void deleteTeacherByName(String teacher) {
       teacherRepository.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers(){
        teacherRepository.deleteAllTeachers();
    }
}
