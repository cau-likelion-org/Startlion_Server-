package com.startlion.startlionserver.dto.response.interviewanswer;

import com.startlion.startlionserver.domain.entity.InterviewContent;

public record InterviewAnswerResponse(
        Long interviewAnswerId,
        String question,
        String answer
) {

    public static InterviewAnswerResponse of(InterviewContent interviewContent) {
        return new InterviewAnswerResponse(
                interviewContent.getInterviewAnswerId(),
                interviewContent.getQuestion(),
                interviewContent.getAnswer());
    }
}
