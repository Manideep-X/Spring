package com.thirdjava.project.hibernatejpa;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.thirdjava.project.hibernatejpa.dao.StudentDAO;
import com.thirdjava.project.hibernatejpa.entity.StudentData;

@SpringBootApplication
public class HibernatejpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatejpaApplication.class, args);
	}

	@Bean
	CommandLineRunner running(StudentDAO studentDAO) {//This will execute after the Spring Beans has been loaded
		return args -> {
			System.out.println("\n\nI hope it's running ..." + args + "\n\n");
			createStudentData(studentDAO);
			// findStudentById(studentDAO);
			// fetchAllStudent(studentDAO);
			// fetchByEmail(studentDAO);
			// updateFirstName(studentDAO);
			// updateEmail(studentDAO);
			// deleteUsingFirst(studentDAO);
			// deleteUsingId(studentDAO);
		};
	}
	// Same code without Lambda
	// @Bean
	// public CommandLineRunner commandLineRunner() {
	// 	return new CommandLineRunner() {
	// 		@Override
	// 		public void run(String... args) throws Exception {
	// 			System.out.println("Hello world");
	// 		}
	// 	};
	// }

	private void deleteUsingId(StudentDAO studentDAO) {
		
		int id = 12;
		System.out.println("\n\nDeleting user with ID: "+id+" ...");

		try {
			studentDAO.deleteUsingId(id);
			System.out.println("Student with id: "+id+" is deleted successfully\n");
		} catch (Exception e) {
			System.out.println(e);
			// e.printStackTrace();
		}

	}

	private void deleteUsingFirst(StudentDAO studentDAO) {
		
		String firstName = "";
		System.out.println("\n\nDeleting user data who don't have first name ...");
		int rowNo = studentDAO.deleteList(firstName);
		System.out.println(rowNo+" number of rows has changed\n");

	}

	private void updateEmail(StudentDAO studentDAO) {
		
		String emailStr = "us@gmail.com";
		String newEmail = "america.us@gmail.co.us";
		System.out.println("\n\nUpdating Email of student ...");
		
		int noOfRows = studentDAO.updateEmail(emailStr, newEmail);
		System.out.println(noOfRows+" number of rows has changed\n");

	}

	private void updateFirstName(StudentDAO studentDAO) {
		
		int id = 4;
		String str = "Haruto";
		System.out.println("\n\nFetching data of student with id: "+id+" ...");
		String oldFirstName = studentDAO.findByID(id).getFirstName()+" "+studentDAO.findByID(id).getLastName();

		System.out.println("Updating student's first name to: "+str+" ...");
		studentDAO.updateFirstName(id, str);

		System.out.println("Successfully updated !!\nOLD name: "+oldFirstName+"\nNEW name: "+studentDAO.findByID(id).getFirstName()+" "+studentDAO.findByID(id).getLastName()+"\n");

	}

	private void fetchByEmail(StudentDAO studentDAO) {
		
		System.out.println("\n\nFetching data of selected students ...");
		String str = "us@gmail.com";
		List<StudentData> studentDataEmail = studentDAO.findByEmail(str);

		System.out.println("Data of Students with email like "+str+" :");
		for (StudentData studentData : studentDataEmail) {
			System.out.println(studentData.getId()+". "+studentData.getFirstName()+" "+studentData.getLastName()+"\t\tEmail: "+studentData.getEmail());
		}

	}
	
	private void fetchAllStudent(StudentDAO studentDAO) {
		
		System.out.println("\n\nFetching data of all students ...");
		List<StudentData> allStudentData = studentDAO.findAllStudent();

		System.out.println("Data of all Students :");
		for (StudentData studentData : allStudentData) {
			System.out.println(studentData.getId()+". "+studentData.getFirstName()+" "+studentData.getLastName()+"\t\tEmail: "+studentData.getEmail());
		}
		System.out.println("\n");

	}

	private void findStudentById(StudentDAO studentDAO) {
		
		int id = 4;
		System.out.println("\n\nFinding student with id "+id+" ...");
		StudentData studentById = studentDAO.findByID(id);

		if (studentById != null) {
			System.out.println("Student found and the details are: \n"+studentById+"\n\n");
		} else {
			System.out.println("Student not found !!\n\n");
		}

	}

	private void createStudentData(StudentDAO studentDAO) {
		
		System.out.println("\n\nCreating Student's data ...");
		StudentData tempStudentData = new StudentData("Takanashi", "Kamada", "thisemail.jp@gmail.com");
		StudentData tempStudentData1 = new StudentData("Takanashi", "Kamada", "thisemail.jp@gmail.com");
		StudentData tempStudentData2 = new StudentData("Takanashi", "Kamada", "thisemail.jp@gmail.com");
		StudentData tempStudentData3 = new StudentData("Takanashi", "Kamada", "thisemail.jp@gmail.com");
		StudentData tempStudentData4 = new StudentData("Takanashi", "Kamada", "thisemail.jp@gmail.com");

		System.out.println("Storing it into the DB ...");
		studentDAO.save(tempStudentData);
		studentDAO.save(tempStudentData1);
		studentDAO.save(tempStudentData2);
		studentDAO.save(tempStudentData3);
		studentDAO.save(tempStudentData4);

		System.out.println("Student data is stored. ID generated is: "+tempStudentData.getId()+" to "+tempStudentData4.getId()+"\n\n");

	}


}
