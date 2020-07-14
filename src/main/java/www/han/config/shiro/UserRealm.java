package www.han.config.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
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
import org.springframework.context.annotation.Bean;
import www.han.pojo.User;
import www.han.service.PermService;
import www.han.service.RoleService;
import www.han.service.UserService;

import java.util.Set;

//自定义Realm
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
        //账号已经通过验证了
        String userName =(String) principalCollection.getPrimaryPrincipal();
        System.out.println("授权中得到的userName："+userName);
        //通过service获取角色和权限
        Set<String> permissions = permService.getPerms(userName);
     /*   for (String permission : permissions) {
            System.out.println("permissons---"+permission);
        }*/
        Set<String> roles = roleService.getRoles(userName);
        //授权对象
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        //把通过service获取到的角色和权限放进去
        s.setStringPermissions(permissions);
        s.setRoles(roles);
        return s;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了认证+===》doGetAuthenticationInfo");
        // 获取名字
        String name = token.getPrincipal().toString();
        System.out.println(name);

        // 获取user
        User admin = userService.loginByName(name);
        if (admin == null){
           return null;
        }
        String passwordInDB = admin.getUser_password();
        String salt = admin.getSalt();
        System.out.println("salt----"+salt);

        // 返回
        return new SimpleAuthenticationInfo(name, passwordInDB, ByteSource.Util.bytes(salt), getName());
        // getName()是realm的继承方法，返回当前类名DatabaseRealm
        // 通过applicationContext-shiro.xml中的HashedCredentialsMatcher，进行密码的自动校验
    }



}
