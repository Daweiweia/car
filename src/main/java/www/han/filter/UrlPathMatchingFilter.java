package www.han.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import www.han.service.PermService;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Set;

public class UrlPathMatchingFilter extends PathMatchingFilter {
    @Autowired
     PermService permService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        System.out.println("进来了PathMatchingFilter");
        String requestUrl = getPathWithinApplication(request);
        System.out.println("PathMatchingFilter---"+requestUrl);
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()){
            // 未登录
            WebUtils.issueRedirect(request,response,"/router/toLogin");
            return false;
        }
        System.out.println("permService-----"+permService);
        boolean needInterceptor = permService.needInterceptor(requestUrl);
        System.out.println("是否需要权限验证："+needInterceptor);

        if(!needInterceptor){
            // 数据库里存放的所有URL都是需要相关权限的, 一个requestURL进来, 如果数据库里不含有该url,说明这是一个不需要权限的url, 直接放行

            return true;
        }else{
            boolean hasPermission = false;
            String userName = subject.getPrincipal().toString();
            Set<String> permissionUrls = permService.getUrl(userName);
            for(String url:permissionUrls){
                if(requestUrl.equals(url)){
                    hasPermission = true;
                }
            }
            if(hasPermission){
                return true;
            }else{
                UnauthorizedException e =  new UnauthorizedException("当前用户没有访问"+requestUrl+"的权限");
                subject.getSession().setAttribute("e",e);
                WebUtils.issueRedirect(request,response,"/router/nopower");
                return false;
            }
        }
    }

}
