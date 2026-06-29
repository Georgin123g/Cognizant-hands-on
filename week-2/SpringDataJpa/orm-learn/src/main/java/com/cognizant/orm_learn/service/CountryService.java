package com.cognizant.orm_learn.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;

import java.util.*;

@Service
public class CountryService {
	@Autowired
	CountryRepository cr;
	
	@Transactional
	public List<Country> getAllCountries(){
		return cr.findAll();
	}
}
