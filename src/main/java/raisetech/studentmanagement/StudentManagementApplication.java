package raisetech.studentmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import raisetech.studentmanagement.repository.StudentRepository;
import raisetech.studentmanagement.service.StudentsCourses;

import java.util.List;

@SpringBootApplication

public class StudentManagementApplication {



	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}





}













