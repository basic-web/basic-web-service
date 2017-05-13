package com.github.ququzone.basicweb.common;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * pagination model.
 *
 * @author Yang XuePing
 */
public class Page<T> {
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static Page EMPTY;

    static {
        EMPTY = new Page(0, DEFAULT_PAGE_SIZE, 1);
    }

    @Expose
    private long total;
    @Expose
    private List<T> data;
    @Expose
    private int current;
    @Expose
    private int pageSize;
    @Expose
    private int totalPage;

    public Page(long total, int pageSize, int current) {
        this.total = total;
        this.pageSize = pageSize;
        this.current = current;
        this.totalPage = (total % pageSize == 0) ? (int) (total / pageSize)
                : (int) (total / pageSize + 1);
    }

    public long getTotal() {
        return total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getCurrent() {
        return current;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public String toGson() {
        return GsonHelper.string(this);
    }
}
