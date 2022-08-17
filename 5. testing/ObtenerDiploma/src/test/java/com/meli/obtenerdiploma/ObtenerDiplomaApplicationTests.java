package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ObtenerDiplomaApplicationTests {

	@Test
	public void contextLoads() {

	}

	@Test
	public void studentDTOSaveTest(){
		StudentDAO student = new StudentDAO();
		StudentDTO stu = new StudentDTO();
		stu.setId(1l);
		assertThrows();
	}

	@Test
	public void studentDTOGetByIdTest(){
		StudentDAO student = new StudentDAO();
		StudentDTO stu = new StudentDTO();
		stu.setId(1l);
		stu.setStudentName("Pedro");
		student.save(stu);
	}
}