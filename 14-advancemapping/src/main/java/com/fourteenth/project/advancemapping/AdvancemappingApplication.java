package com.fourteenth.project.advancemapping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fourteenth.project.advancemapping.model.Instructor;
import com.fourteenth.project.advancemapping.model.InstructorDetail;
import com.fourteenth.project.advancemapping.repository.GeneralDAO;

@SpringBootApplication
public class AdvancemappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancemappingApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(GeneralDAO generalDAO) {

		return args -> {
			System.out.println("\n"+args);

			// createInstructor(generalDAO);
			findInstructorById(generalDAO);
			// deleteInstructorById(generalDAO);
			findInstructorDetailById(generalDAO);
			deleteInstructorDetailById(generalDAO);
		};

	}

	private void deleteInstructorDetailById(GeneralDAO generalDAO) {

		int id = 3;
		System.out.println("\n\nDeleting the instructor Detail with ID : "+id+" ...");
		generalDAO.deleteInstructorDetailById(id);
		System.out.println("\n\nDeleted successfully!");
	
	}

	private void findInstructorDetailById(GeneralDAO generalDAO) {
		
		int id = 1;
		System.out.println("\n\nFinding Instructor Detail by ID : "+id+" ...");
		InstructorDetail instructorDetail = generalDAO.findInstructorDetailById(id);
		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor()+"\n");

	}

	private void deleteInstructorById(GeneralDAO generalDAO) {
		
		int id = 2;
		System.out.println("\n\nDeleting the instructor with ID : "+id+" ...");
		Instructor instructor = generalDAO.deleteInstructorById(id);
		System.out.println("\n\nDeleted successfully! Deleted instructor is:");
		System.out.println(instructor);
		System.out.println(instructor.getInstructorDetail()+"\n");

	}

	private void findInstructorById(GeneralDAO generalDAO) {
		
		int id = 1;
		System.out.println("\n\nFinding Instructor by ID : "+id+" ...");
		Instructor instructor = generalDAO.findInstructorById(id);
		System.out.println(instructor);
		System.out.println(instructor.getInstructorDetail()+"\n");

	}

	private void createInstructor(GeneralDAO generalDAO) {
		
		Instructor instructor = new Instructor("Sam","Altman","sam.altman@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("openai.com","Making money");

		// This will associate both the objects
		instructor.setInstructorDetail(instructorDetail);

		System.out.println("\nSaving the new instructor and other details ...");
		// This will also save the instructorDetail object because of CascadeType.ALL
		generalDAO.save(instructor);
		System.out.println("saved");

	}

}
