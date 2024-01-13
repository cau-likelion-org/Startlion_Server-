package com.startlion.startlionserver.dto.response.application;

import com.startlion.startlionserver.domain.entity.Application;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;


@Builder
@Schema(description = "지원서 페이지 1 응답")
public record ApplicationPage1Response(
        @Schema(description = "개인 정보 수집 동의여부") boolean isAgreed,
        @Schema(description = "지원서 ID") Long applicationId,
        @Schema(description = "이름") String name,
        @Schema(description = "성별") String gender,
        @Schema(description = "학번") String studentNum,
        @Schema(description = "전공") String major,
        @Schema(description = "복수전공") String multiMajor,
        @Schema(description = "학기") String semester,
        @Schema(description = "전화번호") String phone,
        @Schema(description = "이메일") String email,
        @Schema(description = "지원 파트") String part,
        @Schema(description = "알게 된 경로") String pathToKnow
) {

    public static ApplicationPage1Response of(Application application) {
        return ApplicationPage1Response.builder()
                .isAgreed(application.isPersonalInformationAgreed())
                .applicationId(application.getApplicationId())
                .name(application.getName())
                .gender(application.getGender().getName())
                .studentNum(application.getStudentNumber())
                .major(application.getMajor())
                .multiMajor(application.getMultiMajor())
                .semester(application.getSemester().getName())
                .phone(application.getPhone())
                .email(application.getEmail())
                .part(application.getPart().getName())
                .pathToKnow(application.getPathToKnow().getName())
                .build();
    }
}
