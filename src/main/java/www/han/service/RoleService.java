package www.han.service;

import www.han.pojo.RoleToUser;

import java.util.List;
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
    List<RoleToUser> getRoleListLimit(int start, int pageSize);
    int getRoleSize();
}
