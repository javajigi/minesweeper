import Minesweeper.*;
import org.junit.*;

import static junit.framework.Assert.*;
import static Minesweeper.GameMaster.GameStatus.*;


public class ThreeByThreeBoardTest {
	@Test
	public void MineZeroAllOpenTest() throws Exception {
		Board ThreeByThreeBoard = Board.createBoard(3, 3, 0);
		ThreeByThreeBoard.openBlock(2, 2);
		assertEquals(ThreeByThreeBoard.getBlock(1, 1).isShow(), true);
		assertEquals(ThreeByThreeBoard.getBlock(1, 2).isShow(), true);
		assertEquals(ThreeByThreeBoard.getBlock(1, 3).isShow(), true);
		assertEquals(ThreeByThreeBoard.getBlock(2, 3).isShow(), true);
		assertEquals(ThreeByThreeBoard.getBlock(3, 3).isShow(), true);
		assertEquals(ThreeByThreeBoard.getBlock(3, 2).isShow(), true);
		assertEquals(ThreeByThreeBoard.getBlock(3, 1).isShow(), true);
		assertEquals(ThreeByThreeBoard.getBlock(2, 1).isShow(), true);
	}

	@Test
	public void MineOneTest() throws Exception {
		Board ThreeByThreeBoard = Board.createBoard(3, 3, 0);
		ThreeByThreeBoard.getBlock(3, 3).setMine(true);

		ThreeByThreeBoard.openBlock(2, 2);
		assertEquals(ThreeByThreeBoard.getNumofNearMines(2, 2), 1);
	}

	@Test
	public void MineTwoTest() throws Exception {
		Board ThreeByThreeBoard = Board.createBoard(3, 3, 0);
		ThreeByThreeBoard.getBlock(3, 3).setMine(true);
		ThreeByThreeBoard.getBlock(3, 2).setMine(true);

		ThreeByThreeBoard.openBlock(2, 2);
		assertEquals(ThreeByThreeBoard.getNumofNearMines(2, 2), 2);
	}

	@Test
	public void MineThreeTest() throws Exception {
		Board ThreeByThreeBoard = Board.createBoard(3, 3, 0);
		ThreeByThreeBoard.getBlock(3, 3).setMine(true);
		ThreeByThreeBoard.getBlock(3, 2).setMine(true);
		ThreeByThreeBoard.getBlock(3, 1).setMine(true);

		ThreeByThreeBoard.openBlock(2, 2);
		assertEquals(ThreeByThreeBoard.getNumofNearMines(2, 2), 3);
	}

	@Test
	public void MineFourTest() throws Exception {
		Board ThreeByThreeBoard = Board.createBoard(3, 3, 0);
		ThreeByThreeBoard.getBlock(3, 3).setMine(true);
		ThreeByThreeBoard.getBlock(3, 2).setMine(true);
		ThreeByThreeBoard.getBlock(3, 1).setMine(true);
		ThreeByThreeBoard.getBlock(2, 1).setMine(true);

		ThreeByThreeBoard.openBlock(2, 2);
		assertEquals(ThreeByThreeBoard.getNumofNearMines(2, 2), 4);
	}

	@Test
	public void MineFiveTest() throws Exception {
		Board ThreeByThreeBoard = Board.createBoard(3, 3, 0);
		ThreeByThreeBoard.getBlock(3, 3).setMine(true);
		ThreeByThreeBoard.getBlock(3, 2).setMine(true);
		ThreeByThreeBoard.getBlock(3, 1).setMine(true);
		ThreeByThreeBoard.getBlock(2, 1).setMine(true);
		ThreeByThreeBoard.getBlock(1, 1).setMine(true);

		ThreeByThreeBoard.openBlock(2, 2);
		assertEquals(ThreeByThreeBoard.getNumofNearMines(2, 2), 5);
	}

	@Test
	public void MineSixTest() throws Exception {
		Board ThreeByThreeBoard = Board.createBoard(3, 3, 0);
		ThreeByThreeBoard.getBlock(3, 3).setMine(true);
		ThreeByThreeBoard.getBlock(3, 2).setMine(true);
		ThreeByThreeBoard.getBlock(3, 1).setMine(true);
		ThreeByThreeBoard.getBlock(2, 1).setMine(true);
		ThreeByThreeBoard.getBlock(1, 1).setMine(true);
		ThreeByThreeBoard.getBlock(1, 2).setMine(true);

		ThreeByThreeBoard.openBlock(2, 2);
		assertEquals(ThreeByThreeBoard.getNumofNearMines(2, 2), 6);
	}

	@Test
	public void MineSevenTest() throws Exception {
		Board ThreeByThreeBoard = Board.createBoard(3, 3, 0);
		ThreeByThreeBoard.getBlock(3, 3).setMine(true);
		ThreeByThreeBoard.getBlock(3, 2).setMine(true);
		ThreeByThreeBoard.getBlock(3, 1).setMine(true);
		ThreeByThreeBoard.getBlock(2, 1).setMine(true);
		ThreeByThreeBoard.getBlock(1, 1).setMine(true);
		ThreeByThreeBoard.getBlock(1, 2).setMine(true);
		ThreeByThreeBoard.getBlock(1, 3).setMine(true);

		ThreeByThreeBoard.openBlock(2, 2);
		assertEquals(ThreeByThreeBoard.getNumofNearMines(2, 2), 7);
	}

	@Test
	public void MineEightTest() throws Exception {
		Board ThreeByThreeBoard = Board.createBoard(3, 3, 0);
		ThreeByThreeBoard.getBlock(3, 3).setMine(true);
		ThreeByThreeBoard.getBlock(3, 2).setMine(true);
		ThreeByThreeBoard.getBlock(3, 1).setMine(true);
		ThreeByThreeBoard.getBlock(2, 1).setMine(true);
		ThreeByThreeBoard.getBlock(1, 1).setMine(true);
		ThreeByThreeBoard.getBlock(1, 2).setMine(true);
		ThreeByThreeBoard.getBlock(1, 3).setMine(true);
		ThreeByThreeBoard.getBlock(2, 3).setMine(true);

		ThreeByThreeBoard.openBlock(2, 2);
		assertEquals(ThreeByThreeBoard.getNumofNearMines(2, 2), 8);
	}
}
