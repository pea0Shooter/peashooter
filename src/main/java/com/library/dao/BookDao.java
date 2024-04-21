package com.library.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.library.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookDao extends BaseMapper<Book> {
    //分页查询 查询这一页上的所有数据
    @Select("select * from book_info LIMIT #{begin}, #{size}")
    public List<Book> queryBookListByPage(@Param("begin") int begin, @Param("size") int size);

    //    查询总记录项
    @Select("select count(*) from book_info")
    public int selectTotalCount();


    @Select("select * from book_info where id = #{bookId}")
    public Book selectById(int bookId);

    @Insert("insert into book_info (book_name,author,count,price,publish,`status`) " +
            "VALUES (#{bookName} ,#{author},#{count},#{price},#{publish},#{status})")
    public boolean addBook(Book book);

    @Delete("delete from book_info where id=#{id}")
    public boolean deleteById(int id);

    //    批量删除
    void batchDeleteBook(@Param("ids") int[] ids);

    //    修改
    Integer updateBook(Book bookInfo);

//    借书功能使书的count减一
    @Update("UPDATE lib_system.book_info\n" +
            "SET lib_system.book_info.count=lib_system.book_info.count-1 \n" +
            "WHERE id=#{bookid};")
    int updateContById(@Param("bookid")int bookid);

    //    借书功能使书的count加一
    @Update("UPDATE lib_system.book_info\n" +
            "SET lib_system.book_info.count=lib_system.book_info.count+1 \n" +
            "WHERE id=#{bookid};")
    int updateContById2(@Param("bookid")int bookid);
}
