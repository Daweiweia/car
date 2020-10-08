package www.han.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
@Api("路由")
public class RouterController {
    @GetMapping("/toIndex")
    @ApiOperation("跳转首页")
    public String toIndex(){
        return "index";
    }
    @GetMapping("/toMain")
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
    @GetMapping("/toStaff")
    @ApiOperation("调准staff页面")
    public String toStaffPage() {
        System.out.println("进来了toStaff");
        return "staff";
    }

    @GetMapping("/toStat")
    @ApiOperation("统计页面")
    public String toStatistics() {
        return "statistic";
    }

    @GetMapping("/toLogin")
    @ApiOperation("跳转登录页面")
    public String toLogin() {
        return "login";
    }

/*    @RequestMapping("/logout")
    public String logout() {
        return "redirect:/login.html";
    }*/

    @GetMapping("/nopower")
    @ResponseBody
    @ApiOperation("无权限提示页面")
    public String noauth() {
        return "没有权限进入";
    }

    //跳转权限管理页面
    @GetMapping("/toAuthority")
    @ApiOperation("权限管理页面")
    public String toAuthority() {
        return "authority";
    }

    //跳转系统理页面
    @GetMapping("/toSys")
    @ApiOperation("跳转系统管理页面")
    public String toSys() {
        return "sysinfo";
    }

    //跳转车辆信息页面
    @GetMapping("/toCar")
    @ApiOperation("跳转车辆信息页面")
    public String toCarInfo() {
        return "car";
    }

    //跳转售后页面
    @GetMapping("/toAfterSale")
    @ApiOperation("跳转售后页面")
    public String toAfterSale() {
        return "aftersale";
    }

    //跳转售后页面
    @GetMapping("/toManufacturer")
    @ApiOperation("跳转厂商页面")
    public String toManufacturer() {
        return "manufacturer";
    }

    //跳转客户面
    @GetMapping("/toClient")
    @ApiOperation("跳转客户页面")
    public String toClient() {
        return "client";
    }

    //跳销售信息户页面
    @GetMapping("/toSale")
    @ApiOperation("跳转销售信息页面")
    public String toSale() {
        return "sale";
    }

    //跳转销售部门页面
    @GetMapping("/toDepartmentSale")
    @ApiOperation("跳转销售部门页面")
    public String toDepartmentSale() {
        return "department-sale";
    }

    //跳转维修部门页面
    @GetMapping("/toDepartmentRepair")
    @ApiOperation("跳转维修部门页面")
    public String toDepartmentRepair() {
        return "department-repair";
    }
}
