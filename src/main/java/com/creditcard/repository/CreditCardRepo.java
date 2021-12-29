package com.creditcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creditcard.model.CreditCard;

public interface CreditCardRepo extends JpaRepository<CreditCard, String>{

}
