package test.board;

import junit.framework.TestCase;
import board.Board;
import board.Point;
import board.Position;

public class BoardTest extends TestCase {
	Board board = new Board();
	Position pos = new Position();
	
	public void setUp() {
		pos.x = 0;
		pos.y = 0;
	}
	
	public void testCreate() {
		assertEquals(0, board.getposition(pos).getHint());
	}
	
	public void testflag() {
		board.getposition(pos).setFlag(true);
		assertTrue(board.getposition(pos).isFlag());
	}
	
	public void testwin() {
		board.getposition(pos).setOpen(true);
		
		assertTrue(board.isWin());
	}
}
