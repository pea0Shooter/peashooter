package com.library.service.impl;

import com.library.dao.NoticeDao;
import com.library.domain.Notice;
import com.library.domain.Notice2;
import com.library.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    @Override
    public Notice selectnotice() {
        return noticeDao.GetNotice();
    }

    @Override
    public void updataNotice(Notice2 noticeContent) {
        noticeDao.updataNotice(noticeContent);
    }


}
