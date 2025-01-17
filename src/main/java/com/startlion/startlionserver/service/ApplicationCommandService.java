package com.startlion.startlionserver.service;

import com.startlion.startlionserver.domain.entity.Application;
import com.startlion.startlionserver.dto.request.application.*;
import com.startlion.startlionserver.dto.response.application.ApplicationCreateResponse;
import com.startlion.startlionserver.global.exception.PersonalInfoApproveException;
import com.startlion.startlionserver.repository.ApplicationJpaRepository;
import com.startlion.startlionserver.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ApplicationCommandService {

    private final UserJpaRepository userJpaRepository;
    private final ApplicationJpaRepository applicationJpaRepository;

    @Value("${current-generation}")
    private int currentGeneration;

    public ApplicationCreateResponse createApplication(ApplicationCreateRequest request, final long userId) {
        val user = userJpaRepository.findByIdOrThrow(userId);
        val application = Application.create(request, user, currentGeneration);
        applicationJpaRepository.save(application);
        return ApplicationCreateResponse.of(application);
    }

    public void updateApplicationPage1(Long applicationId, ApplicationPage1Request request, final long userId) {
        if (!request.isAgreed()) {
            throw new PersonalInfoApproveException("개인정보 수집 및 이용에 동의해주세요.");
        }
        val application = applicationJpaRepository.findByIdOrThrow(applicationId);
        // checkApplicationOwner(application, userId);
        application.updateApplicationPage1(request);
    }

    public void updateApplicationPage2(Long applicationId, ApplicationPage2Request request, final long userId) {
        val application = applicationJpaRepository.findByIdOrThrow(applicationId);
        application.updateApplicationPage2(request);
    }

    public void updateApplicationPage3(Long applicationId, ApplicationPage3Request request, final long userId) {
        val application = applicationJpaRepository.findByIdOrThrow(applicationId);
        // checkApplicationOwner(application, userId);
        application.updateApplicationPage3(request);
    }

    public void updateApplicationPage4(Long applicationId, ApplicationPage4Request request, final long userId) {
        val application = applicationJpaRepository.findByIdOrThrow(applicationId);
        // checkApplicationOwner(application, userId);
        application.updateApplicationPage4(request);
    }

    public void submitApplication(Long applicationId, long userId) {
        val application = applicationJpaRepository.findByIdOrThrow(applicationId);
        // checkApplicationOwner(application, userId);
        application.completeApplication();
    }

    // 본인의 지원서인지 체크
//    private void checkApplicationOwner(final Application application, final long userId){
//        val user =  userJpaRepository.findByIdOrThrow(userId);
//        if (user.equals(application.getUser())) {
//            throw new AccessDeniedException("해당 지원서의 소유자가 아닙니다.");
//        }
//    }

}