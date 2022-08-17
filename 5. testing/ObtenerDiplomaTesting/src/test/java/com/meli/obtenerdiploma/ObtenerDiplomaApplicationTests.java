package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class ObtenerDiplomaApplicationTests {
	@Autowired
	IStudentDAO studentDAO;

	@Autowired
	IStudentRepository studentRepository;

	@Test
	public void saveStudentNull() {
		StudentDTO studentDTO = null;
		assertThrows(NullPointerException.class, () -> this.studentDAO.save(studentDTO));
	}

	@Test
	public void saveStudentEmptyTest() {
		StudentDTO studentDTO = new StudentDTO();
		this.studentDAO.save(studentDTO);
	}

	@Test
	public void saveStudent() {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setStudentName("Leandro Fernetti");
		studentDTO.setSubjects(Arrays.asList(
				new SubjectDTO("Matemáticas", 8D),
				new SubjectDTO("Lengua y Literatura", 8D),
				new SubjectDTO("Biología", 8D)
		));
		this.studentDAO.save(studentDTO);
		assertEquals(this.studentDAO.findById(6L).getStudentName(), "Leandro Fernetti");
	}

	@Test
	public void updateStudent(){
		StudentDTO studentDTO = this.studentDAO.findById(6L);
		studentDTO.setStudentName("Lea Fernetti");
		this.studentDAO.save(studentDTO);
		assertEquals(this.studentDAO.findById(7L).getStudentName(), "Lea Fernetti");
	}

	@Test
	public void deleteStudent(){
		this.studentDAO.delete(7L);
		assertThrows(StudentNotFoundException.class, () -> this.studentDAO.findById(7L));
	}

	@Test
	public void findAllTest(){
		assertNotNull(this.studentRepository.findAll());
	}
}