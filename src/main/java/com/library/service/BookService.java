package com.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.library.domain.Book;
import com.library.domain.PageBean;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BookService extends IService<Book> {
    //分页
    public PageBean<Book> queryBookListByPage(int currentPage, int pageSize);


    //    根据id查询图书
    public Book selctBookById(int bookId);

    //    添加图书
    public boolean addBook(Book book);

    //    根据id删除图书
    public boolean deleteById(int id);


    //    批量删除图书
    public boolean batchDeleteBook(int[] ids);


    //    修改图书

    public Integer updateBook(Book bookInfo);
}
