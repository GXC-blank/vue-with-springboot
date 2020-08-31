package net.evecom.service.impl;

import net.evecom.entity.Blog;
import net.evecom.mapper.BlogMapper;
import net.evecom.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gc
 * @since 2020-08-14
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
