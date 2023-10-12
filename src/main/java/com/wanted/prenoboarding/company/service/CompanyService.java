package com.wanted.prenoboarding.company.service;

import com.wanted.prenoboarding.company.dto.request.CompanyRegisterRequest;
import com.wanted.prenoboarding.company.dto.response.CompanyResponse;

public interface CompanyService {
	Long addCompany(CompanyRegisterRequest request);

	CompanyResponse findCompanyById(Long id);
}
