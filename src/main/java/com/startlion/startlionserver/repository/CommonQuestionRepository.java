package com.startlion.startlionserver.repository;

import com.startlion.startlionserver.domain.entity.CommonQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommonQuestionRepository extends JpaRepository<CommonQuestion, Long> {
    Optional<CommonQuestion> findByGeneration(Long generation);
}
