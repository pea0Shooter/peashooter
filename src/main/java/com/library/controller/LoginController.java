package com.library.controller;

import com.library.common.R;
import com.library.dao.UserDao;
import com.library.domain.Login;
import com.library.domain.User;
import com.library.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserDao userDao;

    @RequestMapping("/login")
    @ResponseBody
    public R<User> loginService(HttpServletRequest request, @RequestBody Login login) {
        request.getSession().setAttribute("user", login.getUserName());
        User user = userDao.selectByUsername(login.getUserName());
        int i = loginService.loginService(login.getUserName(), login.getPassWord(), login.getPermission());
        return R.success(user);

    }
}
