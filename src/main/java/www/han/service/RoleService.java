package www.han.service;

import org.apache.ibatis.annotations.Param;
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
    /**
     * 更改用户对应的角色（更改权限）
     */
    int changeRole(int user_id, int role_id);
}
