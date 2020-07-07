package www.han.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import www.han.service.StaffService;
import www.han.util.StaffJsonUtil;

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

    /**
        *员工信息修改
        * @author Mr.han
        * @date
        * @param
        * @return
       */

    /**
     * 分页显示数据
     */
    @RequestMapping("/staffList")
    @ResponseBody
    public String getStaffList(@RequestParam("currentPageNo") int currentPageNo,
                               @RequestParam("pageSize") int pageSize) throws JsonProcessingException {
        int start = 0;//查询开始位置
        int pageCount;//总页面数
//        System.out.println(currentPageNo + "--" + pageSize);
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

//        System.out.println(count);
        StaffJsonUtil staffJson = new StaffJsonUtil();
        staffJson.setCode(0);
        staffJson.setCount(count);
        staffJson.setMsg("");
        staffJson.setData(staffService.staffListLimit(start,pageSize));

        String staffs = new ObjectMapper().writeValueAsString(staffJson);
//        System.out.println(staffs);
        return staffs;
    }
}
