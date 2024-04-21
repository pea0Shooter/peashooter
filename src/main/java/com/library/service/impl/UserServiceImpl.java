package com.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.library.dao.BookDao;
import com.library.dao.BorrowDao;
import com.library.dao.UserDao;
import com.library.domain.User;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User>  implements UserService {

    @Autowired
    private BorrowDao borrowDao;
    @Autowired
    private BookDao bookDao;
    @Override
    public void borrowBook(int book_id,int user_id) {
        bookDao.updateContById(book_id);
        borrowDao.addBorrow(book_id,user_id);
    }



}
