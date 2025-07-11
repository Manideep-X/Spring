package com.fourteenth.project.advancemapping;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fourteenth.project.advancemapping.model.Course;
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

			/* FOR ONE-TO-ONE RELATIONSHIP */
			// createInstructor(generalDAO);
			// findInstructorById(generalDAO);
			// deleteInstructorById(generalDAO);
			// findInstructorDetailById(generalDAO);
			// deleteInstructorDetailById(generalDAO);

			/* FOR ONE-TO-MANY/MANY-TO-ONE RELATIONSHIP */
			// createInstructorAndCourse(generalDAO);
			// findInstructorWithCourse(generalDAO);
			findCoursesByInstructor(generalDAO);
		};

	}

	private void findCoursesByInstructor(GeneralDAO generalDAO) {
		
		int id = 10;

		System.out.println("\n\nFinding instructor details with ID: "+id+"...\n");
		Instructor instructor = generalDAO.findInstructorById(id);
		System.out.println("\n\n"+instructor);

		List<Course> courses = generalDAO.findCoursesByInstructorId(id);

		instructor.setCourses(courses);
		System.out.println("\n\nCourses are ...");
		for (Course course : instructor.getCourses()) {
			System.out.println(course);
		}

	}

	private void findInstructorWithCourse(GeneralDAO generalDAO) {
		
		int id = 9;
		System.out.println("\n\nFinding instructor details with ID: "+id+"...\n");

		Instructor instructor = generalDAO.findInstructorById(id);

		System.out.println("\n\n"+instructor);
		System.out.println("\n\n"+instructor.getCourses());

	}

	private void createInstructorAndCourse(GeneralDAO generalDAO) {
		
		Instructor instructor = new Instructor("John","Gomez","john.gomez@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com","Drawing");

		// This will associate both the objects
		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("JPA/Hibernate with Spring MVC");
		Course course2 = new Course("Spring Boot with Spring AOP");

		instructor.add(course1);
		instructor.add(course2);

		System.out.println("\n\nSaving the new instructor and other details ...");
		System.out.println(instructor);
		System.out.println(instructor.getCourses());
		// This will also save the instructorDetails and courses object because of CascadeType.PERSIST
		generalDAO.save(instructor);
		System.out.println("\nsaved");

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
