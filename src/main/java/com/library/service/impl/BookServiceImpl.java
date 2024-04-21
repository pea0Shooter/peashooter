package com.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.library.dao.BookDao;
import com.library.domain.Book;
import com.library.domain.PageBean;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao,Book> implements BookService{

    @Autowired
    private BookDao bookDao;

    @Override
    public PageBean<Book> queryBookListByPage(int currentPage, int pageSize) {
        int begin=(currentPage-1)*pageSize;
        int size=pageSize;

        List<Book> rows=bookDao.queryBookListByPage(begin,size);
        int totalCount=bookDao.selectTotalCount();

        PageBean<Book> pageBean=new PageBean<Book>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        return pageBean;
    }

    @Override
    public Book selctBookById(int bookId){
        return bookDao.selectById(bookId);
    }

    @Override
    public boolean addBook(Book book) {
        bookDao.addBook(book);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        bookDao.deleteById(id);
        return true;
    }

    @Override
    public boolean batchDeleteBook(int[] ids){
        bookDao.batchDeleteBook(ids);
        return true;
    }

    @Override
    public Integer updateBook(Book bookInfo){
        Integer result = 0;
        result = bookDao.updateBook(bookInfo);
        return result;
    }
}
