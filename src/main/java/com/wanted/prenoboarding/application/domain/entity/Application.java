package com.wanted.prenoboarding.application.domain.entity;

import com.wanted.prenoboarding.member.domain.entity.Member;
import com.wanted.prenoboarding.notice.domain.entity.Notice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "applications")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	@ManyToOne
	@JoinColumn(name = "notice_Id")
	private Notice notice;
}
