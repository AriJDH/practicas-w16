package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ObetenerDiplomaApplicationTests {
	@Autowired
	StudentRepository repository;
	@Autowired
	StudentDAO studentDAO;



	@Test
	public void contextLoads() {

	}


	@Test
	public void testVoid()
	{
		StudentDTO studentDTO = new StudentDTO();
		assertNotNull(studentDTO);
	}


	@Test
	public void testNull()
	{
		StudentDTO studentDTO = new StudentDTO(null,null,null,null,null);
		assertNotNull(studentDTO);
	}


	@Test
	public void testInvalid()
	{
		StudentDTO studentDTO = new StudentDTO();
		assertNotNull(studentDTO);
	}

	@Test
	public void testSaveStudent(){
		StudentDTO studentDTO = new StudentDTO(13l,"sebastian","hola",10.0,null);
		studentDAO.save(studentDTO);

		assertEquals(studentDTO.getId(),studentDAO.findById(studentDTO.getId()).getId());
	}

	@Test
	public void testFindUserById()
	{
		StudentDTO studentDTO = new StudentDTO(13l,"sebastian","hola",10.0,null);
		studentDAO.save(studentDTO);
		studentDAO.delete(studentDTO.getId());

		assertDoesNotThrow()
		assertNotNull(studentDAO.findById(studentDTO.getId()));
	}










}