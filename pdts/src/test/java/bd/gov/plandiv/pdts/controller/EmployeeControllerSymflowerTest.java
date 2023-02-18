package bd.gov.plandiv.pdts.controller;

import bd.gov.plandiv.pdts.entity.Employee;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public class EmployeeControllerSymflowerTest {
	@Test
	public void save1() {
		EmployeeController e = null; // TODO This is a fallback value due to incomplete analysis.
		Employee employee = null; // TODO This is a fallback value due to incomplete analysis.
		BindingResult result = null; // TODO This is a fallback value due to incomplete analysis.
		Model model = null; // TODO This is a fallback value due to incomplete analysis.
		String expected = null; // TODO This is a fallback value due to incomplete analysis.
		String actual = e.save(employee, result, model);

		assertEquals(expected, actual);
	}

	@Test
	public void showAdd2() {
		EmployeeController e = null; // TODO This is a fallback value due to incomplete analysis.
		Model model = null; // TODO This is a fallback value due to incomplete analysis.
		String expected = null; // TODO This is a fallback value due to incomplete analysis.
		String actual = e.showAdd(model);

		assertEquals(expected, actual);
	}

	@Test
	public void showList3() {
		EmployeeController e = null; // TODO This is a fallback value due to incomplete analysis.
		Model model = null; // TODO This is a fallback value due to incomplete analysis.
		String expected = null; // TODO This is a fallback value due to incomplete analysis.
		String actual = e.showList(model);

		assertEquals(expected, actual);
	}

	@Test
	public void showUpdate4() {
		EmployeeController e = null; // TODO This is a fallback value due to incomplete analysis.
		Long id = null; // TODO This is a fallback value due to incomplete analysis.
		Model model = null; // TODO This is a fallback value due to incomplete analysis.
		String expected = null; // TODO This is a fallback value due to incomplete analysis.
		String actual = e.showUpdate(id, model);

		assertEquals(expected, actual);
	}
}
