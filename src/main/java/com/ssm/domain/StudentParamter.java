package com.ssm.domain;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class StudentParamter {
    private String username;
    private int pageIndex;
    private int pageSize;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
