package test.board;

import output.OutPutByConsole;
import junit.framework.TestCase;
import board.Grid;
import board.InputCoordinate;
import board.Position;

public class InputCoordinateTest extends TestCase{
	OutPutByConsole print = new OutPutByConsole();
	InputCoordinate input = new InputCoordinate();
	Position pos;
	
	public void setUp() {
		pos = new Position();
		pos.x = 0;
		pos.y = 0;
	}
	
	public void testInput() {
		Position testpos =  new Position();
		testpos = input.getCoordinatebyKeyboard();
		pos.x=0;
		pos.y=0;
		assertEquals(pos.x, testpos.x);
		assertEquals(pos.y, testpos.y);
	}
	
	public void testOpen() {
		Grid grid = new Grid(3, 3);
		Position inputpos =  new Position();
		Position minepos =  new Position();
		InputCoordinate input = new InputCoordinate();
		
		minepos.x = 2;
		minepos.y = 2;
		grid.getSquare(minepos).setMine(true);
		
		minepos.x = 0;
		minepos.y = 0;
		grid.getSquare(minepos).setMine(true);
		
		for(int i= 0 ; i < 9 ; i++) {
			inputpos = input.getCoordinatebyKeyboard();
			grid.openSquare(inputpos);
			
			System.out.print(print.showOpen(grid));
		}
		
	}
	
}
