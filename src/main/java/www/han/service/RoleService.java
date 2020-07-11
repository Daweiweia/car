package www.han.service;

import java.util.Map;
import java.util.Set;

/**
 * @author:Mr.Han
 * @description:角色service
 * @date:2020/7/4
 */
public interface RoleService {
    Set<String> getRoles(String userName);
    int addRole(int userId);
}
