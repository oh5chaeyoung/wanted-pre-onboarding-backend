package com.wanted.prenoboarding.company.dto;

import lombok.Data;

@Data
public class CompanyResponse {
	private Long id;
	private String name;
	private String country;
	private String region;
}
