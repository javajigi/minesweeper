package minesweeper;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SquareTest {
	@Test
	public void getSymbolWhenClosedSquare() throws Exception {
		Square closed = Square.closedSquare();
		assertThat(closed.getSymbol(), is('C'));
	}
	
	@Test
	public void getSymbolWhenOpendSquare() throws Exception {
		Square opened = Square.openedSquare();
		assertThat(opened.getSymbol(), is('0'));
	}
}
