package com.startlion.startlionserver.repository;


import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.startlion.startlionserver.domain.entity.Interview;
import com.startlion.startlionserver.domain.entity.IntervieweePart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.startlion.startlionserver.domain.entity.QInterview.interview;

@Repository
@RequiredArgsConstructor
public class InterviewQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<Interview> findAllByPart(String part) {
        return queryFactory.selectFrom(interview)
                .where(eqPart(part))
                .fetch();
    }

    BooleanExpression eqPart(String part) {
        if (part == null) {
            return null;
        }

        if (part.equals(IntervieweePart.DEV.toString())) {
            return interview.part.in(
                    IntervieweePart.FE.toString(),
                    IntervieweePart.BE.toString(),
                    IntervieweePart.DEV.toString());
        }
        return interview.part.eq(part);
    }


}
