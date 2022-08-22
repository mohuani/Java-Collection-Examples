package com.mohuani.javacollectionexamples.data;

import com.mohuani.javacollectionexamples.entity.Teacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

/**
 * @description:
 * @author: fdm
 * @date: 2022/8/21 15:18
 */
public class TeacherDomain {

    @Resource
    private StudentDomain studentDomain;

    public Teacher getTeacher() {
        Teacher teacher = new Teacher();
        teacher.setId(new Random().nextInt(100));
        teacher.setName("老师" + teacher.getId());
        teacher.setStudentIdList(Arrays.asList(new Random().nextInt(100), new Random().nextInt(100), new Random().nextInt(100)));

        return teacher;
    }

    public List<Teacher> getTeacherList() {
        List<Teacher> teacherList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Teacher teacher = getTeacher();
            teacherList.add(teacher);
        }
        return teacherList;
    }


}
