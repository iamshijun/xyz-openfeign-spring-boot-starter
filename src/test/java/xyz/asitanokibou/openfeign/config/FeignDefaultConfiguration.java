package xyz.asitanokibou.openfeign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import xyz.asitanokibou.openfeign.FeignFormatterRegistrar;
import xyz.asitanokibou.openfeign.interceptor.BearTokenAuthInterceptor;

import java.time.format.DateTimeFormatter;

import static xyz.asitanokibou.openfeign.config.converter.FormatConstant.*;

@Configuration
public class FeignDefaultConfiguration {

    @Bean
    public FeignFormatterRegistrar timeFormatterRegistrar() {


        return registry -> {
            DateTimeFormatterRegistrar dateTimeFormatterRegistrar = new DateTimeFormatterRegistrar();
            dateTimeFormatterRegistrar.setDateFormatter(DateTimeFormatter.ofPattern(DATE_FORMAT));
            dateTimeFormatterRegistrar.setDateTimeFormatter(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
            dateTimeFormatterRegistrar.setTimeFormatter(DateTimeFormatter.ofPattern(TIME_FORMAT));
            dateTimeFormatterRegistrar.registerFormatters(registry);

            //or
//            registry.addConverter(new LocalDateTimeToString());
//            registry.addConverter(new LocalDateToString());
//            registry.addConverter(new LocalTimeToString());
//            registry.addConverter(new StringToLocalDate());
//            registry.addConverter(new StringToLocalDateTime());
//            registry.addConverter(new StringToLocalTime());
        };
    }

    @Bean
    public BearTokenAuthInterceptor bearTokenAuthInterceptor() {
        return new BearTokenAuthInterceptor("Authorization");
    }

//    @Bean //配置全局的feign Logger.Level
//    Logger.Level feignLoggerLevel() {
//        return Logger.Level.FULL;
//    }
}
