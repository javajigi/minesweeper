package minesweeper;

import static org.junit.Assert.*;

import org.junit.Test;

public class RowTest {
	private Row row;

	@Test
	public void init() {
		int column = 2;
		row = new Row(column);
		assertEquals(column, row.getCol());
	}

}
