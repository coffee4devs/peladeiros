package br.com.coffeefordevs.peladeiros;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PeladeirosApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void test() {
		System.out.println(removeAllNonNumericCharacter("1A2B3C"));
	}

	public static String removeAllNonNumericCharacter(String input) {
		return input == null ? null : input.replaceAll("[^0123456789]", "");
	}

}
