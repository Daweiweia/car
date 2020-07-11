package www.han.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import www.han.pojo.Staff;
import www.han.service.StaffService;
import www.han.util.StaffJsonUtil;

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
public class StaffController {
    @Autowired
    StaffService staffService;

    /**
        *员工信息修改
        * @author Mr.han
        * @date
        * @param
        * @return
       */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public String staffUpdate(String staffStr) throws JsonProcessingException {
        System.out.println("------------------进来了staffUpdate哦-----------------------------");
        Staff staff =   new ObjectMapper().readValue(staffStr, Staff.class);
        int i = staffService.updateStaff(staff);
        if (i > 0){
            return "success";
        }else {
            return "fail";
        }
    }

    /**
     * 分页显示数据
     */
    @RequestMapping("/staffList")
    @ResponseBody
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
        if (currentPageNo > pageCount){
            start = pageCount;
        }else {
            start = (currentPageNo-1)*pageSize;
        }

        StaffJsonUtil staffJson = new StaffJsonUtil();
        staffJson.setCode(0);
        staffJson.setCount(count);
        staffJson.setMsg("");
        staffJson.setData(staffService.staffListLimit(start,pageSize));

        String staffs = new ObjectMapper().writeValueAsString(staffJson);
//        System.out.println(staffs);
        return staffs;
    }
    /**
        删除一条员工信息
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public String staffDel(int staffId){
        System.out.println("delete得到的数据："+staffId);
        int del = staffService.delStaff(staffId);
        if (del > 0){
            return "success";
        }else{
            return "fail";
        }


    }

    @RequestMapping("/getDepartment")
    @ResponseBody
    public String getDepartment() throws JsonProcessingException {
        List<String> department = staffService.getDepartment();
        String s = new ObjectMapper().writeValueAsString(department);
        System.out.println("得到的部门名称"+s);
        return s;
    }
    @RequestMapping("/add")
    @ResponseBody
    public String addStaff(String staffStr) throws JsonProcessingException {
        Staff staff = new ObjectMapper().readValue(staffStr, Staff.class);
        System.out.println(staff);
        int i = staffService.addStaff(staff);
        if (i > 0){
            return "success";
        }else{
            return "fail";
        }
    }
}
