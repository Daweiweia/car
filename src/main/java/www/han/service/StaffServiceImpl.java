package www.han.service;

import netscape.security.UserTarget;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import www.han.mapper.StaffMapper;
import www.han.pojo.Staff;

import java.util.HashMap;
import java.util.List;

/**
 * @author M.han
 * @version V1.0
 * @ClassName:
 * @Description: (用一句话描述该文件做什么)
 * @Date 2020/7/1 14:47
 */
//@Service
public class StaffServiceImpl implements StaffService {
    private StaffMapper staffMapper;

    public void setStaffMapper(StaffMapper staffMapper) {
        this.staffMapper = staffMapper;
    }

    public List<Staff> staffList() {
        return staffMapper.staffList();
    }

    public List<Staff> staffListLimit(@Param("start") int start,@Param("pageSize") int pageSize) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("pageStart",start);
        map.put("pageSize",pageSize);
        return staffMapper.staffListLimit(map);
    }

    public int getCount() {
        return staffMapper.getCount();
    }


}