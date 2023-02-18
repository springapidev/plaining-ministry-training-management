package bd.gov.plandiv.pdts.config;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsServiceSymflowerTest {
	@Test
	public void loadUserByUsername1() throws UsernameNotFoundException {
		CustomUserDetailsService c = null; // TODO This is a fallback value due to incomplete analysis.
		String usernameOrEmail = null; // TODO This is a fallback value due to incomplete analysis.
		UserDetails expected = null; // TODO This is a fallback value due to incomplete analysis.
		UserDetails actual = c.loadUserByUsername(usernameOrEmail);

		assertEquals(expected, actual);
	}
}
