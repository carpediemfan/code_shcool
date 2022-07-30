package com.fyytest.recode_school.service.impl;

import com.fyytest.recode_school.entity.Elective;
import com.fyytest.recode_school.mapper.ElectiveMapper;
import com.fyytest.recode_school.service.ElectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectiveServiceImpl implements ElectiveService {
    //    注入数据层
    @Autowired
    ElectiveMapper electiveMapper;

    @Override
    public List<Elective> getElectives() {
        return electiveMapper.getElectives();
    }
}
