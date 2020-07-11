package www.han.util;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

public class ShiroUtil {
    public static String encryptPassword(String password, String salt) {
        // 在这里更改密码规则后还要在applicationContext-shiro.xml中改密码匹配器
        return new SimpleHash("md5", password, salt, 1).toString();
    }

    public static String generateSalt() {
        return new SecureRandomNumberGenerator().nextBytes().toString();
    }

}
