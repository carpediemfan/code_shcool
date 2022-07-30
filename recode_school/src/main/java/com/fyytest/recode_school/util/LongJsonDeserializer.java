package com.fyytest.recode_school.util;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class LongJsonDeserializer extends JsonDeserializer<Long> {
    @Override
    public Long deserialize(JsonParser p, DeserializationContext ctext) throws IOException, JacksonException {
        String value = p.getText();
        try {

            return value == null ? null : Long.parseLong(value);

        } catch (NumberFormatException e) {
            return null;
        }
    }
}
