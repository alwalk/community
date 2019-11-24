package life.male.community.controller;

import life.male.community.pojo.User;
import life.male.community.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description: java类作用描述
 * @Author: zhangjiale
 * @CreateDate: 2019/8/31 0:39
 * @Version: 1.0
 */
@Controller
public class IndexController {

    Logger logger =  LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String hello(HttpServletRequest request) {
        logger.info("这是IndexController的---------info日志");
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    User user = userService.findByToken(cookie.getValue());
                    if (null != user) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        return "index";
    }
}
