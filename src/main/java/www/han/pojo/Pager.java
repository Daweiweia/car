package www.han.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author M.han
 * 分页字段
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pager {
    private int pageStart;//当前查询起始
    private int pageSize;//每页显示的数量
    private int count;//总数据条目
    private List<Staff> staffList;//查询的结果
}
