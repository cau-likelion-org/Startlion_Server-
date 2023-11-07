package com.startlion.startlionserver.controller;

import com.startlion.startlionserver.dto.request.application.ApplicationTemporaryStorageRequest;
import com.startlion.startlionserver.dto.response.application.ApplicationGetResponse;
import com.startlion.startlionserver.dto.response.application.ApplicationPersonalInformationGetResponse;
import com.startlion.startlionserver.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping(value = "/application")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    // 저장된 지원서 없을 시, 지원서 1페이지 정보 가져오기
    @GetMapping
    public ResponseEntity<ApplicationPersonalInformationGetResponse> getApplicationPersonalInformation(){
        return ResponseEntity.ok(applicationService.getApplicationPersonalInformation());
    }

    // 저장된 지원서 있을 시, 지원서 정보 가져오기
    @GetMapping("/{applicationId}")
    public ResponseEntity<ApplicationGetResponse> getApplication(@PathVariable Long applicationId){
        return ResponseEntity.ok(applicationService.getById(applicationId));
    }

    // 지원서 임시 저장 or 다음 버튼 누를 시 table 생성 또는 update
    @PutMapping("/{applicationId}")
    public ResponseEntity<Void> updateApplication( @PathVariable Long applicationId, @RequestBody ApplicationTemporaryStorageRequest request){
        URI uri = URI.create("/application/" + applicationService.updateApplication(applicationId, request));
        return ResponseEntity.created(uri).build();
    }



}
