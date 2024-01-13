package com.startlion.startlionserver.dto.response.application;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;

@Schema(description = "지원서 페이지 4")
@Builder
public record ApplicationPage4Response(
        @Schema(description = "처음 일자 면접 가능한 시간")
        List<String> firstDay,
        @Schema(description = "두번째 일자 면접 가능한 시간")
        List<String> secondDay,
        @Schema(description = "세번째 일자 면접 가능한 시간")
        List<String> thirdDay
) {
    public static ApplicationPage4Response of(
            List<String> firstDay,
            List<String> secondDay,
            List<String> thirdDay) {
        return ApplicationPage4Response.builder()
                .firstDay(firstDay)
                .secondDay(secondDay)
                .thirdDay(thirdDay)
                .build();
    }
}
