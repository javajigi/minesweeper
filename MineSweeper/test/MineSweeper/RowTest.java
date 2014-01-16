package MineSweeper;

import static org.junit.Assert.*;

import org.junit.Test;

public class RowTest {

	@Test
	public void rowTest() {
		Field field = Field.initField();
		field.initCurField();
		
		Row row = field.getRow(0);
		String rowString = row.toString();
		
		assertEquals("x x ", rowString);
	}
	
	@Test
	public void rowMineTest() {
		Field field = Field.initField(5);
		field.initCurField();
		
		field.setupMine(0, 0);
		field.setupMine(1, 1);
		field.setupMine(1, 2);
		field.setupMine(2, 4);
		field.setupMine(4, 4);
		
		assertEquals(1, field.getRow(0).getNumOfMines());
		assertEquals(2, field.getRow(1).getNumOfMines());
		assertEquals(1, field.getRow(2).getNumOfMines());
		assertEquals(0, field.getRow(3).getNumOfMines());
		assertEquals(1, field.getRow(4).getNumOfMines());
		
	}

}
