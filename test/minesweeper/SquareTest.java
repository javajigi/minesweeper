package minesweeper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SquareTest {
	
	Square square;
	
	@Before
	public void setup() {
		square = new Square();
	}
	
	@Test
	public void initSquare() {
		assertFalse(square.hasMine());
		assertFalse(square.isOpen());
		assertFalse(square.isFlag());
	}
	
	@Test
	public void settingSquare() {
		square.setMine();
		assertTrue(square.hasMine());
		square.setOpen();
		assertTrue(square.isOpen());
		square.setFlag();
		assertTrue(square.isFlag());
	}
	
	@Test
	public void statusWhenClose() throws Exception {
		assertEquals(".", square.status());
		square.setFlag();
		assertEquals("X", square.status());
	}
	
	@Test
	public void statusWhenOpen() throws Exception {
		square.setOpen();
		assertEquals("0", square.status());
		square.setNeighborMineCount(1);
		assertEquals("1", square.status());
		square.setMine();
		assertEquals("*", square.status());
	}
}
