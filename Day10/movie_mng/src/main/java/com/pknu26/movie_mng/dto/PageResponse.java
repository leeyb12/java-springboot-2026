package com.pknu26.movie_mng.dto;

import java.util.List;

import lombok.Getter;

    @Getter
    public class PageResponse<T> {

        private final List<T> dtoList;  // 게시글 리스트 T : Board, Student, Reply등 모두 가능
        private final int totalCount;   // 전체 게시글 수 예) 32
        private int currentPage;  // 사용자가 보고있는 현재 페이지 번호
        private final int size;         // 페이지당 게시글 수 10, 
        private final int totalPage;    // 전체 페이지수. 게시글이 32 / 10 = 3.2 를 올림해서 4페이지 필요 

        /**
         * 1, 11이 시작페이지
         * 페이지 번호 묶음
         * [1][2][3][4][5][6][7][8][9][10]
         * [11][12][13][14][15][16][17][18][19][20]
         */
        private final int startPage;    // 시작페이지 , 화면에 보여줄 시작페이지
        private final int endPage;      // 화면에 보여줄 마지막페이지
        private final boolean prev;     // 이전버튼 표시 여부
        private final boolean next;     // 끝버튼 표시 여부

        public PageResponse(List<T> dtoList, int totalCount, int currentPage, int size) {
            this.dtoList = dtoList;
            this.totalCount = totalCount;
            this.currentPage = currentPage <= 0 ? 1 : currentPage; 
            this.size = size;
            this.totalPage = (int) Math.ceil((double) totalCount / size);

            if (this.currentPage > this.totalPage && this.totalPage > 0) {
                this.currentPage = this.totalPage;
            }

            int tempEnd = (int) (Math.ceil(this.currentPage / 10.0) * 10);

            this.startPage = (tempEnd - 9) < 1 ? 1 : (tempEnd - 9);

            this.endPage = Math.min(tempEnd, this.totalPage);

            this.prev = this.startPage > 1;
            this.next = this.totalPage > tempEnd;
        }
    }

