package com.library.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.library.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao extends BaseMapper<User> {


//    //分页查询 查询这一页上的所有数据
//    @Select("select * from book_info LIMIT #{begin}, #{size}")
//    public List<Book> queryBookListByPage(@Param("begin") int begin, @Param("size") int size);

    //    查询总用户数
    @Select("select count(*) from user_info")
    public int selectTotalCount();

    //根据id查询用户
    @Select("select * from user_info where id = #{userId}")
    public User selectById(int userId);


    //    登录功能检验是否有该用户
    @Select("select * from lib_system.user_info where user_name=#{username} " +
            "and password=#{password} and Permissions=#{permission}")
    public User selectUser(@Param("username") String username, @Param("password") String password,@Param("permission")Integer permission);

//    注册功能:查询是否有这个用户
    @Select("select * from user_info where user_name=#{username}")
    User selectByUsername(@Param("username") String username);


//    添加用户功能
    @Insert("insert into user_info (user_name,password) " +
            "VALUES (#{userName} ,#{password})")
    public void addUser(@Param("userName")String userName ,@Param("password") String password);
}
