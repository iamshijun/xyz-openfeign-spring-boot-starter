package xyz.asitanokibou.openfeign.config.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @description: LocalDateTime转String类
 * @author: yinliyun
 * @create: 2021-01-14 15:45
 **/
public class LocalTimeToString implements Converter<LocalTime, String> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FormatConstant.TIME_FORMAT);

    @Override
    public String convert(LocalTime source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return FORMATTER.format(source);
    }

}