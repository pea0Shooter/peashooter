package com.library.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Notice {
    private Integer noticeId;
    private String noticeTitle;
    private String noticeContent;
    private Integer noticeAdminId;
    private Date createTime;
    private Date updateTime;
}
