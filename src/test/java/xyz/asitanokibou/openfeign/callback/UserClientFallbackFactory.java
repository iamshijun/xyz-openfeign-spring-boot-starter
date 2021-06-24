package xyz.asitanokibou.openfeign.callback;


import feign.hystrix.FallbackFactory;
import xyz.asitanokibou.openfeign.client.UserClient;

public class UserClientFallbackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable cause) {
        return FallbackFeign.newInstance(UserClient.class, cause);
    }
}
