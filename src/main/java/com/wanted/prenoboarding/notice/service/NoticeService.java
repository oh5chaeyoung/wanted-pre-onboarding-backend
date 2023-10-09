package com.wanted.prenoboarding.notice.service;

import com.wanted.prenoboarding.notice.dto.NoticeModifyRequest;
import com.wanted.prenoboarding.notice.dto.NoticeRegisterRequest;
import com.wanted.prenoboarding.notice.dto.NoticeResponse;

import java.util.List;

public interface NoticeService {
	List<NoticeResponse> findAllNotices();
	List<NoticeResponse> findNoticesByCompanyId(Long companyId);
	NoticeResponse findNoticeById(Long id);
	Long addNotice(NoticeRegisterRequest request);
	NoticeResponse modifyNotice(Long id, NoticeModifyRequest request);
	Long removeNotice(Long id);
}
