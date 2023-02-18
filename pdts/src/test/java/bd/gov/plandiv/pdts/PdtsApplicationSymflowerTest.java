package bd.gov.plandiv.pdts;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PdtsApplicationSymflowerTest {
	@Test
	public void main1() {
		String[] args = null; // TODO This is a fallback value due to incomplete analysis.
		PdtsApplication.main(args);
	}

	@Test
	public void passwordEncoder2() {
		PdtsApplication p = null; // TODO This is a fallback value due to incomplete analysis.
		PasswordEncoder expected = null; // TODO This is a fallback value due to incomplete analysis.
		PasswordEncoder actual = p.passwordEncoder();

		assertEquals(expected, actual);
	}
}
