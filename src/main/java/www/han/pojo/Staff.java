package www.han.pojo;

import javafx.scene.input.DataFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author M.han
 * @version V1.0
 * @ClassName:
 * @Description: (用一句话描述该文件做什么)
 * @Date 2020/7/1 14:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    private int staff_id;
    private String staff_bankCard;
    private String staff_idCard;
    private  String department_name;
    private String staff_name;
    private int staff_phone;
    private String staff_addr;
    private Date jointime;

}
