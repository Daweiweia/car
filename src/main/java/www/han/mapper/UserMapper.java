package www.han.mapper;

import www.han.pojo.User;

import java.util.Map;

/**
 * @author:Mr.Han
 * @description:
 * @date:2020/7/2
 */
public interface UserMapper {
    /**
        *登录验证
     * @return
     */
    User login(Map<String,Object> map);

    User loginByName(String username);

    int register();
}
