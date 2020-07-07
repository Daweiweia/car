package www.han.mapper;

import java.util.Set;

/**
 * @author:Mr.Han
 * @description:角色Mapper
 * @date:2020/7/4
 */
public interface RoleMapper {
    /**
        *根据角色name得到对应的角色名
        * @author Mr.han
        * @date
        * @param
        * @return
       */
    Set<String> getRoles(String userName);
}
