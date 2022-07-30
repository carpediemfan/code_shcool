package com.fyytest.recode_school.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fyytest.recode_school.util.LongJsonDeserializer;
import com.fyytest.recode_school.util.LongJsonSerializer;
import lombok.Data;

@Data
public class Elective {
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long id;
    private String name;
}
