package com.fifteenth.project.springaop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fifteenth.project.springaop.dao.AccountDAO;
import com.fifteenth.project.springaop.dao.MembershipDAO;
import com.fifteenth.project.springaop.model.Account;

@SpringBootApplication
public class SpringaopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringaopApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return _ -> {

			System.out.println("Application is now started running!\n");

			// addAccBeforeAdvice(accountDAO);
			// addAccBeforeAdvice(membershipDAO);

			getAccAfterReturningAdvice(accountDAO);

		};
	}

	private void getAccAfterReturningAdvice(AccountDAO accountDAO) {
		
		// Diplaying the accounts
		for (Account account : accountDAO.findAccounts()) {
			System.out.println("\t\t"+account);
		}
		System.out.println("");

	}

	private void addAccBeforeAdvice(MembershipDAO membershipDAO) {
		
		// calling the add acc method from the MembershipDAO
		membershipDAO.addAccount();

		// calling the add Membership Profile method from the MembershipDAO
		membershipDAO.addProfile();

		// calling to check Membership activation status
		membershipDAO.isActive();

		// calling MembershipDAO's getters and setters
		membershipDAO.setMemberName("Toddler");
		membershipDAO.getMemberName();
		membershipDAO.setMemberId(12);
		membershipDAO.getMemberId();

	}

	private void addAccBeforeAdvice(AccountDAO accountDAO) {
		
		// calling the add acc method from the DAO
		accountDAO.addAccount();

		// Calling the method with object as a parameter to check if the aspect is running first
		accountDAO.addAccount(new Account());

		// Calling the method & passing Account obj and a string as parameter
		accountDAO.addAccount(new Account(), "Admin");

		// Calling to check account status
		accountDAO.status("");

	}

}
