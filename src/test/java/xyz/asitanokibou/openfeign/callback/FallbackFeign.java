package xyz.asitanokibou.openfeign.callback;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import xyz.asitanokibou.demo.models.core.ServiceResult;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class FallbackFeign {

    @SuppressWarnings("unchecked")
    static <T> T newInstance(Class<T> feignClazz, Throwable throwable) {
//        Assert.isTrue(feignClazz.isAnnotationPresent(FeignClient.class),
//                            "feignClazz must be annotated with @FeignClient");

        return (T) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{feignClazz}, new AlwaysReturnFallbackResultInvocationHandler(throwable));
    }

    @AllArgsConstructor
    private static class AlwaysReturnFallbackResultInvocationHandler implements InvocationHandler {
        private final Throwable throwable;

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) {
            return ServiceResult.fallback(throwable);
        }
    }
}