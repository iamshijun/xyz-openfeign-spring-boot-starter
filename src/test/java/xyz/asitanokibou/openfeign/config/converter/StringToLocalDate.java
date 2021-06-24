package xyz.asitanokibou.openfeign.config.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @description: String转LocalDateTime类
 * @author: yinliyun
 * @create: 2021-01-14 15:43
 **/
public class StringToLocalDate implements Converter<String, LocalDate> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FormatConstant.DATE_FORMAT);

    @Override
    public LocalDate convert(String source) {
        if (StringUtils.isEmpty(source)) {
            return null;
        }
        return LocalDate.parse(source, FORMATTER);
    }

}
