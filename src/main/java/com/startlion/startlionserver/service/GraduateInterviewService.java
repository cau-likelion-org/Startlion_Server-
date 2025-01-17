package com.startlion.startlionserver.service;

import com.startlion.startlionserver.domain.entity.GraduateInterview;
import com.startlion.startlionserver.domain.enums.IntervieweePart;
import com.startlion.startlionserver.dto.response.interview.InterviewDetailResponse;
import com.startlion.startlionserver.dto.response.interview.InterviewResponse;
import com.startlion.startlionserver.dto.response.interviewanswer.InterviewAnswerResponse;
import com.startlion.startlionserver.repository.GraduateInterviewContentJpaRepository;
import com.startlion.startlionserver.repository.GraduateInterviewJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GraduateInterviewService {

    private final GraduateInterviewJpaRepository graduateInterviewJpaRepository;
    private final GraduateInterviewContentJpaRepository graduateInterviewContentJpaRepository;

    public InterviewDetailResponse getInterviewById(Long interviewId) {
          val interview = getById(interviewId);
          val interviewAnswerResponses = graduateInterviewContentJpaRepository.findByGraduateInterview(interview)
                  .stream()
                  .map(InterviewAnswerResponse::of)
                  .toList();
          return InterviewDetailResponse.of(interview, interviewAnswerResponses);
    }

    public List<InterviewResponse> getInterviews(String part) {
            if (Objects.equals(part, "ALL")) {
                return graduateInterviewJpaRepository.findAll().stream()
                        .map(InterviewResponse::of)
                        .collect(Collectors.toList());
            } else {
                return graduateInterviewJpaRepository.findAllByPart(IntervieweePart.valueOf(part)).stream()
                        .map(InterviewResponse::of)
                        .collect(Collectors.toList());
            }

    }

    @Transactional
    public void updateInterviewImageUrl(Long interviewId, String imageUrl) {
        GraduateInterview graduateInterview = getById(interviewId);
        graduateInterview.updateImageUrl(imageUrl);
    }

    protected GraduateInterview getById(Long interviewId) {
        return graduateInterviewJpaRepository.findById(interviewId)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 인터뷰가 없습니다."));
    }
}
