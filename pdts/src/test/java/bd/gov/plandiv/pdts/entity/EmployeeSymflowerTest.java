package bd.gov.plandiv.pdts.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeSymflowerTest {
	@Test
	public void Employee1() {
		Employee expected = null; // TODO This is a fallback value due to incomplete analysis.
		Employee actual = new Employee();

		assertTrue(EqualsBuilder.reflectionEquals(expected, actual, false, null, true));
	}

	@Test
	public void Employee2() {
		Employee employee = null; // TODO This is a fallback value due to incomplete analysis.
		Employee expected = null; // TODO This is a fallback value due to incomplete analysis.
		Employee actual = new Employee(employee);

		assertTrue(EqualsBuilder.reflectionEquals(expected, actual, false, null, true));
	}
}
