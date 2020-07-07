package www.han.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import www.han.service.PermService;
import www.han.service.RoleService;
import www.han.service.StaffService;

import java.util.Set;


/**
 * @author M.han
 * @version V1.0
 * @ClassName:
 * @Description: (用一句话描述该文件做什么)
 * @Date 2020/7/1 14:30
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springContext.xml")
public class Test {
    @Autowired
    @Qualifier("staffServiceImpl")
    StaffService staffService;

    @Autowired
    RoleService roleService;
    @Autowired
    PermService permService;

    @org.junit.Test
   public void test() {
        Set<String> admin = permService.getPerms("admin");
        for (String adm:admin){
            System.out.println(adm);
        }
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
//        StaffMapper bean = context.getBean(StaffMapper.class);
//        bean.staffList();
//        StaffServiceImpl staffServiceImpl = new StaffServiceImpl();
//        System.out.println(staffService.staffList());
//        List<Staff> staff = staffService.staffList();
//        for (Staff staff1 : staff) {
//            System.out.println(staff1);
//        }
//        Admin admin = adminService.login("admin", "11111");
//        System.out.println(admin);

    }
}
