package www.han.mapper;

import org.apache.ibatis.annotations.Param;
import www.han.pojo.RoleToUser;

import java.util.List;
import java.util.Set;

/**
 * @author:Mr.Han
 * @description:角色Mapper
 * @date:2020/7/4
 */
public interface RoleMapper {
    /**
     * 根据角色name得到对应的角色名
     *
     * @param
     * @return
     * @author Mr.han
     * @date
     */
    Set<String> getRoles(String userName);

    /**
     * 增加一个角色用户
     */
    int addRole(int userId);

    List<RoleToUser> getRoleListLimit(@Param("start") int start, @Param("pageSize") int pageSize);

    /**
     * 得到总角色数量
     */
    int getRoleSize();
/**
 * 增加一个角色用户
 */
/**
 * 增加一个角色用户
 */
}
