package com.pknu26.studygroup.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudyPost {
    private Long postId;
    private Long userId;
    private Long categoryId;
    private String title;
    private String content;
    private Integer maxMembers;

    private String status;     
    private Integer viewCount;  
    private java.time.LocalDateTime createdAt;
    
    // 조인 조회용
    private String writerName;
    private String categoryName;
}
