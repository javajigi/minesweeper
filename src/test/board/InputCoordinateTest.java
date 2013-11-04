package test.board;

import junit.framework.TestCase;
import board.InputCoordinate;
import board.Position;

public class InputCoordinateTest extends TestCase{
	public void testInput() {
		InputCoordinate input = new InputCoordinate();
		Position pos = new Position();
		Position testpos =  new Position();
		testpos = input.getCoordinate();
		pos.x=0;
		pos.y=0;
		assertEquals(pos.x, testpos.x);
		assertEquals(pos.y, testpos.y);
	}
}
