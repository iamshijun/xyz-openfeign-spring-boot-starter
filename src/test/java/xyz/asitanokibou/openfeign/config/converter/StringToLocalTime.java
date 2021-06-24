package xyz.asitanokibou.openfeign.config.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @description: String转LocalDateTime类
 * @author: yinliyun
 * @create: 2021-01-14 15:43
 **/
public class StringToLocalTime implements Converter<String, LocalTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FormatConstant.TIME_FORMAT);

    @Override
    public LocalTime convert(String source) {
        if (StringUtils.isEmpty(source)) {
            return null;
        }
        return LocalTime.parse(source, FORMATTER);
    }

}
