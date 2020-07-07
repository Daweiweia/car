package www.han.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import www.han.pojo.Staff;

import java.util.List;
import java.util.Map;

/**
 * @author M.han
 * @version V1.0
 * @ClassName:
 * @Description: (用一句话描述该文件做什么)
 * @Date 2020/7/1 14:25
 */

public interface StaffMapper {
    /**
     * 查询所有员工信息
     */
    List<Staff> staffList();
//   @Select("select * from staff limit #{startPage},#{pageSize}")
    /**
     *分页查询
     */
    List<Staff> staffListLimit(Map<String, Integer> map);
    /**
     *获取总数据条数
     */
    int getCount();
    /**

     */
    /**

     */
    /**

     */
}
