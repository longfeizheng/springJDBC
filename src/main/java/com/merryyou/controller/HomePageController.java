package com.merryyou.controller;

import com.google.gson.Gson;
import com.merryyou.domain.User;
import com.merryyou.service.UserService;
import net.minidev.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public ModelAndView inserData(@ModelAttribute User user) {
        if (user != null)
            userService.insertData(user);
        return new ModelAndView("redirect:/getList");
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
    public ModelAndView updateUser(@ModelAttribute User user) {
        System.out.println(user.toString());
        Date date = new Date(user.getStartDate().split(",")[0]);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sd.format(date));
//        userService.updateData(user);
        return new ModelAndView("redirect:/getList");

    }

    @RequestMapping(value = "/updatetest" ,method = RequestMethod.POST)
    public String updateUsertest(@RequestBody User user) {
        System.out.println(user.toString());
        System.out.println(user.getRangeTime()[0]);
        Date date = new Date(user.getStartDate().split(",")[0]);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sd.format(date));
        System.out.println(new Gson().toJson(user));
//        userService.updateData(user);
        return null;

    }

    @RequestMapping("/delete")
    public ModelAndView deleteUser(@RequestParam String id) {
        userService.deleteData(id);
        return new ModelAndView("redirect:/getList");
    }
    @RequestMapping("/list")
    public void list(HttpServletResponse response) throws Exception{
        List<User> userList = userService.getUserList();
        response.getWriter().write(JSONArray.toJSONString(userList));
    }
}