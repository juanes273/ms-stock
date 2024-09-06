package com.bootcamp_2024.ms_stock.domain.pagination;

public class Pagination {
    private int pageNumber;
    private int pageSize;
    private boolean ascending;

    public Pagination(int pageNumber, int pageSize, boolean ascending) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.ascending = ascending;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }
}
