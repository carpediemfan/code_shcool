package com.fyytest.recode_school.mapper;

import com.fyytest.recode_school.entity.Elective;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ElectiveMapper {
    List<Elective> getElectives();
}
