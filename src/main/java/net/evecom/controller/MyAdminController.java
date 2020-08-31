package net.evecom.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.evecom.common.lang.Result;
import net.evecom.entity.MyAdmin;
import net.evecom.service.MyAdminService;
import net.evecom.util.JwtUtils;
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
@RequestMapping("/my-admin")
public class MyAdminController {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    MyAdminService myAdminService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Result findone (@PathVariable("id")Long id){
        return Result.svc(myAdminService.getById(id));
    }

    /**
     * 注册用户
     * @param admin
     * @return
     */
    @PostMapping("sign-in")
    public Result signin(@Validated @RequestBody MyAdmin admin){
        try {
            myAdminService.save(admin);
        }catch (Exception e){
            return Result.fail(499,"账号重复","Dulicate");
        }
        return Result.svc(admin);
    }

    /**
     * 更新用户
     * @param admin
     */
    @PostMapping("update")
    public void update(@Validated @RequestBody MyAdmin admin){
        myAdminService.saveOrUpdate(admin);
    }

    /**
     * 根据Id删除用户
     * @param id
     */
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id")Long id){
        myAdminService.removeById(id);
    }

    /**
     * 分页查询
     * @param currentPage
     * @return
     */
    @GetMapping("/many")
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage) {
        Page page = new Page(currentPage, 6);
        IPage pageData = myAdminService.page(page, new QueryWrapper<MyAdmin>().orderByDesc("levels"));
        return Result.svc(pageData);
    }

        /*@RequiresAuthentication
    @PostMapping("/get-one")
    public Object testUser(@Validated @RequestBody MyAdmin admin) {
        return admin.toString();
    }*/

}
