package www.han.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import www.han.pojo.Staff;
import www.han.service.StaffService;
import www.han.util.JsonUtil;

import java.util.List;

/**
 * @author M.han
 * @version V1.0
 * @ClassName:
 * @Description: 员工controller
 * @Date 2020/6/28 21:44
 */
@Controller
@RequestMapping("/staff")
@Api("员工模块")
public class StaffController {
    @Autowired
    StaffService staffService;

    /**
     * 员工信息修改
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("修改员工信息")
    public String staffUpdate(@ApiParam("员工信息json") String staffStr) throws JsonProcessingException {
        System.out.println("------------------进来了staffUpdate哦-----------------------------");
        Staff staff = new ObjectMapper().readValue(staffStr, Staff.class);
        int i = staffService.updateStaff(staff);
        if (i > 0) {
            return "success";
        } else {
            return "fail";
        }
    }

    /**
     * 分页显示数据
     */
    @GetMapping("/staffList")
    @ResponseBody
    @ApiOperation("员工信息")
    public String getStaffList(@RequestParam("currentPageNo") int currentPageNo,
                               @RequestParam("pageSize") int pageSize) throws JsonProcessingException {
        int start = 0;//查询开始位置
        int pageCount;//总页面数
        int count = staffService.getCount();//数据总行数

        if (count % pageSize == 0) {
            pageCount = count / pageSize;
        } else {
            pageCount = count / pageSize + 1;
        }
        if (currentPageNo > pageCount) {
            start = pageCount;
        } else {
            start = (currentPageNo - 1) * pageSize;
        }
        JsonUtil staffJson = new JsonUtil<Staff>();
        staffJson.setCode(0);
        staffJson.setCount(count);
        staffJson.setMsg("");
        staffJson.setData(staffService.staffListLimit(start, pageSize));

        String staffs = new ObjectMapper().writeValueAsString(staffJson);
        return staffs;
    }

    /**
     * 删除一条员工信息
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("删除一条员工信息")
    public String staffDel(int staffId) {
        int del = staffService.delStaff(staffId);
        if (del > 0) {
            return "success";
        } else {
            return "fail";
        }
    }

    @PostMapping("/getDepartment")
    @ResponseBody
    @ApiOperation("获取部门信息")
    public String getDepartment() throws JsonProcessingException {
        List<String> department = staffService.getDepartment();
        String s = new ObjectMapper().writeValueAsString(department);
        return s;
    }

    @PostMapping("/add")
    @ResponseBody
    @ApiOperation("增加员工")
    public String addStaff(String staffStr) throws JsonProcessingException {
        Staff staff = new ObjectMapper().readValue(staffStr, Staff.class);
        String isExit = staffService.selectById(staff.getStaff_id());
        if (isExit != null) {
            return "fail";
        } else {
            int i = staffService.addStaff(staff);
            System.out.println("增加结果：" + i);
            if (i > 0) {
                return "success";
            } else {
                return "fail";
            }
        }
    }
}
