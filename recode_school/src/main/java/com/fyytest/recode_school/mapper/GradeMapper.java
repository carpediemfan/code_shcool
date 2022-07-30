package com.fyytest.recode_school.mapper;

import com.fyytest.recode_school.entity.Grade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeMapper {
    //    查询班级数据接口
    List<Grade> getGrades();
}
