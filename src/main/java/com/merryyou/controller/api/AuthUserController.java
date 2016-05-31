package com.merryyou.controller.api;

import com.merryyou.domain.User;
import com.merryyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map list() throws Exception{
        Map map=new HashMap<>();
        List<User> userList = userService.getUserList();
        map.put("data",userList);
        return map;
    }
}
