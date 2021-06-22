package com.example.demo.entity;

import java.util.List;

/**
 * @author Xiongziqi
 * @date 2020/10/26 14:07
 */
public class RespPageBean {

    private Long total;
    private List<?> data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
