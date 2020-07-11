package www.han.service;

import www.han.pojo.Staff;

import java.util.List;

/**
 * @author M.han
 * @version V1.0
 * @ClassName:
 * @Description: (用一句话描述该文件做什么)
 * @Date 2020/7/1 14:46
 */
public interface StaffService {
    /**
     全部员工数量
     */
    List<Staff> staffList();
    /**
     分页查询员工数量
     */
    List<Staff> staffListLimit(int start,int pageSize);
    /**
     获取总数据条数
     */
    int getCount();
    /**
     删除员工
     */
    int delStaff(int staffId);

    /**
     更新员工信息
     */
    int updateStaff(Staff staff);

    /**
     获取部门名称
     */
    List<String> getDepartment();
    /**
        增加员工
     */
    int addStaff(Staff staff);
    /**

     */

    /**

     */

    /**

     */

    /**

     */
}
