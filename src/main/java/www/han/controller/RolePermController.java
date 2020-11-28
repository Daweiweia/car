package www.han.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import www.han.pojo.RoleToUser;
import www.han.service.RoleService;
import www.han.util.JsonUtil;

/**
 * 角色控制
 */
@Controller
@RequestMapping("/role")
@Api("角色控制模块")
public class RolePermController {
    @Autowired
    RoleService roleService;

    /**
     * 得到角色列表信息
     */
    @GetMapping(value = "/roleList")
    @ResponseBody
    @ApiOperation("获取角色列表")

    public String getRoleList(@RequestParam("currentPageNo") int currentPageNo,
                              @RequestParam("pageSize") int pageSize) throws JsonProcessingException {
        int start = 0;//查询开始位置
        int pageCount;//总页面数
        int count = roleService.getRoleSize();

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
        String RoleUserList = new ObjectMapper().writeValueAsString(roleJson);
        return RoleUserList;
    }

    @PostMapping("/changePerm")
    @ResponseBody
    @ApiOperation("修改角色")
    public String changePerm(@ApiParam("用户id") @Param("user_id") String user_id, @ApiParam("角色id") @Param("role_id") String role_id) throws JsonProcessingException {
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
