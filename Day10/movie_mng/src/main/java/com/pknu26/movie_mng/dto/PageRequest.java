package com.pknu26.movie_mng.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 페이지 요청할때 필요한 값 계산
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequest {

    private int page = 1;  // 현재 페이지 번호

    private int size = 10; // 한 페이지당 보여줄 게시글 수

    // MyBatis의 #{skip}이 이 메서드를 호출합니다.
    public int getSkip() {
        // 예: 1페이지면 (1-1) * 10 = 0 (0번부터 시작)
        //     2페이지면 (2-1) * 10 = 10 (10번부터 시작)
        return (this.page - 1) * this.size;
    }
}
