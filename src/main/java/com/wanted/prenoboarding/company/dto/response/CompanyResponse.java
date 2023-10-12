package com.wanted.prenoboarding.company.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyResponse {
	private Long id;
	private String name;
	private String country;
	private String region;
}
