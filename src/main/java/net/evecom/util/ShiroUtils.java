package net.evecom.util;

import cn.hutool.core.lang.Assert;
import net.evecom.entity.MyUser;
import net.evecom.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;
import java.time.LocalDateTime;

/**
 * 验证类
 */
public class ShiroUtils {

    /*https://bbs.3dmgame.com/thread-5978938-1-1.html*/
    /*public static AccountProfile getProfile() {
        *//**空指针异常*//*
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }*/


    public static void inits(MyUser user){
        if(user.getCreated()==null){
            user.setCreated(LocalDateTime.now());
            user.setLastLogin(LocalDateTime.now());
        }

    }

}
