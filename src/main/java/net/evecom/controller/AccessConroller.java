package net.evecom.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.evecom.common.dto.LoginDto;
import net.evecom.common.lang.Result;
import net.evecom.entity.MyAdmin;
import net.evecom.entity.MyUser;
import net.evecom.service.MyAdminService;
import net.evecom.service.MyUserService;
import net.evecom.util.CUtils;
import net.evecom.util.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AccessConroller {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    CUtils cUtils;

    @Autowired
    MyAdminService myAdminService;

    @Autowired
    MyUserService myUserService;

    /**
     * 管理员登录
     * @param loginDto
     * @param response
     * @return
     */
    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response) {

        if (loginDto.getUsertype().equals("admin")) {
            MyAdmin myAdmin = myAdminService.getOne(new QueryWrapper<MyAdmin>().eq("account", loginDto.getAccount()));
            Assert.notNull(myAdmin, "该管理员不存在");

            return cUtils.skc(myAdmin.getPassword(), myAdmin.getId(), myAdmin.getAccount(),
                    myAdmin.getUsername(), loginDto, response,"admin", myAdmin.getAvatar());

            }
        if (loginDto.getUsertype().equals("user")) {
            MyUser myUser = myUserService.getOne(new QueryWrapper<MyUser>().eq("account", loginDto.getAccount()));
            Assert.notNull(myUser, "用户不存在");

            return cUtils.skc(myUser.getPassword(), myUser.getId(), myUser.getAccount(),
                    myUser.getUsername(), loginDto, response,"user", myUser.getAvatar());
        }
        return Result.fail("无用户类型");
    }

    /**
     * 退出登录
     * @return
     */
    /*@RequiresAuthentication*/
    @GetMapping("/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.svc(null);
    }
}
