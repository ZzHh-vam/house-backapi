package com.team.house.housebackapi.util;

/**
 * @Author ZzHh
 * @Classname PageParameter
 * @Description TODO
 * @Date: Created in 2020/2/5 15:36
 * @Create By IntelliJ IDEA
 **/
public class PageParameter {
    private Integer page = 1;
    private Integer pageSize = 5;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
