package com.zufe.oams.controller;

import com.zufe.oams.dto.Response;
import com.zufe.oams.dto.User;
import com.zufe.oams.service.LoginService;
import com.zufe.oams.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LoginController {
    @Autowired(required = false)
    private LoginService loginService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    /*public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String id = requestUser.getId();
        id = HtmlUtils.htmlEscape(id);
        if (!Objects.equals("admin", id) || !Objects.equals("123456", requestUser.getPassword())) {
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        } else {
            return new Result(200);
        }
    }*/
    public Response login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String id = requestUser.getId();
        id = HtmlUtils.htmlEscape(id);
        String password = requestUser.getPassword();
        User user = loginService.login(id, password);
        System.out.println(ResponseUtil.success(user));
        return ResponseUtil.success(user);
    }
}
