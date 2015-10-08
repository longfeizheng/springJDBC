package com.merryyou.controller;

import com.merryyou.domain.AuthUser;
import com.merryyou.service.UserService;
import com.merryyou.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2015/9/22 0022.
 *
 * @author zhenglongfei
 * @since 1.0
 */
@Controller
public class LoginWebController {

    private static final Logger logger =
            LoggerFactory.getLogger(LoginWebController.class);

    @Autowired
    UserService userService;

    /**
     * Inti model and view.
     *
     * @param request the request
     * @return the model and view
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView init(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        //通过session中获取当前登录的用户
        AuthUser authUser = (AuthUser) request.getSession().getAttribute(SessionUtil.KEY_AUTH_INFO);
        if (ObjectUtils.isEmpty(authUser)) {
            //如果为空，表示当前没有登录用户，跳转到登录界面
            mav.setViewName("main/login");
            logger.info("welecome main page");
        } else {
            //如果不为空，则直接跳转到主界面
            mav.setViewName("main/main");
            logger.info("welecome login page");
        }
        return mav;
    }

    /**
     * Register model and view.
     *
     * @return the model and view
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("main/register");
        return mav;
    }

    /**
     * Register model and view.
     *
     * @return the model and view
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("main/main");
        return mav;
    }
}
