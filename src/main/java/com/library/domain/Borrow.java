package com.library.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value="borrow_info")
public class Borrow {
    private Integer borrowId;
    private Integer userId;
    private Integer bookId;
    private Date borrowDate;
    private Date closeDate;
    private Date returnDate;
    private Date createTime;
    private Date updateTime;
    private Integer status;

}
