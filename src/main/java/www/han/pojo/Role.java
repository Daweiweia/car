package www.han.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *角色表
 * @author Mr.han
 * @date
 * @param
 * @return
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private int id;
    private String admin_id;
    private String role_name;
}
