package www.han.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import www.han.pojo.Staff;

import java.util.ArrayList;
import java.util.List;

/**
 * @author M.han
 * @version V1.0
 * @ClassName:
 * @Description: (用一句话描述该文件做什么)
 * @Date 2020/7/1 16:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffJsonUtil {
    private int code;
    private String msg;
    private int count;
    List<Staff> data;
}
