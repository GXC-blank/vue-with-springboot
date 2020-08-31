package net.evecom.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.evecom.common.lang.Result;
import net.evecom.entity.MyAdmin;
import net.evecom.entity.MyUser;
import net.evecom.service.MyUserService;
import net.evecom.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gc
 * @since 2020-08-11
 */
@RestController
@RequestMapping("/my-user")
public class MyUserController {

    @Autowired
    MyUserService myUserService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public MyUser test(@PathVariable("id")Long id){
        return myUserService.getById(id);
    }

    /**
     * 注册用户
     * @param myUser
     */
    @PostMapping("sign-in")
    public void signin(@Validated @RequestBody MyUser myUser){
        try {
        ShiroUtils.inits(myUser);
        myUserService.save(myUser);
        }catch (Exception e){
            Result.fail(499,"账号重复","Dulicate");
        }
    }

    /**
     * 更新用户
     * @param myUser
     */
    @PostMapping("update")
    public void update(@Validated @RequestBody MyUser myUser){
        myUserService.saveOrUpdate(myUser);
    }

    /**
     * 删除用户
     * @param id
     */
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id")Long id){
        myUserService.removeById(id);
    }

    /**
     * 分页查询
     * @param currentPage
     * @return
     */
    @GetMapping("/many")
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage) {
        Page page = new Page(currentPage, 6);
        IPage pageData = myUserService.page(page, new QueryWrapper<MyUser>().orderByDesc("condis"));
        return Result.svc(pageData);
    }
}
