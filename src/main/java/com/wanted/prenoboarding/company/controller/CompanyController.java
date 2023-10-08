package com.wanted.prenoboarding.company.controller;

import com.wanted.prenoboarding.company.dto.CompanyRegisterRequest;
import com.wanted.prenoboarding.company.dto.CompanyResponse;
import com.wanted.prenoboarding.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
	private final CompanyService companyService;
	@GetMapping("/{companyId}")
	public ResponseEntity<CompanyResponse> companyDetails(@PathVariable("companyId") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(companyService.findCompanyById(id));
	}
	@PostMapping
	public ResponseEntity<Long> companyAdd(@RequestBody CompanyRegisterRequest request) {
		return ResponseEntity.status(HttpStatus.OK).body(companyService.addCompany(request));
	}
}
