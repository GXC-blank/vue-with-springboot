package net.evecom.util;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import net.evecom.common.dto.LoginDto;
import net.evecom.common.lang.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class CUtils {

    @Autowired
    JwtUtils jwtUtils;

    public  Result skc(String password, Long id, String account, String username,
                       LoginDto loginDto, HttpServletResponse response, String authority, String avatar) {
        if (!(SecureUtil.md5(password)).equals(SecureUtil.md5(loginDto.getPassword()))) {
            return Result.fail("密码不正确");
        }
        String jwt = jwtUtils.generateToken(id);

        response.setHeader("Authorization", jwt);
        response.setHeader("Access-control-Expose-Headers", "Authorization");

        return Result.svc(MapUtil.builder()
                .put("id", id)
                .put("account", account)
                .put("username", username)
                .put("authority", authority)
                .put("avatar", avatar)
                .map()
        );
    }
}
