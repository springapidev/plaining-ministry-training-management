package bd.gov.plandiv.pdts.serviceimpl;

import bd.gov.plandiv.pdts.entity.Employee;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplSymflowerTest {
	@Test
	public void delete1() {
		EmployeeServiceImpl e = null; // TODO This is a fallback value due to incomplete analysis.
		Long id = null; // TODO This is a fallback value due to incomplete analysis.
		boolean expected = false; // TODO This is a fallback value due to incomplete analysis.
		boolean actual = e.delete(id);

		assertEquals(expected, actual);
	}

	@Test
	public void findAll2() {
		EmployeeServiceImpl e = null; // TODO This is a fallback value due to incomplete analysis.
		List<Employee> expected = null; // TODO This is a fallback value due to incomplete analysis.
		List<Employee> actual = e.findAll();

		assertEquals(expected, actual);
	}

	@Test
	public void findByEmail3() {
		EmployeeServiceImpl e = null; // TODO This is a fallback value due to incomplete analysis.
		String email = null; // TODO This is a fallback value due to incomplete analysis.
		Optional expected = null; // TODO This is a fallback value due to incomplete analysis.
		Optional actual = e.findByEmail(email);

		assertEquals(expected, actual);
	}

	@Test
	public void findById4() {
		EmployeeServiceImpl e = null; // TODO This is a fallback value due to incomplete analysis.
		Long id = null; // TODO This is a fallback value due to incomplete analysis.
		Optional expected = null; // TODO This is a fallback value due to incomplete analysis.
		Optional actual = e.findById(id);

		assertEquals(expected, actual);
	}

	@Test
	public void isExistByEmail5() {
		EmployeeServiceImpl e = null; // TODO This is a fallback value due to incomplete analysis.
		String email = null; // TODO This is a fallback value due to incomplete analysis.
		boolean expected = false; // TODO This is a fallback value due to incomplete analysis.
		boolean actual = e.isExistByEmail(email);

		assertEquals(expected, actual);
	}

	@Test
	public void isExistById6() {
		EmployeeServiceImpl e = null; // TODO This is a fallback value due to incomplete analysis.
		Long id = null; // TODO This is a fallback value due to incomplete analysis.
		boolean expected = false; // TODO This is a fallback value due to incomplete analysis.
		boolean actual = e.isExistById(id);

		assertEquals(expected, actual);
	}

	@Test
	public void save7() {
		EmployeeServiceImpl e = null; // TODO This is a fallback value due to incomplete analysis.
		Employee employee = null; // TODO This is a fallback value due to incomplete analysis.
		boolean expected = false; // TODO This is a fallback value due to incomplete analysis.
		boolean actual = e.save(employee);

		assertEquals(expected, actual);
	}

	@Test
	public void update8() {
		EmployeeServiceImpl e = null; // TODO This is a fallback value due to incomplete analysis.
		Employee employee = null; // TODO This is a fallback value due to incomplete analysis.
		boolean expected = false; // TODO This is a fallback value due to incomplete analysis.
		boolean actual = e.update(employee);

		assertEquals(expected, actual);
	}
}
