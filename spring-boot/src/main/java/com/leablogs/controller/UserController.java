package com.leablogs.controller;

import javax.annotation.Resource;

import com.leablogs.user.entity.Users;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*")
@Log4j2
public class UserController {
//	@Autowired
//	RestTemplate restTemplate;
//	@Autowired
//	private Environment environment;

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public String getUserList(String param) {
        return "aaaaa";
    }

    @RequestMapping(value = "/getUsersConver", method = RequestMethod.GET)
    public Users coverterUser(@RequestParam(value = "userlist", required = true, defaultValue = "") Users userList) {
        return userList;
    }
}
