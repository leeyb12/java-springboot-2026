package com.pknu26.food.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class PageResponse<T> {
    private List<T> content;
    private int currentPage;
    private int totalPages;
    private int startPage;
    private int endPage;
    private boolean hasPrev;
    private boolean hasNext;

    public PageResponse(List<T> content, int page, int size, long totalCount) {
        this.content = content;
        this.currentPage = page;
        this.totalPages = (int) Math.ceil((double) totalCount / size);
        this.endPage = (int) (Math.ceil(page / 5.0)) * 5;
        this.startPage = endPage - 4;

        if (totalPages < endPage) endPage = totalPages;

        this.hasPrev = startPage > 1;
        this.hasNext = endPage < totalPages;
    }
}
