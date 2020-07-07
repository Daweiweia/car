package www.han.mapper;

import java.util.Set;

/**
 * @author:Mr.Han
 * @description:角色权限
 * @date:2020/7/4
 */
public interface PermMapper {
    /**
      根据用户名获取权限
       */
    Set<String> getPerms(String userName);

    Set<String> getUrl(String userName);

    Set<String> getAllUrl();
}
