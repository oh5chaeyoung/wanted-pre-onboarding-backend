package com.wanted.prenoboarding.notice.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class NoticeDetailResponse {
	private NoticeResponse noticeResponse;
	private List<Long> companyNoticeIds;
}
