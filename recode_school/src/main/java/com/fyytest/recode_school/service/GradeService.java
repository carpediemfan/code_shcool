package com.fyytest.recode_school.service;

import com.fyytest.recode_school.entity.Grade;
import com.fyytest.recode_school.mapper.GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface GradeService {
    //    查询所有班级的接口服务

    List<Grade> getGrades();

}
