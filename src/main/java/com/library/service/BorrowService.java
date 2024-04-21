package com.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.library.domain.Borrow;
import org.springframework.transaction.annotation.Transactional;

public interface BorrowService extends IService<Borrow> {

//    借书记录储存
    public void addBorrow(int bookid,int userid);

//    查询借书记录
    public Borrow selectBorrow(int bookid,int userid);

//    还书功能
    @Transactional
    public void returnBook(int bookid,int userid);
}
