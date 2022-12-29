package com.nhnacademy.jdbc.board.post.domain;

import lombok.Data;

@Data
public class Pagination {
    int rowCount = 20;
    int pageCount = 100;
    int totalCount;
    int page;

    int startPage = 1;
    int endPage;

    int totalPageCount;
    int offset;


    public Pagination(final int totalCount, final int page) {
        setTotalPageCount(totalCount, this.rowCount);
        setStartPage(this.startPage, page, this.pageCount);
        setEndpage(this.startPage, this.pageCount, this.totalPageCount);
        setOffset(page, this.rowCount);
    }


    private void setTotalPageCount(final int totalCount, final int rowCount) {
        this.totalPageCount = (int) Math.ceil(totalCount * 1.0 / rowCount);
    }


    private void setStartPage(final int startPage, final int page, final int pageCount) {
        this.startPage = startPage + (((page - startPage) / pageCount) * pageCount);
    }


    private void setEndpage(final int startPage, final int pageCount, final int totalPageCount) {
        this.endPage = ((startPage - 1) + pageCount) < totalPageCount ? (startPage - 1) + pageCount : totalPageCount;
    }

    private void setOffset(final int page, final int rowCount) {
        this.offset = (page - 1) * rowCount;
    }
}
