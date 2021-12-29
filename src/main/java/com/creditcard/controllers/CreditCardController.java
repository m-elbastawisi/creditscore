package com.creditcard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.creditcard.model.CreditCard;
import com.creditcard.model.CreditScore;
import com.creditcard.repository.CreditCardRepo;

@RestController
public class CreditCardController {
	
	@Autowired
	CreditCardRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@PostMapping("/issueCard")
	public boolean issueCard(@RequestBody CreditCard card)
	{
		if (getScore(card.getSsn())>= 700) {
			repo.save(card);
			return true;
		}
		return false;
	}


	private int getScore(String ssn) {
		// TODO Auto-generated method stub
		 CreditScore creditScore=restTemplate.getForObject("http://creditscore-app:8080/creditscore/creditscores/"+ssn, CreditScore.class);
		return creditScore.getScore();
	}

}
