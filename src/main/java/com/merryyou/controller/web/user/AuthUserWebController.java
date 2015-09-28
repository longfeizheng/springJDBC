package com.merryyou.controller.web.user;

import com.merryyou.domain.User;
import com.merryyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2015/9/22 0022.
 *
 * @author zhenglongfei
 * @since 1.0
 */
@RestController
@RequestMapping("/authUser")
public class AuthUserWebController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user",method = RequestMethod.GET,produces={"application/xml", "application/json"})
    public User test(){
        User user=new User();
        user.setFirstName("admin");
        user.setLastName("admin");
        user.setCity("beijing");
        return user;
    }
}
