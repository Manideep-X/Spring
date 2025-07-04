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

			createInstructor(generalDAO);
		};

	}

	private void createInstructor(GeneralDAO generalDAO) {
		
		Instructor instructor = new Instructor("Diego","James","diego.james@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("google.com","Video Games");

		// This will associate both the objects
		instructor.setInstructorDetail(instructorDetail);

		// This will save the instructorDetail object because of CascadeType.ALL
		generalDAO.save(instructor);

	}

}
