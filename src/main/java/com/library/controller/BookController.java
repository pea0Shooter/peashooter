package com.library.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.library.common.R;
import com.library.domain.Book;
import com.library.domain.Notice;
import com.library.domain.Notice2;
import com.library.service.BookService;
import com.library.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private NoticeService noticeService;

    /**
     * 显示图书分页查询
     * 请求:/book/getListByPage?currentPage=1
     * 响应: pageResult对象
     */
    @RequestMapping("/getListByPage")
    @ResponseBody
    public R<Page> queryBookListByPage(int currentPage,int pageSize,String name) {
        Page pageInfo=new Page(currentPage,pageSize);
        LambdaQueryWrapper<Book> queryWrapper=new LambdaQueryWrapper();
        queryWrapper.like(StringUtils.isNotEmpty(name),Book::getBookName,name).eq(Book::getStatus,1);
        queryWrapper.orderByDesc(Book::getUpdateTime);
        bookService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }

    /**
     * 添加图书接口
     * 请求:/book/addBook
     * 参数:bookName=图书1&author=作者1&count=23&price=36&publish=出版社1&status=1
     * 响应:成功返回空字符串 失败返回失败信息
     */
    @RequestMapping("/addBook")
    public String addBook(Book bookInfo) {
        log.info("添加图书:{}", bookInfo);
        if (!org.springframework.util.StringUtils.hasLength(bookInfo.getBookName())
                || !org.springframework.util.StringUtils.hasLength((bookInfo.getAuthor()))
                || bookInfo.getCount() == null
                || bookInfo.getPrice() == null
                || !org.springframework.util.StringUtils.hasLength(bookInfo.getPublish())
                || bookInfo.getStatus() == null) {
            return "输入参数不合法";
        }
        try {
            bookService.addBook(bookInfo);
            return "";
        } catch (Exception e) {
            log.error("添加图书失败", e);
            return e.getMessage();
        }
    }

    /**
     * 根据id删除图书接口
     * 请求:/book/deleteBook
     * 参数:bookName=图书1&author=作者1&count=23&price=36&publish=出版社1&status=1
     * 响应:成功返回空字符串 失败返回失败信息
     */
    @RequestMapping("/deleteBook")
    public String deleteBook(int id) {
        boolean flag = bookService.deleteById(id);
        if (flag) {
            return "";
        } else {
            return "删除失败";
        }
    }


    /**
     * 批量删除接口
     * 请求:/book/batchDeleteBook
     * Content-Type: application/x-www-form-urlencoded; charset=UTF-8
     * 参数:
     * 响应:成功返回空字符串 失败返回错误信息
     */

    @RequestMapping("/batchDeleteBook")
    public String batchDeleteBook(@RequestParam int[] ids) {
        boolean flag = bookService.batchDeleteBook(ids);
        if (flag) {
            return "";
        } else {
            return "删除失败";
        }
    }

    /**
     * 点击修改按钮 修改图书信息
     * 请求/book/updateBook 一个form表单
     * Content-Type: application/x-www-form-urlencoded; charset=UTF-8
     * 参数:id=1&bookName=图书1&author=作者1&count=23&price=36&publish=出版社1&status=1...
     * 响应:正常返回空字符串"" 失败返回失败信息
     */
    @RequestMapping("/updateBook")
    public String updateBook(Book bookInfo) {
        bookService.updateBook(bookInfo);
        return "";
    }


    /**
     * 通过id得到图书信息
     * 响应:返回id对应的图书信息
     */
    @RequestMapping("/selctBookById")
    @ResponseBody
    public Book selctBookById(int bookId) {
        return bookService.selctBookById(bookId);
    }


    //    查看公告
    @RequestMapping("/getnotice")
    @ResponseBody
    public Notice getnotice() {


        return noticeService.selectnotice();
    }

    //    修改公告
    @RequestMapping("/updatanotice")
    @ResponseBody
    public void updatanotice(@RequestBody Notice2 noticeContent) {

        noticeService.updataNotice(noticeContent);
    }
}
