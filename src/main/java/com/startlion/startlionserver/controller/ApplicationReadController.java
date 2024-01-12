package com.startlion.startlionserver.controller;


import com.startlion.startlionserver.dto.response.application.*;
import com.startlion.startlionserver.service.ApplicationQueryService;
import com.startlion.startlionserver.util.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RequestMapping("/application")
@RequiredArgsConstructor
@RestController
public class ApplicationReadController implements ApplicationReadApi {

    private final ApplicationQueryService applicationQueryService;

    @Override
    @GetMapping
    public ResponseEntity<ApplicationsGetResponse> getApplications(Principal principal) {
        val response = applicationQueryService.getApplications(UserUtil.getUserId(principal));
        return ResponseEntity.ok(response);
    }


    @Override
    @GetMapping("/{applicationId}")
    public ResponseEntity<ApplicationGetResponse> getApplicationById(Long applicationId, Principal principal) {
        val response = applicationQueryService.getApplication(applicationId, UserUtil.getUserId(principal));
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/{applicationId}/page1")
    public ResponseEntity<ApplicationPage1Response> getApplicationPage1ById(Long applicationId, Principal principal) {
        return null;
    }

    @Override
    @GetMapping("/{applicationId}/page2")
    public ResponseEntity<ApplicationPage2GetResponse> getApplicationPage2ById(Long applicationId, Principal principal) {
        val response = applicationQueryService.getApplicationPage2(applicationId, UserUtil.getUserId(principal));
        return ResponseEntity.ok(response);

    }

    @Override
    @GetMapping("/{applicationId}/page3")
    public ResponseEntity<ApplicationPage3GetResponse> getApplicationPage3ById(Long applicationId, Principal principal) {
        val response = applicationQueryService.getApplicationPage3(applicationId, UserUtil.getUserId(principal));
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/{applicationId}/page4")
    public ResponseEntity<ApplicationPage4Response> getApplicationPage4ById(Long applicationId, Principal principal) {
        val response = applicationQueryService.getApplicationPage4(applicationId, UserUtil.getUserId(principal));
        return ResponseEntity.ok(response);
    }

}
