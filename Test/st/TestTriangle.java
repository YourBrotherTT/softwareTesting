package st;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestTriangle {
	private int input;
	private boolean output;
	private Triangle tr = null;
	public TestTriangle(int input, boolean output) {
		this.input = input;
		this.output = output;
	}
	
	@Before
	public void setUp() {
		tr = new Triangle();
	}
	
	@Parameters
	public static Collection<Object[]> getData(){
		return Arrays.asList(new Object[][]{
			{-1,false},
			{83,true},
			{99,false},
			{0,true},
			{1,true},
			{2,true},
			{3,true},
			{6,true},
			{11,true},
			{27,true},
			{66,false}
			});
	}
	
	@Test
	public void testIsTriangle() {
		assertEquals(this.output,tr.isTriangle(this.input));
	}
}
