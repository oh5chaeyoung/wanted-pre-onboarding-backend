package com.wanted.prenoboarding.notice.service;

import com.wanted.prenoboarding.company.domain.entity.Company;
import com.wanted.prenoboarding.company.domain.repository.CompanyRepository;
import com.wanted.prenoboarding.company.service.CompanyServiceImp;
import com.wanted.prenoboarding.notice.domain.entity.Notice;
import com.wanted.prenoboarding.notice.domain.repository.NoticeRepository;
import com.wanted.prenoboarding.notice.dto.response.NoticeDetailResponse;
import com.wanted.prenoboarding.notice.dto.request.NoticeModifyRequest;
import com.wanted.prenoboarding.notice.dto.request.NoticeRegisterRequest;
import com.wanted.prenoboarding.notice.dto.response.NoticeResponse;
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
	private final CompanyServiceImp companyService;

	@Override
	public List<NoticeResponse> findAllNotices() {
		List<Notice> entities = noticeRepository.findAll();
		List<NoticeResponse> dtos = new ArrayList<>();

		for(Notice notice : entities) {
			NoticeResponse dto = noticeEntityToDto(notice);
			/* 회사 정보 */
			Company company = companyRepository.findCompanyById(notice.getCompany().getId());
			dto.setCompanyResponse(companyService.companyEntityToDto(company));

			dtos.add(dto);
		}

		return dtos;
	}

	@Override
	public List<NoticeResponse> findNoticesByCompanyId(Long companyId) {
		List<Notice> entities = noticeRepository.findNoticesByCompanyId(companyId);
		List<NoticeResponse> dtos = new ArrayList<>();

		for(Notice notice : entities) {
			NoticeResponse dto = noticeEntityToDto(notice);
			/* 회사 정보 */
			Company company = companyRepository.findCompanyById(notice.getCompany().getId());
			dto.setCompanyResponse(companyService.companyEntityToDto(company));
			dtos.add(dto);
		}

		return dtos;
	}

	@Override
	public NoticeDetailResponse findNoticeById(Long id) {
		Notice notice = noticeRepository.findNoticeById(id);
		NoticeResponse dto = noticeEntityToDto(notice);

		/* 회사 정보 */
		Company company = companyRepository.findCompanyById(notice.getCompany().getId());
		dto.setCompanyResponse(companyService.companyEntityToDto(company));

		NoticeDetailResponse detailDto = NoticeDetailResponse.builder()
				.noticeResponse(dto)
				.build();

		/* 같은 회사에서 올린 공고 List */
		List<Notice> entities = noticeRepository.findNoticesByCompanyId(company.getId());
		List<Long> ids = new ArrayList<>();
		for(Notice entity: entities) {
			ids.add(entity.getId());
		}

		detailDto.setContent(notice.getContent());
		detailDto.setCompanyNoticeIds(ids);
		return detailDto;
	}

	@Override
	public Long addNotice(NoticeRegisterRequest request) {
		Notice notice = Notice.builder()
				.position(request.getPosition())
				.commission(request.getCommission())
				.content(request.getContent())
				.skill(request.getSkill())
				.company(companyRepository.findCompanyById(request.getCompanyId()))
				.build();
		return noticeRepository.save(notice).getId();
	}

	@Override
	public NoticeDetailResponse modifyNotice(Long id, NoticeModifyRequest request) {
		Notice notice = noticeRepository.findNoticeById(id);
		notice.editNotice(request);
		noticeRepository.save(notice);
		return findNoticeById(id);
	}

	@Override
	public Long removeNotice(Long id) {
		noticeRepository.deleteById(id);
		return id;
	}

	public NoticeResponse noticeEntityToDto(Notice notice) {
		return NoticeResponse.builder()
				.id(notice.getId())
				.position(notice.getPosition())
				.commission(notice.getCommission())
				.skill(notice.getSkill())
				.build();
	}
}
