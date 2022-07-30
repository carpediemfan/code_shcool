package com.fyytest.recode_school.service.impl;

import com.fyytest.recode_school.entity.Student;
import com.fyytest.recode_school.mapper.StudentMapper;
import com.fyytest.recode_school.service.StudentService;
import com.fyytest.recode_school.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {
    //    注入数据层
    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> getStudents(String sname, Long gid, Integer pageIndex) {
        Integer startNum = (pageIndex - 1) * PageUtil.PAGESIZE;
        return studentMapper.getStudents(sname, gid, startNum, PageUtil.PAGESIZE);
    }

    @Override
    public Integer getStudentCount(String sname, Long gid) {
        return studentMapper.getStudentCount(sname, gid);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentMapper.updateStudent(student) > 0 ? true : false;
    }

    @Override
    public Integer add(Student student) {
        return studentMapper.add(student);
    }

    @Override
    public Integer delete(Long id) {
        return studentMapper.delete(id);
    }


}
