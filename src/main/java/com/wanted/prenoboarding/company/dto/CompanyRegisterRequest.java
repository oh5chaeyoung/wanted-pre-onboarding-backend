package com.wanted.prenoboarding.company.dto;

import lombok.Data;

@Data
public class CompanyRegisterRequest {
	private String name;
	private String country;
	private String region;
}
