package com.library.domain;

import lombok.Data;

import java.util.List;

//翻页结果对象
@Data
public class PageBean<T> {
    private int totalCount;//总记录数
    private List<T> rows;//当前页数据


}
