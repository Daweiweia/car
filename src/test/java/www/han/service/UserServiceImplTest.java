package www.han.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import www.han.pojo.RoleToUser;
import www.han.pojo.User;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springContext.xml")
public class UserServiceImplTest extends TestCase {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @Test
    public void test() {
        List<RoleToUser> roleListLimit = roleService.getRoleListLimit(0, 2);
        System.out.println(roleListLimit);
    }
}