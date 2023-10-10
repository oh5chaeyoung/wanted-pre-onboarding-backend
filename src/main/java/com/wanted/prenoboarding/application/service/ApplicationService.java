package com.wanted.prenoboarding.application.service;

import com.wanted.prenoboarding.application.dto.ApplicationRegisterRequest;

public interface ApplicationService {
	Long addApplication(ApplicationRegisterRequest request);
}
