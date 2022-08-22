package com.mohuani.javacollectionexamples.data;

import com.mohuani.javacollectionexamples.entity.Student;
import com.mohuani.javacollectionexamples.entity.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Resource;

/**
 * @description:
 * @author: fdm
 * @date: 2022/8/21 15:18
 */
public class StudentDomain {

    @Resource
    private TeacherDomain teacherDomain;


    public Student getStudent() {

        List<Teacher> teacherList = teacherDomain.getTeacherList();

        Student student = new Student();
        student.setId(new Random().nextInt(100));
        student.setName("学生" + student.getId());
        student.setTeacherIdList(teacherList.stream().map(Teacher::getId).collect(Collectors.toList()));

        return student;

    }


    public List<Student> getStudentList() {
        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Student student = getStudent();
            studentList.add(student);
        }

        return studentList;
    }

}
