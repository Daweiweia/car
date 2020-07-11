package www.han.service;

import www.han.mapper.UserMapper;
import www.han.pojo.User;

import java.util.HashMap;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(String adminName, String adminPwd) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("adminName",adminName);
        map.put("adminPwd",adminPwd);
        return userMapper.login(map);
    }

    @Override
    public User loginByName(String username) {
        return userMapper.loginByName(username);
    }

    @Override
    public int register(User user) {
        return userMapper.register(user);
    }
}
