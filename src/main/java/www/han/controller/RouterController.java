package www.han.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 页面跳转
 *
 * @param
 * @author Mr.han
 * @date
 * @return
 */
@Controller
@RequestMapping("/router")
public class RouterController {
 /*   @RequestMapping("/toIndex")
    public String toIndex(){
        return "index";
    }*/
    @RequestMapping("/toMain")
    public String toMain() {
        return "main";
    }

    /**
     *功能描述:跳转到staff信息页面
     * @author qqg
     * @date
     * @param
     * @return
     */
    @RequestMapping("/toStaff")
    public String toStaffPage() {
        System.out.println("进来了toStaff");
        return "staff";
    }

    @RequestMapping("/toStat")
    public String toStatistics() {
        return "statistic";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

/*    @RequestMapping("/logout")
    public String logout() {
        return "redirect:/login.html";
    }*/

    @RequestMapping("/nopower")
    @ResponseBody
    public String noauth() {
        return "没有权限进入";
    }

    //跳转权限管理页面
    @RequestMapping("/toAuthority")
    public String toAuthority() {
        return "authority";
    }

    //跳转系统理页面
    @RequestMapping("/toSys")
    public String toSys() {
        return "sysinfo";
    }

    //跳转车辆信息页面
    @RequestMapping("/toCar")
    public String toCarInfo() {
        return "car";
    }

    //跳转售后页面
    @RequestMapping("/toAfterSale")
    public String toAfterSale() {
        return "aftersale";
    }

    //跳转售后页面
    @RequestMapping("/toManufacturer")
    public String toManufacturer() {
        return "manufacturer";
    }

    //跳转客户面
    @RequestMapping("/toClient")
    public String toClient() {
        return "client";
    }

    //跳销售信息户页面
    @RequestMapping("/toSale")
    public String toSale() {
        return "sale";
    }

    //跳转销售部门页面
    @RequestMapping("/toDepartmentSale")
    public String toDepartmentSale() {
        return "department-sale";
    }

    //跳转维修部门页面
    @RequestMapping("/toDepartmentRepair")
    public String toDepartmentRepair() {
        return "department-repair";
    }
}
