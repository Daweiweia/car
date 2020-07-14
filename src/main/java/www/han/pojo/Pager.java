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
public class Pager<T> {
    private int start = 0;//当前查询起始
    private int pageSize;//每页显示的数量
    private int pageCount;//总页面数
    private int currentPageNo;//当前页面
    private int count;//总数据条目
    private List<T> staffList;//查询的结果

   /* public void setStart(int start) {
        if (this.currentPageNo > this.count) {
            this.start = this.pageCount;
        } else {
            this.start = (this.currentPageNo - 1) * this.pageSize;
        }
    }
    public void setPageCount() {
        if (this.count % this.pageSize == 0) {
            this.pageCount = this.count / this.pageSize;
        } else {
            this.pageCount = this.count / this.pageSize + 1;
        }
    }*/
}
