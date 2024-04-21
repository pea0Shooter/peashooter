package com.library.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName(value="book_info")
public class Book {
    private int id;
    private String bookName;
    private String author;
    private Integer count;
    private BigDecimal price;
    private String publish;
    private Integer status;
    //状态码对应的展示
    private Date createTime;
    private Date updateTime;
}
