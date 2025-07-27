package com.fifteenth.project.springaop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fifteenth.project.springaop.dao.AccountDAO;
import com.fifteenth.project.springaop.dao.MembershipDAO;

@SpringBootApplication
public class SpringaopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringaopApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return _ -> {

			System.out.println("Application is now started running!\n");

			addAccBeforeAdvice(accountDAO);
			addAccBeforeAdvice(membershipDAO);

		};
	}

	private void addAccBeforeAdvice(MembershipDAO membershipDAO) {
		
		// calling the add acc method from the MembershipDAO
		membershipDAO.addAccount();

		// calling the add Membership Profile method from the MembershipDAO
		membershipDAO.addProfile();

	}

	private void addAccBeforeAdvice(AccountDAO accountDAO) {
		
		// calling the add acc method from the DAO
		accountDAO.addAccount();

		// Calling the method one more time to check if the aspect is running first again
		accountDAO.addAccount();

	}

}
