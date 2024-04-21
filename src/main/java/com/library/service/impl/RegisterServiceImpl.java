package com.library.service.impl;

import com.library.dao.UserDao;
import com.library.domain.Register;
import com.library.domain.User;
import com.library.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserDao userDao;
    @Override
    public int RegisterService(Register register){
        String username = register.getUsername();
        String pass = register.getPassword();
        User u=userDao.selectByUsername(username);
        if(u==null){
            userDao.addUser(username,pass);
            return 1;
        }else{
            return 0;
        }

    }
}
