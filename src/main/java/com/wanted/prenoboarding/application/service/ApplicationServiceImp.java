package com.wanted.prenoboarding.application.service;

import com.wanted.prenoboarding.application.domain.entity.Application;
import com.wanted.prenoboarding.application.domain.repository.ApplicationRepository;
import com.wanted.prenoboarding.application.dto.ApplicationRegisterRequest;
import com.wanted.prenoboarding.member.domain.repository.MemberRepository;
import com.wanted.prenoboarding.notice.domain.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ApplicationServiceImp implements ApplicationService{
	private final ApplicationRepository applicationRepository;
	private final MemberRepository memberRepository;
	private final NoticeRepository noticeRepository;
	@Override
	public Long addApplication(ApplicationRegisterRequest request) {
		Application application = applicationEntityToDto(request);
		return applicationRepository.save(application).getId();
	}

	private Application applicationEntityToDto(ApplicationRegisterRequest request) {
		return Application.builder()
				.member(memberRepository.findMemberById(request.getMemberId()))
				.notice(noticeRepository.findNoticeById(request.getNoticeId()))
				.build();
	}
}
