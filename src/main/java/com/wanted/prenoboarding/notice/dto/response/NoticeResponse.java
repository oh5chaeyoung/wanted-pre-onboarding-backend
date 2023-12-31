package com.wanted.prenoboarding.notice.dto.response;

import com.wanted.prenoboarding.company.dto.response.CompanyResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoticeResponse {
	private Long id;
	private String position;
	private String commission;
	private String skill;
	private CompanyResponse companyResponse;
}
