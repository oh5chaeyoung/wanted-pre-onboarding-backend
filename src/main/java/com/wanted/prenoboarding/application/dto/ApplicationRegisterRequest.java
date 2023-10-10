package com.wanted.prenoboarding.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicationRegisterRequest {
	private Long memberId;
	private Long noticeId;
}
