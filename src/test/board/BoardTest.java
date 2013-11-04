package test.board;

import junit.framework.TestCase;
import board.Board;
import board.Position;

public class BoardTest extends TestCase {
	public void testCreate() {
		Board board = new Board();
		Position pos = new Position();
		pos.x = 0;
		pos.y = 0;
		assertEquals(0, board.getposition(pos));
	}
}
