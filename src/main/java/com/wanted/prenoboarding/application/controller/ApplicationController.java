package com.wanted.prenoboarding.application.controller;

import com.wanted.prenoboarding.application.dto.ApplicationRegisterRequest;
import com.wanted.prenoboarding.application.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
public class ApplicationController {
	private final ApplicationService applicationService;

	@PostMapping
	public ResponseEntity<Long> applicationAdd(@RequestBody ApplicationRegisterRequest request) {
		return ResponseEntity.status(HttpStatus.OK).body(applicationService.addApplication(request));
	}
}
