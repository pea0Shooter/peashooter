package com.library.service;

import com.library.domain.Notice;
import com.library.domain.Notice2;

public interface NoticeService {
    //    查看公告
    public Notice selectnotice();


//修改公告
    public void updataNotice(Notice2 noticeContent);
}
