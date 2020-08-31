package net.evecom.shiro;

import cn.hutool.core.bean.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import net.evecom.entity.MyUser;
import net.evecom.service.MyUserService;
import net.evecom.util.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 验证核心
 */
@Slf4j
@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    MyUserService myUserService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        JwtToken jwtToken = (JwtToken) token;

        String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();

        MyUser myUser = myUserService.getById(Long.valueOf(userId));
        if (myUser == null) {
            throw new UnknownAccountException("账户不存在");
        }

        if (myUser.getCondis().equals("locked")) {
            throw new LockedAccountException("账户已被锁定");
        }

        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(myUser, profile);

        return new SimpleAuthenticationInfo(profile, jwtToken.getCredentials(), getName());
    }

}
