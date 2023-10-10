package com.wanted.prenoboarding.notice.domain.repository;

import com.wanted.prenoboarding.notice.domain.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
	List<Notice> findAll();
	List<Notice> findNoticesByCompanyId(Long companyId);
	Notice findNoticeById(Long id);
}
