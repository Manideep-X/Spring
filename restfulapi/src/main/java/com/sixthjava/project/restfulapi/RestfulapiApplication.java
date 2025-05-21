package com.sixthjava.project.restfulapi;

// import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sixthjava.project.restfulapi.DAO.StudentDAO;
// import com.sixthjava.project.restfulapi.entity.StudentData;

@SpringBootApplication
public class RestfulapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulapiApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return args -> {
			
			System.out.println("\n\nExecuting as expected, Object value: "+args+"\n");

			// createStudent(studentDAO);
			// findById(studentDAO);
			// displayAll(studentDAO);

		};
	}

	// private void displayAll(StudentDAO studentDAO) {
		
	// 	System.out.println("\n\nDisplaying all Student details: ");
	// 	List<StudentData> allStudentDatas = studentDAO.displayAll();

	// 	for (StudentData studentData : allStudentDatas) {
	// 		System.out.println(studentData);
	// 	}
	// 	System.out.println("\n");

	// }

	// private void findById(StudentDAO studentDAO) {
		
	// 	int id = 3;
	// 	StudentData studentData = studentDAO.findById(id);
	// 	if (studentData == null) {
	// 		System.out.println("\n\nStudent Not Found !!\n");
	// 	} else {
	// 		System.out.println("\n\nStudent found ! INFO: \n"+studentData+"\n");
	// 	}

	// }

	// private void createStudent(StudentDAO studentDAO) {
		
	// 	StudentData studentData1 = new StudentData("Manideep","Bhattacharyya","example@gmail.com");
	// 	studentDAO.save(studentData1);
	// 	studentDAO.save(new StudentData("Aoi","Taneshima","aoichan.jp@gmail.com"));
	// 	studentDAO.save(new StudentData("Haruta","Yamada","harutakun.jp@gmail.com"));
	// 	studentDAO.save(new StudentData("Tenkuji","Kenji","tenkujisan.jp@gmail.com"));
	// 	studentDAO.save(new StudentData("Kotori","Watanabe","kotorisan.jp@gmail.com"));

	// }

}
