package st;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCalculte {
	Calculate cal;
	
	@Test
	public void testAdd() {
		Calculate cal = new Calculate();
		assertEquals(6,cal.add(2, 3));
	}
	
	@Test(timeout = 300)
	public void testTimeout() {
		try {
			Thread.sleep(500);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
