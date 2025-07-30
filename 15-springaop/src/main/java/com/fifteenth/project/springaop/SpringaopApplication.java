package com.fifteenth.project.springaop;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fifteenth.project.springaop.dao.AccountDAO;
import com.fifteenth.project.springaop.dao.MembershipDAO;
import com.fifteenth.project.springaop.model.Account;
import com.fifteenth.project.springaop.service.TrafficMonitorService;

@SpringBootApplication
public class SpringaopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringaopApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
		AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficMonitorService trafficMonitorService
		) {
		return _ -> {

			System.out.println("Application is now started running!\n");

			// addAccBeforeAdvice(accountDAO);
			// addAccBeforeAdvice(membershipDAO);

			// getAccAfterReturningAdvice(accountDAO);
			// getAccAfterThrowingAndAfterAdvice(accountDAO);

			// getTrafficStatusAroundAdvice(trafficMonitorService);
			getTrafficAroundAdviceHandleException(trafficMonitorService);

		};
	}

	private void getTrafficAroundAdviceHandleException(TrafficMonitorService trafficMonitorService) {
		
		System.out.println("\n.... Fetching traffic status from commandLineRunner ....\n");
	
		// trigger-variable to generate exception
		boolean isException = true;

		String status = "";
		try {
			// store the traffic status
			status = trafficMonitorService.getTrafficStatus(isException);
		} catch (Exception e) {
			// or else store the exception message
			status = e.getMessage();
		}
		
		System.out.println("\nStatus: "+status+"\n");

	}

	private void getTrafficStatusAroundAdvice(TrafficMonitorService trafficMonitorService) {
		
		System.out.println("\n.... Fetching traffic status from commandLineRunner ....\n");

		// Display the traffic status
		System.out.println("\nStatus: "+trafficMonitorService.getTrafficStatus()+"\n");

	}

	private void getAccAfterThrowingAndAfterAdvice(AccountDAO accountDAO) {
		
		// create a list of Account obj
		List<Account> accounts = null;

		// trigger-variable to generate exception
		boolean isException = true;

		// try-catch block to simulate exception handling
		try {
			accounts = accountDAO.findAccounts(isException);
		} catch (Exception e) {
			System.out.println("\n\t\tException displaying from commandLineRunner: "+e.getMessage());
		}

		// Diplaying the accounts
		if (accounts != null) {
			for (Account account : accounts) {
				System.out.println("\t\t"+account);
			}
			System.out.println("");
		}
		else {
			System.out.println("\t\tAccount: ["+accounts+"]\n");
		}

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
