package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping("/add_course")
    public ResponseEntity<String> addCourse(@RequestBody Courses course){

        teacherService.addCourse(course);
        return new ResponseEntity<>("New Course added", HttpStatus.CREATED);
    }

    @PostMapping("/add_teacher")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher){

        teacherService.addTeacher(teacher);
        return new ResponseEntity<>("New Teacher added", HttpStatus.CREATED);
    }

    @PutMapping("/pair_course_teacher")
    public ResponseEntity<String> addCourseTeacherPair(@RequestParam String course, @RequestParam String teacher){

        teacherService.addCourseTeacherPair(course,teacher);
        return new ResponseEntity<>("New Course Teacher Pair added", HttpStatus.CREATED);
    }

    @GetMapping("/get_course_by_name/{name}")
    public ResponseEntity<Courses> getStudentByName(@PathVariable String name){

        Courses courses = teacherService.getCourse(name);

        return new ResponseEntity<>(courses, HttpStatus.CREATED);
    }

    @GetMapping("/get_teacher_by_name/{name}")
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable String name){

        Teacher teacher = teacherService.getTeacher(name);

        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    @GetMapping("/get_course_by_teacher_name/{teacher}")
    public ResponseEntity<List<String>> getStudentsByTeacherName(@PathVariable String teacher){
        List<String> teacherCoursePair = teacherService.getCousreTeacherPair(teacher);

        return new ResponseEntity<>(teacherCoursePair, HttpStatus.CREATED);
    }

    @GetMapping("/get_all_students")
    public ResponseEntity<List<String>> getAllStudents(){
        List<String> courseList = teacherService.getAllCourses();

        return new ResponseEntity<>(courseList, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_teacher_by_name")
    public ResponseEntity<String> deleteTeacherByName(@RequestParam String teacher){
        teacherService.deleteTeacherByName(teacher);
        return new ResponseEntity<>(teacher + " removed successfully", HttpStatus.CREATED);
    }
    @DeleteMapping("/delete_all_teachers")
    public ResponseEntity<String> deleteAllTeachers(){
        teacherService.deleteAllTeachers();
        return new ResponseEntity<>("All teachers deleted successfully", HttpStatus.CREATED);
    }


}
