package com.cognizant.orm_learn;
import java.util.*;

import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.model.Country;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService cs;
		
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		cs = context.getBean(CountryService.class);
		testGetAllCountries();
	    LOGGER.info("Inside main");
	}
	private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = cs.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End");
    }


}
