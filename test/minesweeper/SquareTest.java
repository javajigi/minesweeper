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
		assertFalse(square.isMine());
		assertFalse(square.isOpen());
		assertFalse(square.isFlag());
	}
	
	@Test
	public void settingSquare() {
		square.setMine();
		assertTrue(square.isMine());
		square.setOpen();
		assertTrue(square.isOpen());
		square.setFlag();
		assertTrue(square.isFlag());
	}

}
