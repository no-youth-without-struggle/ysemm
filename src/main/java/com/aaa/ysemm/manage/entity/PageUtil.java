package com.aaa.ysemm.manage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.manage.entity
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/8/3 16:52
 * @Version: 1.0
 */
public class PageUtil {
    private String name;
    private String startDate;
    private String endDate;
    private int page;
    private int count;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page=(this.page-1)*count;
    }

    public PageUtil(String name, String startDate, String endDate, int page, int count) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.page = page;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public PageUtil() {
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "name='" + name + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", page=" + page +
                ", count=" + count +
                '}';
    }
}
