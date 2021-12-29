package com.creditscore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.creditscore.model.CreditScore;

public interface CreditScoreRepo extends JpaRepository<CreditScore, String> {

}
