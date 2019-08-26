package com.team.house.uitls;

public class Page {
    private Integer page=1;//页码
    private Integer rows=6; //页大小

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
