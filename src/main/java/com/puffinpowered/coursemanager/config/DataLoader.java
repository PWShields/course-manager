/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.puffinpowered.coursemanager.config;

import com.puffinpowered.coursemanager.domain.Course;
import com.puffinpowered.coursemanager.domain.CourseStatus;
import com.puffinpowered.coursemanager.domain.Provider;
import com.puffinpowered.coursemanager.repository.CourseRepository;
import com.puffinpowered.coursemanager.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *  Load some demonstration data at startup as we are using an in-memory database
 */
@Component
public class DataLoader implements CommandLineRunner {

	private final CourseRepository courseRepository;

	private final ProviderRepository providerRepository;

	@Autowired
	public DataLoader(CourseRepository courseRepository, ProviderRepository providerRepository) {
		this.courseRepository = courseRepository;
		this.providerRepository = providerRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		Provider udemy = new Provider("Udemy");
		this.providerRepository.save(udemy);
		Course course = new Course("Hibernate and Java Persistence API", udemy);
		course.setDatePurchased(LocalDate.of(2017, 2, 5));
		course.setStatus(CourseStatus.PURCHASED);
		course.setPurchasePrice(new BigDecimal(15));
		this.courseRepository.save(course);
	}
}
