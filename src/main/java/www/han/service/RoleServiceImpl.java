package www.han.service;

import www.han.mapper.RoleMapper;

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
}
