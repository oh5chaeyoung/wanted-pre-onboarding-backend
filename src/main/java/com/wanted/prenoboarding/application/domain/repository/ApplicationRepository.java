package com.wanted.prenoboarding.application.domain.repository;

import com.wanted.prenoboarding.application.domain.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
	Application findApplicationByMemberIdAndNoticeId(Long memberId, Long noticeId);
}
