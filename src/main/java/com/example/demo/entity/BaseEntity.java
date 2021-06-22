package com.example.demo.entity;

/**
 * @author Xiongziqi
 * @date 2020/10/26 10:58
 */
public class BaseEntity {

    private Integer id;

    private Integer page = 1;

    private Integer rows = 10;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
