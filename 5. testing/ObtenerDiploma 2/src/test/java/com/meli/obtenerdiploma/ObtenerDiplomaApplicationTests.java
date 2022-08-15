package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootTest
class ObtenerDiplomaApplicationTests {

	private Validator validator;
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private StudentRepository studentRepository ;

	@BeforeEach
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void studentNullName() {
		StudentDTO student = new StudentDTO();

		List<SubjectDTO> subjects = new ArrayList<>();
		subjects.add(new SubjectDTO("Maths", 9.0));

		student.setSubjects(subjects);
		Set<ConstraintViolation<StudentDTO>> constraintViolations = validator.validate(student);

		//constraintViolations.forEach(System.out::println);
		Assertions.assertEquals(1, constraintViolations.size());
	}

	@Test
	public void studentBlankName() {
		StudentDTO student = new StudentDTO();
		student.setStudentName(" ");

		List<SubjectDTO> subjects = new ArrayList<>();
		subjects.add(new SubjectDTO("Maths", 9.0));

		student.setSubjects(subjects);
		Set<ConstraintViolation<StudentDTO>> constraintViolations = validator.validate(student);

		//constraintViolations.forEach(System.out::println);
		Assertions.assertEquals(2, constraintViolations.size());
	}

	@Test
	public void studentInvalidName() {
		StudentDTO student = new StudentDTO();
		student.setStudentName("juan");

		List<SubjectDTO> subjects = new ArrayList<>();
		subjects.add(new SubjectDTO("Maths", 9.0));

		student.setSubjects(subjects);
		Set<ConstraintViolation<StudentDTO>> constraintViolations = validator.validate(student);

		//constraintViolations.forEach(System.out::println);
		Assertions.assertEquals(1, constraintViolations.size());

		Assertions.assertEquals("El nombre del estudiante debe comenzar con mayúscula.", constraintViolations.iterator().next().getMessage());
	}


	@Test
	public void studentLongName() {
		StudentDTO student = new StudentDTO();
		student.setStudentName("Juanjuanjuanjuanjuanjuanjuanjuanjuanjuanjuanjuanjuanjuanjuanjua");

		List<SubjectDTO> subjects = new ArrayList<>();
		subjects.add(new SubjectDTO("Maths", 9.0));

		student.setSubjects(subjects);
		Set<ConstraintViolation<StudentDTO>> constraintViolations = validator.validate(student);

		//constraintViolations.forEach(System.out::println);
		Assertions.assertEquals(1, constraintViolations.size());

		Assertions.assertEquals("La longitud del nombre del estudiante no puede superar los 50 caracteres.", constraintViolations.iterator().next().getMessage());
	}


	@Test
	public void studentEmptySubjects() {
		StudentDTO student = new StudentDTO();
		student.setStudentName("Juan");
		student.setSubjects(new ArrayList<>());

		Set<ConstraintViolation<StudentDTO>> constraintViolations = validator.validate(student);

		//constraintViolations.forEach(System.out::println);
		Assertions.assertEquals(1, constraintViolations.size());

		Assertions.assertEquals("La lista de materias no puede estar vacía.", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void blankSubjectName() {
		SubjectDTO subject = new SubjectDTO(" ", 9.0);

		Set<ConstraintViolation<SubjectDTO>> constraintViolations = validator.validate(subject);

		//constraintViolations.forEach(System.out::println);
		Assertions.assertEquals(2, constraintViolations.size());
	}

	@Test
	public void nullSubjectName() {
		SubjectDTO subject = new SubjectDTO(null, 9.0);

		Set<ConstraintViolation<SubjectDTO>> constraintViolations = validator.validate(subject);
		//constraintViolations.forEach(System.out::println);

		Assertions.assertEquals(1, constraintViolations.size());
		Assertions.assertEquals("El nombre de la materia no puede estar vacío.", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void invalidSubjectName() {
		SubjectDTO subject = new SubjectDTO("MathMathMathMathMathMathMathMathMathMathMathMath", 9.0);

		Set<ConstraintViolation<SubjectDTO>> constraintViolations = validator.validate(subject);
		//constraintViolations.forEach(System.out::println);

		Assertions.assertEquals(1, constraintViolations.size());
		Assertions.assertEquals("La longitud del nombre de la materia no puede superar los 30 caracteres.", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void nullSubjectScore() {
		SubjectDTO subject = new SubjectDTO("Maths", null);

		Set<ConstraintViolation<SubjectDTO>> constraintViolations = validator.validate(subject);
		//constraintViolations.forEach(System.out::println);

		Assertions.assertEquals(1, constraintViolations.size());
		Assertions.assertEquals("La nota de la materia no puede estar vacía.", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void maxSubjectScore() {
		SubjectDTO subject = new SubjectDTO("Maths", 12.0);

		Set<ConstraintViolation<SubjectDTO>> constraintViolations = validator.validate(subject);
		//constraintViolations.forEach(System.out::println);

		Assertions.assertEquals(1, constraintViolations.size());
		Assertions.assertEquals("La nota máxima de la materia es de 10 pts.", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void minSubjectScore() {
		SubjectDTO subject = new SubjectDTO("Maths", -1.0);

		Set<ConstraintViolation<SubjectDTO>> constraintViolations = validator.validate(subject);
		//constraintViolations.forEach(System.out::println);

		Assertions.assertEquals(1, constraintViolations.size());
		Assertions.assertEquals("La nota mínima de la materia es de 0 pts.", constraintViolations.iterator().next().getMessage());
	}


	@Test
	public void addStudent(){
		List<SubjectDTO> subjects = new ArrayList<>();
		subjects.add(new SubjectDTO("Maths", 9.0));

		StudentDTO student = new StudentDTO(123L, "Juan", "msg", 7.5, subjects);

		studentDAO.save(student);

		Assertions.assertTrue(studentDAO.exists(student));
	}

	@Test
	public void addNullStudent(){
		Assertions.assertThrows(NullPointerException.class, () -> studentDAO.save(null));
	}

	@Test
	public void getStudent(){
		Assertions.assertDoesNotThrow(() -> { studentDAO.findById(2L); } );
		Assertions.assertNotNull(studentDAO.findById(2L));
	}

	@Test
	public void getInvalidStudent(){
		Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(22L));
	}

	@Test
	public void getNullStudent(){
		Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(null));
	}

	@Test
	public void updateStudent(){
		StudentDTO student = studentDAO.findById(2L);
		student.setMessage("Nuevo mensaje");
		studentDAO.save(student);

		Assertions.assertEquals(studentDAO.findById(2L).getMessage(),"Nuevo mensaje");
	}

	@Test
	public void deleteStudent(){
		StudentDTO student = studentDAO.findById(2L);

		studentDAO.delete(2L);

		Assertions.assertFalse(studentDAO.exists(student));

		studentDAO.save(student);
	}

	@Test
	public void deleteInvalidStudent(){
		Assertions.assertDoesNotThrow(() -> { studentDAO.delete(22L); });
	}

	@Test
	public void deleteNullStudent(){
		Assertions.assertDoesNotThrow(() -> { studentDAO.delete(22L); });
	}

	@Test
	public void getStudents(){
		Set<StudentDTO> students = studentRepository.findAll();
		Assertions.assertEquals(2, students.size());

		students.forEach(s -> Assertions.assertTrue(studentDAO.exists(s)));
	}
}