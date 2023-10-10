package com.wanted.prenoboarding.notice.domain.entity;

import com.wanted.prenoboarding.company.domain.entity.Company;
import com.wanted.prenoboarding.notice.dto.NoticeModifyRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "notices")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String position;
	private String commission;
	private String content;
	private String skill;

	/* 회사 정보 */
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	/* 채용공고 수정 메소드 */
	public void editNotice(NoticeModifyRequest request) {
		this.position = request.getPosition();
		this.commission = request.getCommission();
		this.content = request.getContent();
		this.skill = request.getSkill();
	}
}
