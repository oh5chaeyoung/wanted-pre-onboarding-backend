package com.wanted.prenoboarding.notice.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoticeModifyRequest {
	private String position;
	private String commission;
	private String content;
	private String skill;
}
