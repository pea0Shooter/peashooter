package com.library.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.library.common.R;
import com.library.dao.BorrowDao;
import com.library.dao.UserDao;
import com.library.domain.*;
import com.library.service.BookService;
import com.library.service.BorrowService;
import com.library.service.NoticeService;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private BorrowService borrowService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private BorrowDao borrowDao;


    //    借书页面展示
    @RequestMapping("/borrowbookgetlist")
    @ResponseBody
    public PageBean<Book> queryBookListByPage(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize) {
        return bookService.queryBookListByPage(currentPage, pageSize);
    }

    //    借书操作
    @RequestMapping("/borrowbook")
    public void borrowBook(@RequestParam("book_id") int book_id, @RequestParam("user_id") int user_id) {
        userService.borrowBook(book_id, user_id);
    }

    //    还书
    @RequestMapping("/returnbook")
    public void returnBook(@RequestParam("book_id") int book_id, @RequestParam("user_id") int user_id) {
        borrowService.returnBook(book_id, user_id);
    }


    //    查看借书记录
    @RequestMapping("/getborrowbook")
    @ResponseBody
    public R<Page> getborrowbook(int currentPage, int pageSize,int book_id, int user_id) {
        Page pageInfo=new Page(currentPage,pageSize);
//        List<Borrow> borrows= borrowDao.selectById("book_id").eq("user_id", user_id);
        QueryWrapper<Borrow> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("user_id", user_id);
        List<Borrow> borrows=borrowDao.selectList(queryWrapper1);

        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();

        List<Integer> bookIds = borrows.stream().map(Borrow::getBookId).collect(Collectors.toList());


        queryWrapper.in("id",bookIds);

//        LambdaQueryWrapper<Borrow> queryWrapper=new LambdaQueryWrapper();
//        queryWrapper.eq(Borrow::getUserId,user_id);
//        queryWrapper.orderByDesc(Borrow::getUpdateTime);
//        borrowService.page(pageInfo,queryWrapper);
        bookService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }




    //    查看公告
    @RequestMapping("/getnotice")
    @ResponseBody
    public Notice getnotice() {
        return noticeService.selectnotice();
    }

    //    修改资料
    @RequestMapping("/modifydata")
    public String modifyData() {
        return "";
    }


    //        根据id返回信息
    @RequestMapping("/selctuserbyid")
    @ResponseBody
    public R<User> selctUserById(String userName) {
        User user = userDao.selectByUsername(userName);
        return R.success(user);
    }

    //    修改用户信息
    @RequestMapping("/updateuserbyid")
    @ResponseBody
    public R<String> updateUser(@RequestBody User user) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_name",user.getUserName()).set("password", user.getPassword());
        int row = userDao.update(null, updateWrapper);

        if(row!=0){return R.success("修改成功");}
        else {return R.error("修改失败");}
    }

}
