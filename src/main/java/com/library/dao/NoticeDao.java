package com.library.dao;

import com.library.domain.Notice;
import com.library.domain.Notice2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface NoticeDao {

    @Select("select * from notice_info where notice_id =1")
    public Notice GetNotice();

    @Update("UPDATE notice_info\n" +
            "SET notice_title=#{noticeTitle},notice_content=#{noticeContent}\n" +
            "WHERE notice_id=1;")
    public void updataNotice(Notice2 notice);
}
