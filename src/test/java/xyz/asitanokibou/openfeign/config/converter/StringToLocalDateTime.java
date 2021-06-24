package xyz.asitanokibou.openfeign.config.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @description: String转LocalDateTime类
 * @author: yinliyun
 * @create: 2021-01-14 15:43
 **/
public class StringToLocalDateTime implements Converter<String, LocalDateTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FormatConstant.DATE_TIME_FORMAT);

    @Override
    public LocalDateTime convert(String source) {
        if (StringUtils.isEmpty(source)) {
            return null;
        }
        return LocalDateTime.parse(source, FORMATTER);
    }

}
