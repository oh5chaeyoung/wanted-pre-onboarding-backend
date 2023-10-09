package com.wanted.prenoboarding.notice.service;

import com.wanted.prenoboarding.company.domain.entity.Company;
import com.wanted.prenoboarding.company.domain.repository.CompanyRepository;
import com.wanted.prenoboarding.company.dto.CompanyResponse;
import com.wanted.prenoboarding.notice.domain.entity.Notice;
import com.wanted.prenoboarding.notice.domain.repository.NoticeRepository;
import com.wanted.prenoboarding.notice.dto.NoticeModifyRequest;
import com.wanted.prenoboarding.notice.dto.NoticeRegisterRequest;
import com.wanted.prenoboarding.notice.dto.NoticeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeServiceImp implements NoticeService {
	private final NoticeRepository noticeRepository;
	private final CompanyRepository companyRepository;
	@Override
	public List<NoticeResponse> findAllNotices() {
		List<Notice> entities = noticeRepository.findAll();
		List<NoticeResponse> dtos = new ArrayList<>();

		for(Notice notice : entities) {
			NoticeResponse dto = entityToDto(notice);
			/* 회사 정보 */
			Company company = companyRepository.findCompanyById(notice.getCompany().getId());
			dto.setCompanyResponse(CompanyResponse.builder()
							.name(company.getName())
							.country(company.getCountry())
							.region(company.getRegion())
					.build());
			dtos.add(dto);
		}

		return dtos;
	}

	@Override
	public List<NoticeResponse> findNoticesByCompanyId(Long companyId) {
		return null;
	}

	@Override
	public NoticeResponse findNoticeById(Long id) {
		return null;
	}

	@Override
	public Long addNotice(NoticeRegisterRequest request) {
		return null;
	}

	@Override
	public NoticeResponse modifyNotice(Long id, NoticeModifyRequest request) {
		return null;
	}

	@Override
	public Long removeNotice(Long id) {
		return null;
	}

	private NoticeResponse entityToDto(Notice notice) {
		return NoticeResponse.builder()
				.id(notice.getId())
				.position(notice.getPosition())
				.commission(notice.getCommission())
				.content(notice.getContent())
				.skill(notice.getSkill())
				.build();
	}

}
