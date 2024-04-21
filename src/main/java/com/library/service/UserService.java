package com.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.library.domain.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserService extends IService<User> {

    //  借书功能实现
    @Transactional
    public void borrowBook(int book_id, int user_id);


}
