package com.wanted.prenoboarding.company.service;

import com.wanted.prenoboarding.company.dto.CompanyRegisterRequest;
import com.wanted.prenoboarding.company.dto.CompanyResponse;

public interface CompanyService {
	Long addCompany(CompanyRegisterRequest request);

	CompanyResponse findCompanyById(Long id);
}
