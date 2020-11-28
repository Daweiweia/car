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

/***
 * url过滤
 */
public class UrlPathMatchingFilter extends PathMatchingFilter {
    @Autowired
    private PermService permService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String requestUrl = getPathWithinApplication(request);
        Subject subject = SecurityUtils.getSubject();

        if(!subject.isAuthenticated()){
            // 未登录
            WebUtils.issueRedirect(request,response,"/router/toLogin");
            return false;
        }
        boolean needInterceptor = permService.needInterceptor(requestUrl);

        if(!needInterceptor){
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
                UnauthorizedException e =  new UnauthorizedException("当前用户没有"+requestUrl+"权限");
                subject.getSession().setAttribute("e",e);
                WebUtils.issueRedirect(request,response,"/router/nopower");
                return false;
            }
        }
    }

}
