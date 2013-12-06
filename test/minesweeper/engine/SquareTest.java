package minesweeper.engine;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import minesweeper.engine.Square;

import org.junit.Test;

public class SquareTest {
	@Test
	public void getSymbolWhenClosedSquare() throws Exception {
		Square closed = Square.closedSquare();
		assertThat(closed.getSymbol(), is("C"));
	}
	
	@Test
	public void getSymbolWhenOpendSquare() throws Exception {
		Square opened = Square.openedSquare();
		assertThat(opened.getSymbol(), is("0"));
	}
	
	@Test
	public void mined() throws Exception {
		Square closed = Square.closedSquare();
		closed.mined();
		assertTrue(closed.isMine());
	}
	
	@Test (expected=GameOverException.class)
	public void openedWhenMinedSquare() throws Exception {
		Square square = Square.closedSquare();
		square.mined();
		square.opened();
	}
}
