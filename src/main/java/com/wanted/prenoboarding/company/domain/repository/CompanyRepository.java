package com.wanted.prenoboarding.company.domain.repository;

import com.wanted.prenoboarding.company.domain.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
