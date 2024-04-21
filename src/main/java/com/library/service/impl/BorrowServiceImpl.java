package com.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.library.dao.BookDao;
import com.library.dao.BorrowDao;
import com.library.domain.Borrow;
import com.library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowServiceImpl  extends ServiceImpl<BorrowDao, Borrow> implements BorrowService {

    @Autowired
    private BorrowDao borrowDao;
    @Autowired
    private BookDao bookDao;
    @Override
    public void addBorrow(int bookid, int userid) {
        borrowDao.addBorrow(bookid,userid);
    }

    @Override
    public Borrow selectBorrow(int bookid, int userid) {
        return borrowDao.selectBorrow(bookid,userid);
    }

    @Override
    public void returnBook(int bookid, int userid) {
        bookDao.updateContById2(bookid);
        borrowDao.deleteBorrow(bookid,userid);
    }
}
