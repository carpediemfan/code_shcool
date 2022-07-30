package com.fyytest.recode_school.service;

import com.fyytest.recode_school.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    List<Student> getStudents(String sname, Long gid, Integer pageIndex);

    Integer getStudentCount(String sname, Long gid);

    boolean updateStudent(Student student);

    Integer add(Student student);

    Integer delete( Long id);
}
