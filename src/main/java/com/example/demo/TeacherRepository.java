package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TeacherRepository {

    private HashMap<String,Teacher> teacherHashMap;

    private HashMap<String , Courses> courseHashMap;

    private HashMap<String,List<String>> teacherCourseMapping;

    public void addCourse(Courses course){

       courseHashMap.put(course.getCourseName(), course);
    }

    public void addTeacher(Teacher teacher){

        teacherHashMap.put(teacher.getTeacherName(),teacher);
    }

    public void pairCourseTeacher(String courseName, String teacherName){

        List<String> courseList = new ArrayList<>();

        if(teacherCourseMapping.containsKey(courseName)){
            courseList = teacherCourseMapping.get(courseName);
        }

        courseList.add(courseName);

        teacherCourseMapping.put(teacherName,courseList);
    }

    public Courses getCourseByName(String courseName){

        if(courseHashMap.containsKey(courseName)){
            return courseHashMap.get(courseName);
        }
        return null;
    }

    public Teacher getTeacherByName(String teacherName){

        if(teacherHashMap.containsKey(teacherName)){
            return teacherHashMap.get(teacherName);
        }
        return null;
    }

    public List<String> getCourseTeacherPair(String teacherName){

        if(teacherCourseMapping.containsKey(teacherName))
            return teacherCourseMapping.get(teacherName);

        return null;
    }

    public List<String> getAllCourses(){
        return new ArrayList<>(courseHashMap.keySet());
    }

    public void deleteTeacherByName(String teacher){

        List<String> courseList = new ArrayList<>();

        if(teacherCourseMapping.containsKey(teacher)){

            courseList = teacherCourseMapping.get(teacher);

            for(String course : courseList){

                if(courseHashMap.containsKey(course))
                    courseHashMap.remove(course);
            }

            teacherCourseMapping.remove(teacher);
        }

        if(teacherHashMap.containsKey(teacher))
            teacherHashMap.remove(teacher);
    }

    public void deleteAllTeachers(){

        teacherHashMap = new HashMap<>();

        HashSet<String> courseSet = new HashSet<>();

        for(String teacher : teacherCourseMapping.keySet()){

            for(String course : teacherCourseMapping.get(teacher)){
                courseSet.add(course);
            }
        }

        for(String course : courseSet){

            if(courseHashMap.containsKey(course))
                courseHashMap.remove(course);
        }

        teacherCourseMapping = new HashMap<>();
    }
}
