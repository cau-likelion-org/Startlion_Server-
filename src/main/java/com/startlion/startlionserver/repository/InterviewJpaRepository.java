package com.startlion.startlionserver.repository;

import com.startlion.startlionserver.domain.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewJpaRepository extends JpaRepository<Interview, Long> {
}
