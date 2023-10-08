package com.wanted.prenoboarding.company.service;

import com.wanted.prenoboarding.company.domain.entity.Company;
import com.wanted.prenoboarding.company.domain.repository.CompanyRepository;
import com.wanted.prenoboarding.company.dto.CompanyRegisterRequest;
import com.wanted.prenoboarding.company.dto.CompanyResponse;
import com.wanted.prenoboarding.exception.CompanyNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImp implements CompanyService{
	private final CompanyRepository companyRepository;
	@Override
	public Long addCompany(CompanyRegisterRequest request) {
		Company company = Company.builder()
				.name(request.getName())
				.country(request.getCountry())
				.region(request.getRegion())
				.build();
		return companyRepository.save(company).getId();
	}
	@Override
	public CompanyResponse findCompanyById(Long id) {
		Company company = companyRepository.findById(id)
				.orElseThrow(() -> new CompanyNotFoundException("회사 정보가 없습니다."));

		return CompanyResponse.builder()
				.id(company.getId())
				.name(company.getName())
				.country(company.getCountry())
				.region(company.getRegion())
				.build();
	}
}
