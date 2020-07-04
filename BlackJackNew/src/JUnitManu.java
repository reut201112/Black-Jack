import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Test;

public class JUnitManu {

	@Test
	public void TestValCard() {
		Menu junit = new Menu();
		@SuppressWarnings("static-access")
		boolean result = junit.validitCard("5326103302663040");
		assertEquals(true, result);
	}
	
	@Test
	public void TestValDate() throws ParseException {
		Menu junit = new Menu();
		@SuppressWarnings("static-access")
		boolean result = junit.valDate("12/24");
		assertEquals(true, result);
	}
	
	@Test
	public void TestValEmail() {
		Menu junit = new Menu();
		@SuppressWarnings("static-access")
		boolean result = junit.validitEmail("carmi@gmail.com");
		assertEquals(true, result);
	}
	
	@Test
	public void TestGetName() throws SQLException {
		Menu junit = new Menu();
		@SuppressWarnings("static-access")
		String result = junit.getName("reut@gmail.com");
		assertEquals("reut", result);
	}
	

}
