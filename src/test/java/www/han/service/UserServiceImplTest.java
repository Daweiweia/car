package www.han.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import www.han.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springContext.xml")
public class UserServiceImplTest extends TestCase {
    @Autowired
    UserService userService;

    @Test
    public void test() {
        User admin = userService.login("admin", "111111");
        System.out.println(admin);
    }
}