package test.board;

import output.OutPutByConsole;
import junit.framework.TestCase;
import board.Grid;
import board.Position;

public class BoardTest extends TestCase {
	Grid grid;
	Position pos;
	OutPutByConsole print = new OutPutByConsole();

	public void setUp() {
		grid = new Grid(3,3);
		pos = new Position();
		pos.x = 0;
		pos.y = 0;
	}

	public void testCreate() {
		assertEquals(0, grid.openSquare(pos));
	}

	public void testflag() {
		grid.setFlagOnSquare(pos);
		assertTrue(grid.getSquare(pos).isFlag());
	}

	public void testWinByOpen() {
		if (grid.girdSizeX == 1) {
			grid.openSquare(pos);
			assertTrue(grid.isWin());
		}
	}

	public void testWinByMine() {
		if (grid.girdSizeX == 1) {
			grid.getSquare(pos).setMine(true);
			assertTrue(grid.isWin());
		}
	}
	
	public void testReturnNumberOfMine() {
		Position minepos = new Position();
		pos.x = 1;
		pos.y = 1;
		
		minepos.x=0;
		minepos.y=0;
		grid.getSquare(minepos).setMine(true);
		assertEquals(1, grid.openSquare(pos));
		
		minepos.x=0;
		minepos.y=1;
		grid.getSquare(minepos).setMine(true);
		assertEquals(2, grid.openSquare(pos));
		
		minepos.x=0;
		minepos.y=2;
		grid.getSquare(minepos).setMine(true);
		assertEquals(3, grid.openSquare(pos));
		
		minepos.x=1;
		minepos.y=0;
		grid.getSquare(minepos).setMine(true);
		assertEquals(4, grid.openSquare(pos));
		
		minepos.x=1;
		minepos.y=2;
		grid.getSquare(minepos).setMine(true);
		assertEquals(5, grid.openSquare(pos));
		
		minepos.x=2;
		minepos.y=0;
		grid.getSquare(minepos).setMine(true);
		assertEquals(6, grid.openSquare(pos));
		
		minepos.x=2;
		minepos.y=1;
		grid.getSquare(minepos).setMine(true);
		assertEquals(7, grid.openSquare(pos));
		
		minepos.x=2;
		minepos.y=2;
		grid.getSquare(minepos).setMine(true);
		assertEquals(8, grid.openSquare(pos));
	}

	public void testLostByOpenMine() {
		Position minepos = new Position();
		minepos.x=0;
		minepos.y=0;
		grid.getSquare(minepos).setMine(true);
		
		grid.openSquare(pos);
		
		assertTrue(grid.isLose);
	}
	
	public void testGridOpenAfterLose() {
		Position minepos = new Position();
		minepos.x=0;
		minepos.y=0;
		grid.getSquare(minepos).setMine(true);
		
		grid.openSquare(pos);
		
		String str = " M  1  0 " + OutPutByConsole.NEWLINE;
		str += " 1  1  0 " + OutPutByConsole.NEWLINE;
		str += " 0  0  0 " + OutPutByConsole.NEWLINE;;
		
		assertEquals(str ,print.showAll(grid));
		System.out.print(print.showAll(grid));
	}
}
