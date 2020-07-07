package www.han.service;

import java.util.Set;

/**
 * @author:Mr.Han
 * @description:权限service
 * @date:2020/7/4
 */
public interface PermService {
    Set<String> getPerms(String userName);
    Set<String> getUrl(String userName);
    boolean needInterceptor(String url);
}
