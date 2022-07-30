package com.fyytest.recode_school.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fyytest.recode_school.util.LongJsonDeserializer;
import com.fyytest.recode_school.util.LongJsonSerializer;
import lombok.Data;

@Data
public class Student {
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long id;
    private String name;
    private String sex;
    private String phone;
    private String address;
    //    封装成对象
//    private Long gid;
    private Grade grade;
    //    private Long eid;
    private Elective elective;
}
