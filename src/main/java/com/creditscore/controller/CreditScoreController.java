package com.creditscore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.creditscore.model.CreditScore;
import com.creditscore.repository.CreditScoreRepo;

@RestController
public class CreditScoreController {
	@Autowired
	CreditScoreRepo repo;
	
	@GetMapping("/creditscores/{ssn}")
	public CreditScore get(@PathVariable("ssn") String  ssn) {
		return repo.findById(ssn).get();
	}

}
