package com.startlion.startlionserver.domain.entity;

import com.startlion.startlionserver.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "member")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(length = 100)
    private String email;

    private String password; // 단방향 암호화 필요

    @Column(length = 30)
    private String username;

    private String socialId;

    private String imageUrl;

    @Column(length = 1024)
    private String refreshToken;

    private LocalDateTime expiredIn;

    private boolean status;

    @Transient // DB에 저장하지 않는 필드 -> 이전 이미지 URL
    private String previousImageUrl;

    @Builder
    public User(String email, String username, String socialId, String imageUrl) {
        this.email = email;
        this.username = username;
        this.socialId = socialId;
        this.imageUrl = imageUrl;
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void updateImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
}