package www.han.config.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import www.han.pojo.User;
import www.han.service.PermService;
import www.han.service.RoleService;
import www.han.service.UserService;

import java.util.Set;

/***
 * 授权认证
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private PermService permService;
    @Autowired
    private RoleService roleService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName =(String) principalCollection.getPrimaryPrincipal();
        //通过service获取角色和权限
        Set<String> permissions = permService.getPerms(userName);
        Set<String> roles = roleService.getRoles(userName);
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        //把通过service获取到的角色和权限放进去
        s.setStringPermissions(permissions);
        s.setRoles(roles);
        return s;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String name = token.getPrincipal().toString();
        User admin = userService.loginByName(name);
        if (admin == null){
           return null;
        }
        String passwordInDB = admin.getUser_password();
        String salt = admin.getSalt();
        return new SimpleAuthenticationInfo(name, passwordInDB, ByteSource.Util.bytes(salt), getName());
    }
}
