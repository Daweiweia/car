package www.han.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
    *权限表
    * @author Mr.han
    * @date
    * @param
    * @return
   */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Perm {
    private int id;
    private int role_id;
    private String perms;
    private String url;
}
