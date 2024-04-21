package com.library.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.library.domain.Borrow;
import org.apache.ibatis.annotations.*;

@Mapper
public interface BorrowDao extends BaseMapper<Borrow> {

    //    添加借书记录
    @Insert("insert into borrow_info (book_id,user_id) " +
            "VALUES (#{bookid},#{userid})")
    public void addBorrow(@Param("bookid") int bookid, @Param("userid") int userid);

    //    查询借书记录
    @Select("select * from borrow_info where book_id=#{bookid} and user_id=#{userid}")
    public Borrow selectBorrow(@Param("bookid") int bookid, @Param("userid") int userid);

    //    删除借书记录
    @Delete("delete from borrow_info where book_id=#{bookid} and user_id=#{userid}")
    public void deleteBorrow(@Param("bookid") int bookid, @Param("userid") int userid);
}
