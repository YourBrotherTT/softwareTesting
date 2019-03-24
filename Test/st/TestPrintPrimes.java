package st;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPrintPrimes {
	PrintPrimes pr = new PrintPrimes();
	@Before
	public void setUp() throws Exception {
	}
	 
	@After
	public void tearDown() throws Exception {
	}
	 
	@Test
	public void testPrintPrimes() {
		pr.printPrimes(3);
	}
}
