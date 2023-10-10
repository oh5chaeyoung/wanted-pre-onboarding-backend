package com.wanted.prenoboarding.notice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoticeRegisterRequest {
	private String position;
	private String commission;
	private String content;
	private String skill;
	private Long companyId;
}
