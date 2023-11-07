package com.startlion.startlionserver.dto.request.application;


import com.startlion.startlionserver.domain.entity.Part;
import com.startlion.startlionserver.domain.entity.PathToKnow;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ApplicationTemporaryStorageRequest {
    private Boolean isAgreed;

    private String name;

    private String gender;

    private Integer studentNum;

    private String major;

    private String multiMajor;

    private String semester;

    private String phone;

    private String email;

    private List<PathToKnow> pathToKnow;

    private Part part;


}
