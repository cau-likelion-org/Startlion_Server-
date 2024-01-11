package com.startlion.startlionserver.domain.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PathType {
    RECOMMENDATION("지인 추천"),
    INSTAGRAM("인스타그램"),
    EVERYTIME("에브리타임"),
    HOMEPAGE("멋쟁이 사자처럼 공식 홈페이지"),
    ETC("기타");

    private final String name;
}
