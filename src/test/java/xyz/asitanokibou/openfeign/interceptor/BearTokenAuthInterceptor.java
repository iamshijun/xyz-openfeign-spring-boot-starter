package xyz.asitanokibou.openfeign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@NoArgsConstructor
@AllArgsConstructor
public class BearTokenAuthInterceptor implements RequestInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(BearTokenAuthInterceptor.class);

    private String requestHeaderName = "Authorization";

    private String templateHeaderName = "Authorization";

    public BearTokenAuthInterceptor(String headerName) {
        this(headerName, headerName);
    }

    @Override
    public void apply(RequestTemplate template) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (null != attributes) {
            // 提取请求头中的Authorization，用于feign中添加请求头Authorization
            HttpServletRequest request = attributes.getRequest();
            String token = request.getHeader(requestHeaderName);
            template.header(templateHeaderName, token);
            // 注：由于feign调用的特殊性
            // 使用dto的，feign请求时会以application/json;charset=UTF-8方式请求。所以请求方法使用post
            // 使用普通param得，feign请求时会以application/x-www-form-urlencoded;charset=UTF-8方式请求。所以请求方法使用get
        }
        logger.debug("feign requestInterceptor for auth , template:{}", template);
    }
}
