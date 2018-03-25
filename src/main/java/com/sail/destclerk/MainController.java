package com.sail.destclerk;

import com.sail.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 控制器 博客出处：http://www.cnblogs.com/GoodHelper/
 *
 */
@Controller
public class MainController {
    @Resource
    private UserService userService;
    @RequestMapping("/")
    public String index(String account, Model model) {
        model.addAttribute("name", account);
        return "index";
    }

    @RequestMapping("/login")
    public @ResponseBody List<String> login() {
        List<String> list = userService.getPermissions(2L);
        return list;
    }

    @RequestMapping("/loginPost")
    public @ResponseBody
    Map<String, Object> loginPost(String account, String password, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        if (!"123456".equals(password)) {
            map.put("success", false);
            map.put("message", "密码错误");
            return map;
        }

        // 设置session

        map.put("success", true);
        map.put("message", "登录成功");
        return map;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        return "redirect:/login";
    }

}