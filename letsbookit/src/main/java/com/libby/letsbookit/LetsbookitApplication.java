package com.libby.letsbookit;

import com.libby.letsbookit.model.User.MarketStaff;
import com.libby.letsbookit.repositories.userrepository.MarketStaffRepository;
import com.libby.letsbookit.repositories.userrepository.UserBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LetsbookitApplication {

	@Autowired
	private static UserBaseRepository<MarketStaff> marketStaffRepository;

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(LetsbookitApplication.class, args);

		marketStaffRepository = configurableApplicationContext.getBean(MarketStaffRepository.class);
		System.out.println("Success, program is running!");
	}

}
