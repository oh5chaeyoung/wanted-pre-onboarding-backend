package com.wanted.prenoboarding.member.domain.repository;

import com.wanted.prenoboarding.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findMemberById(Long id);
}
