package dummy;

import static org.junit.Assert.*;

import org.junit.Test;

public class DummyPositionTest {


	
	@Test
	public void create(){
		DummyPosition dummyPosition = new DummyPosition(1, 1);
		assertEquals(2, dummyPosition.getX());
	}

}
