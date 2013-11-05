package minesweeper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MapTest {
	Map map;
	
	@Before
	public void setUp() {
		map = new Map(1, 1);
	}
	
	@Test
	public void initSizeOneByOne() {
		assertEquals(1, map.getRow());
		assertEquals(1, map.getCol());
	}
	
	@Test
	public void testNumberOfMine(){
		assertEquals(1, map.getNumberOfMine());
	} 
	
	@Test
	public void testWin() throws Exception {
		assertTrue(map.isWin());
	}

}
