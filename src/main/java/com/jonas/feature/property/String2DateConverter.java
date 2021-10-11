package com.jonas.feature.property;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * String类型转Date类型的转换器
 */
public class String2DateConverter implements Converter<String, Date> {
    private String format = "yyyy-MM-dd";

    @Override
    public Date convert(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
