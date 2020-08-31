package net.evecom.service.impl;

import net.evecom.entity.MyUser;
import net.evecom.mapper.MyUserMapper;
import net.evecom.service.MyUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gc
 * @since 2020-08-11
 */
@Service
public class MyUserServiceImpl extends ServiceImpl<MyUserMapper, MyUser> implements MyUserService {

}
