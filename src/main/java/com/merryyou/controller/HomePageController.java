package com.merryyou.controller;

import com.merryyou.domain.User;
import com.merryyou.service.UserService;
import net.minidev.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomePageController {

    private static final Logger logger =
            LoggerFactory.getLogger(HomePageController.class);
    @Autowired
    UserService userService;

    @RequestMapping("/register1")
    public ModelAndView registerUser(@ModelAttribute User user) {

        List<String> genderList = new ArrayList<String>();
        genderList.add("male");
        genderList.add("female");

        List<String> cityList = new ArrayList<String>();
        cityList.add("delhi");
        cityList.add("gurgaon");
        cityList.add("meerut");
        cityList.add("noida");

        Map<String, List> map = new HashMap<String, List>();
        map.put("genderList", genderList);
        map.put("cityList", cityList);
        return new ModelAndView("register", "map", map);
    }

    @RequestMapping("/insert")
    public String inserData(@ModelAttribute User user) {
        if (user != null)
            userService.insertData(user);
        return "redirect:/getList";
    }

    @RequestMapping("/getList")
    public ModelAndView getUserLIst() {
        logger.info("welcom() is executed, value{}", "mkyong");
        logger.info("hello world");
        logger.error("ERROR");
        List<User> userList = userService.getUserList();
        return new ModelAndView("userList", "userList", userList);
    }

    @RequestMapping("/edit")
    public ModelAndView editUser(@RequestParam String id,
                                 @ModelAttribute User user) {

        user = userService.getUser(id);

        List<String> genderList = new ArrayList<String>();
        genderList.add("male");
        genderList.add("female");

        List<String> cityList = new ArrayList<String>();
        cityList.add("delhi");
        cityList.add("gurgaon");
        cityList.add("meerut");
        cityList.add("noida");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("genderList", genderList);
        map.put("cityList", cityList);
        map.put("user", user);

        return new ModelAndView("edit", "map", map);

    }

    @RequestMapping("/update")
    public String updateUser(@ModelAttribute User user) {
        userService.updateData(user);
        return "redirect:/getList";

    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam String id) {
        userService.deleteData(id);
        return "redirect:/getList";
    }
    @RequestMapping("/list")
    public void list(HttpServletResponse response) throws Exception{
        List<User> userList = userService.getUserList();
        response.getWriter().write(JSONArray.toJSONString(userList));
    }
}