package Map;

import static org.junit.Assert.*;

import org.junit.Test;

public class RowOfGridTest {

	RowOfGrid row;
	RowOfGrid row2;
	
	
	@Test
	public void rowOfMap(){
		row = new RowOfGrid(1);
		assertTrue(row.isSizeTrue(1));
	}
	
	@Test
	public void flag(){
		row = new RowOfGrid(1);
		assertFalse(row.isFlag(0));
		row.setFlag(0);
		assertTrue(row.isFlag(0));
	}
	
	@Test
	public void isNotGameOver(){
		row = new RowOfGrid(1);
		assertTrue(row.isNotGameOver());
		row.openSquare(0);
		assertFalse(row.isNotGameOver());

		row2 = new RowOfGrid(1);
		assertTrue(row2.isNotGameOver());
		row2.setMine(0);
		assertFalse(row2.isNotGameOver());
	}
	
}
