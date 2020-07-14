package www.han.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import www.han.pojo.RoleToUser;
import www.han.service.RoleService;
import www.han.util.JsonUtil;

/**
 * 角色控制
 */
@Controller
@RequestMapping("/role")
public class RolePermController {
    @Autowired
    RoleService roleService;

    /**
     * 得到角色列表信息
     */
    @RequestMapping(value = "/roleList")
    @ResponseBody
    public String getRoleList(@RequestParam("currentPageNo") int currentPageNo,
                              @RequestParam("pageSize") int pageSize) throws JsonProcessingException {
//        Pager<RoleToUser> rolePager = new Pager<RoleToUser>();
        int start = 0;//查询开始位置
        int pageCount;//总页面数
        int count = roleService.getRoleSize();
        /*rolePager.setCount(roleService.getRoleSize());//数据总行数
        rolePager.setCurrentPageNo(currentPageNo);//当前页面
        rolePager.setPageSize(pageSize);//页面数据量大小*/

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
        JsonUtil roleJson = new JsonUtil<RoleToUser>();
        roleJson.setCode(0);
        roleJson.setCount(count);
        roleJson.setMsg("");
        roleJson.setData(roleService.getRoleListLimit(start, pageSize));
        System.out.println(roleJson);
        String RoleUserList = new ObjectMapper().writeValueAsString(roleJson);
        return RoleUserList;
    }

    @RequestMapping("/changePerm")
    @ResponseBody
    public String changePerm(@Param("user_id") String user_id, @Param("role_id") String role_id) throws JsonProcessingException {
        int userId = Integer.parseInt(user_id);
        int roleId = Integer.parseInt(role_id);

        int change = roleService.changeRole(userId, roleId);
        if (change > 0) {
            return "success";
        } else {
            return "fail";
        }

    }

}
