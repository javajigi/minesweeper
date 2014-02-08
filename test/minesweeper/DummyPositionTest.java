package minesweeper;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class DummyPositionTest {
	
	@Test
	public void getNeighbors() {
		Position pos = new DummyPosition(0, 0);
		ArrayList<Position> neighbors = pos.getNeighbors(2, 2);
		assertEquals(3, neighbors.size());
	}

	@Test
	public void testName() throws Exception {
		Object obj = new DummyPosition(0, 0);
		System.out.println(obj.getClass());
	}
}
