package www.han.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import www.han.pojo.User;
import www.han.service.RoleService;
import www.han.service.UserService;
import www.han.util.ShiroUtil;

import java.util.Random;

/**
 * @author M.han
 * @version V1.0
 * @ClassName:
 * @Description: (用一句话描述该文件做什么)
 * @Date 2020/6/27 21:58
 */
@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;
    /**
        *功能描述
        * @author Mr.han
        * @date
        * @param
        * @return
       */
    @RequestMapping(value="/login.do",method = RequestMethod.POST)
//    @ResponseBody
    public String loginControl(String username, String password,  Model model){
        System.out.println(username +":" +password);
        //获取当前用户,shiro包下的
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        System.out.println(token.getUsername()+"-这是login.do：-"+token.getPassword());
        //执行登录方法
        try {
            subject.login(token);//执行登录，在用户认证的里面去认证用户名和密码
            Session session=subject.getSession();
            session.setAttribute("subject", subject);
            return "redirect:/router/toIndex";//上面登录通过了转到首页
        }catch (UnknownAccountException e){//用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){//密码不存在
            model.addAttribute("msg","密码错误啊");
            return "login";
        }
    }

    @RequestMapping(value = "/register.do",method = RequestMethod.POST)
    public String register(String user_id,String user_name,String user_password,String user_phone,Model model){
        User user = new User();
        user.setUser_id(Integer.parseInt(user_id));
        user.setUser_name(user_name);
        user.setUser_password(user_password);
        user.setUser_phone(user_phone);

        String salt = new Random().nextInt(1000000)+"";
        user.setSalt(salt);
        String encryptPassword = ShiroUtil.encryptPassword(user.getUser_password(), user.getSalt());
        user.setUser_password(encryptPassword);
        System.out.println("处理后的user数据："+user);
        int register = userService.register(user);
        if (register > 0){
            //进行角色分配
            int i = roleService.addRole(user.getUser_id());
            if (i <= 0){
                model.addAttribute("msg","账号注册成功！角色分配失败，请联系管理要换进行权限分配！");
                System.out.println("角色分配失败！请手动进行分配！");
            }
            model.addAttribute("msg","注册成功！");
            return "login";
        }else{
            return "login";
        }
    }
}
