package com.wanted.prenoboarding.company.domain.repository;

import com.wanted.prenoboarding.company.domain.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
