package www.han.config.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
//
//@Configuration
//public class ShiroConfig {
    //ShiroFilterFactoryBean
//    @Bean(name = "factoryBean")
//    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
//        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
//
//        //设置安全管理器
//        factoryBean.setSecurityManager(securityManager);
//        //实现拦截
//        Map<String,String> filterMap = new HashMap<String,String>();
//        filterMap.put("/staff/*","authc");//只有登录了才能访问这个请求
//
//        factoryBean.setFilterChainDefinitionMap(filterMap);
//
//        //登录请求，如果没有权限进入会自动挑战到这个请求
//        factoryBean.setLoginUrl("/toLogin");
//        return factoryBean;
//    }
//
//    //DefaultWebSecurityManager
//    @Bean(name = "securityManager")
//    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        //关联realm
//        securityManager.setRealm(userRealm);
//        return securityManager;
//    }
//    //创建realm对象，需要自定义
//    @Bean
//    public UserRealm userRealm(){
//        return new UserRealm();
//    }
    //注入shiroDialect：用来整合Thymeleaf-shiro
//    @Bean
//    public ShiroDialect shiroDialect(){
//        return new ShiroDialect();
//    }
//}
