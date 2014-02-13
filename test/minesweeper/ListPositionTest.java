package minesweeper;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class ListPositionTest {
	
	@Test
	public void getNeighbors() {
		Position pos = new ListPosition(0, 0);
		ArrayList<Position> neighbors = pos.getNeighbors(2, 2);
		assertEquals(3, neighbors.size());
	}

	@Test
	public void testName() throws Exception {
		Object obj = new ListPosition(0, 0);
		System.out.println(obj.getClass());
	}
}
