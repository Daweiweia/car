package www.han.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *管理员对应的角色表
 * @author Mr.han
 * @date
 * @param
 * @return
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    private int id;
    private String user_id;
    private int role_id;
}
