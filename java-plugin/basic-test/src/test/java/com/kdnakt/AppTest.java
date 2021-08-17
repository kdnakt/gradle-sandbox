package com.kdnakt;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {
	@Test
	public void testIsEven() {
		App app = new App();
		assertTrue(app.isEven(3));
	}
}
