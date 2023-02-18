package bd.gov.plandiv.pdts.config;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfigSymflowerTest {
	@Test
	public void authenticationManager1() throws Exception {
		SecurityConfig s = null; // TODO This is a fallback value due to incomplete analysis.
		AuthenticationConfiguration authenticationConfiguration = null; // TODO This is a fallback value due to incomplete analysis.
		AuthenticationManager expected = null; // TODO This is a fallback value due to incomplete analysis.
		AuthenticationManager actual = s.authenticationManager(authenticationConfiguration);

		assertEquals(expected, actual);
	}

	@Test
	public void filterChain2() throws Exception {
		SecurityConfig s = null; // TODO This is a fallback value due to incomplete analysis.
		HttpSecurity http = null; // TODO This is a fallback value due to incomplete analysis.
		SecurityFilterChain expected = null; // TODO This is a fallback value due to incomplete analysis.
		SecurityFilterChain actual = s.filterChain(http);

		assertEquals(expected, actual);
	}

	@Test
	public void webSecurityCustomizer3() {
		SecurityConfig s = null; // TODO This is a fallback value due to incomplete analysis.
		WebSecurityCustomizer expected = null; // TODO This is a fallback value due to incomplete analysis.
		WebSecurityCustomizer actual = s.webSecurityCustomizer();

		assertEquals(expected, actual);
	}
}
