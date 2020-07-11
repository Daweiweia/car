package www.han.service;

import www.han.pojo.User;

/**
 * @author:Mr.Han
 * @description:
 * @date:2020/7/2
 */
public interface UserService {
    User login(String adminName, String adminPwd);

    User loginByName(String username);

    int register(User user);
}
