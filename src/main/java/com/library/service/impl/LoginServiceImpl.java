package com.library.service.impl;

import com.library.dao.UserDao;
import com.library.domain.User;
import com.library.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;
    public int loginService(String username,String password,Integer permission){
        User user=userDao.selectUser(username,password,permission);
        if(user!=null){
            return 1;
        }else{
            return 0;
        }
    }

}
