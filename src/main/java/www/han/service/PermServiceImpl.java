package www.han.service;

import www.han.mapper.PermMapper;

import java.util.Set;

public class PermServiceImpl implements PermService{
    private PermMapper permMapper;

    public void setPermMapper(PermMapper permMapper) {
        this.permMapper = permMapper;
    }

    @Override
    public Set<String> getPerms(String userName) {
        return permMapper.getPerms(userName);
    }

    @Override
    public Set<String> getUrl(String userName) {
        return permMapper.getUrl(userName);
    }

    @Override
    public boolean needInterceptor(String url) {
        Set<String> allUrl = permMapper.getAllUrl();
        System.out.println("needInterceptor"+allUrl);
        for (String u : allUrl) {
            if (u.equals(url)){
                return true;
            }
        }
        return false;
    }
}
