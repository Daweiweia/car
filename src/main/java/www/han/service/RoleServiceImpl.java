package www.han.service;

import www.han.mapper.RoleMapper;
import www.han.pojo.RoleToUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RoleServiceImpl implements RoleService {

    private RoleMapper roleMapper;

    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public Set<String> getRoles(String userName) {
        return roleMapper.getRoles(userName);
    }

    @Override
    public int addRole(int userId) {
        return roleMapper.addRole(userId);
    }

    @Override
    public List<RoleToUser> getRoleListLimit(int start, int pageSize) {
        return roleMapper.getRoleListLimit(start,pageSize);
    }

    @Override
    public int getRoleSize() {
        return roleMapper.getRoleSize();
    }

    @Override
    public int changeRole(int user_id, int role_id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user_id",user_id);
        map.put("role_id",role_id);
        return roleMapper.changeRole(map);
    }
}
