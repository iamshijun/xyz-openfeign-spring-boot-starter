package xyz.asitanokibou.openfeign.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;
import xyz.asitanokibou.openfeign.support.ConvertibleBeanQueryMapEncoder;

public class UserClientFeignConfiguration {

    @Bean
    public ConvertibleBeanQueryMapEncoder queryMapEncoder(ObjectProvider<ConversionService> conversionService) {
        return new ConvertibleBeanQueryMapEncoder(conversionService.getIfAvailable());
    }

}
