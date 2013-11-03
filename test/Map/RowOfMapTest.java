package Map;

import static org.junit.Assert.*;

import org.junit.Test;

public class RowOfMapTest {

	RowOfMap row;
	RowOfMap row2;
	
	
	@Test
	public void rowOfMap(){
		row = new RowOfMap(1, 0);
		assertTrue(row.isSizeTrue(1));
	}
	
	@Test
	public void flag(){
		row = new RowOfMap(1, 0);
		assertFalse(row.isFlag(0));
		row.setFlag(0);
		assertTrue(row.isFlag(0));
	}
	
	@Test
	public void isNotGameOver(){
		row = new RowOfMap(1, 0);
		assertTrue(row.isNotGameOver());
		row.clickSpace(0);
		assertFalse(row.isNotGameOver());

		row2 = new RowOfMap(1, 1);
		assertTrue(row2.isNotGameOver());
	}
	
}
