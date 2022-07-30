package com.fyytest.recode_school.service.impl;

import com.fyytest.recode_school.entity.Grade;
import com.fyytest.recode_school.mapper.GradeMapper;
import com.fyytest.recode_school.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    GradeMapper gradeMapper;

    @Override
    public List<Grade> getGrades() {
        return gradeMapper.getGrades();
    }
}
