package com.merryyou.controller.api;

import com.merryyou.domain.User;
import com.merryyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 2015/9/24 0024.
 *
 * @author zhenglongfei
 * @since 1.0
 */
@RestController
@RequestMapping("/authUser")
public class AuthUserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list",method = RequestMethod.GET,produces={ "application/xml","application/json"})
    @ResponseBody
    public Object list() throws Exception{
        List<User> userList = userService.getUserList();
        System.out.print("*****************");
        return userList;
    }
}
