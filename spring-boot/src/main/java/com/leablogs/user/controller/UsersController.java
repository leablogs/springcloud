package com.leablogs.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leablogs.user.entity.Users;
import com.leablogs.user.entity.UsersExt;
import com.leablogs.user.service.IUsersExtService;
import com.leablogs.user.service.IUsersService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author shilh
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/user/users")
@Log4j2
public class UsersController {
    @Autowired
    private IUsersService usersService;
    @Autowired
    private IUsersExtService iUsersExtService;

    @RequestMapping(value = "/getListUser", method = RequestMethod.GET)
    public IPage<Users> getListUser(@RequestParam("page") long page, @RequestParam("pageSize") long pageSize, @RequestParam("sex") Short sex) {
        List<Users> userList = new ArrayList<>();
        IPage<Users> usersIPage = (IPage<Users>) usersService.getListUser(new Page<>(page, pageSize), sex);
        usersIPage.getRecords().forEach(System.out::println);
//        QueryWrapper<Users> queryWrapper = new QueryWrapper();
//        queryWrapper.eq("sex", sex);
//        usersService.pageByGender(new Page<>(1, 2), queryWrapper);
//        usersIPage.getRecords().forEach(System.out::println);

//        userList = usersService.getListUser();
        return usersIPage;
    }

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public Users getUserById(@RequestParam("id") Integer user_id) {
        Users usersIPage = usersService.getUserById(user_id);
        return usersIPage;
    }

    @RequestMapping(value = "/saveUser/name/{user_name}/id/{user_id}", method = RequestMethod.POST,
            headers = {"cookie", "token"})
    public boolean saveUsers(@PathVariable(value = "user_name", required = true) String name,
                             @PathVariable(value = "user_id", required = true) String user_id,
                             @RequestParam(value = "id", defaultValue = "0", required = false) int id,
                             @RequestBody(required = false) Users users,
                             @RequestHeader(value = "cookie", required = false, defaultValue = "") String cookie,
                             @RequestHeader Map<String, String> headers) {
        log.info("head:[{}]", cookie);
        log.info("heads:[{}]", headers.toString());
        log.info("user_id:[{}]", user_id);
        log.info("id:[{}]", id);
        log.info("username:[{}]", name);
        log.info("body:[{}]", users.toString());
        boolean b = false;
//        b = usersService.save(users);
        return b;
    }

    @RequestMapping(value = "/addusers", method = RequestMethod.POST)
    public int insertUsers(@RequestBody(required = true) Users users) {
        log.info("users:[{}]", users);
        int result = usersService.addUser(users);
        return result;
    }

    @RequestMapping(value = "/saveBatchUsers", method = RequestMethod.POST)
    public boolean saveBatchUsers(@RequestBody List<Users> usersList) {
        long start = System.currentTimeMillis();
//        List<Users> usersList = new ArrayList<>();
//        for (int i = 0; i < 12; i++) {
//            Users users = new Users();
//            users.setUserName("hanmm" + i);
//            users.setPassword("123456");
//            users.setSex((short) 0);
//            LocalDate localDate = LocalDate.parse("2000-08-21");
//            users.setBrithday(localDate);
//            usersList.add(users);
//        }


        boolean b;
        b = usersService.saveBatch(usersList);
        log.info("插入[{}]条数据耗时：【{}】", usersList.size(), System.currentTimeMillis() - start);
        return b;
    }
}