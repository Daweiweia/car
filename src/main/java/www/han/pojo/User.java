package www.han.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    *管理员
    * @author Mr.han
    * @date
    * @param
    * @return
   */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int user_id;
    private String User_name;
    private String user_password;
    private String user_phone;
    private String salt;
}
