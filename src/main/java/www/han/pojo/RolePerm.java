package www.han.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *角色权限表
 * @author Mr.han
 * @date
 * @param
 * @return
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePerm {
    private int id;
    private int role_id;
    private int perm_id;
}
