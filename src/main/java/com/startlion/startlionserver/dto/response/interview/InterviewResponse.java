package com.startlion.startlionserver.dto.response.interview;


import com.startlion.startlionserver.domain.entity.Interview;
import io.swagger.v3.oas.annotations.media.Schema;

public record InterviewResponse(
        @Schema(description = "인터뷰 ID")
        Long interviewId,

        @Schema(description = "활동 기수")
        Long generation,

        @Schema(description = "인터뷰 대상자 지원 파트")
        String part,

        @Schema(description = "인터뷰 대상자 이름")
        String name,

        @Schema(description = "인터뷰 목록 페이지에서 사용하는 섬네일 텍스트")
        String thumbnailText,

        @Schema(description = "인터뷰 대상자 image url")
        String imageUrl
) {

    public static InterviewResponse of(Interview interview) {
        return new InterviewResponse(
                interview.getInterviewId(),
                interview.getGeneration(),
                interview.getPart().toString(),
                interview.getName(),
                interview.getOneLineContent(),
                interview.getImageUrl()
        );
    }
}
