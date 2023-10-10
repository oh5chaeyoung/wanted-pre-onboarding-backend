package com.wanted.prenoboarding.notice.service;

import com.wanted.prenoboarding.notice.dto.response.NoticeDetailResponse;
import com.wanted.prenoboarding.notice.dto.request.NoticeModifyRequest;
import com.wanted.prenoboarding.notice.dto.request.NoticeRegisterRequest;
import com.wanted.prenoboarding.notice.dto.response.NoticeResponse;

import java.util.List;

public interface NoticeService {
	List<NoticeResponse> findAllNotices();
	List<NoticeResponse> findNoticesByCompanyId(Long companyId);
	NoticeDetailResponse findNoticeById(Long id);
	Long addNotice(NoticeRegisterRequest request);
	NoticeResponse modifyNotice(Long id, NoticeModifyRequest request);
	Long removeNotice(Long id);
}
