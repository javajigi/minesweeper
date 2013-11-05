import Minesweeper.*;
import org.junit.*;

import static junit.framework.Assert.*;
import static Minesweeper.GameMaster.GameStatus.*;

public class OneByOneBoardTest {
	@Test
	public void ExistingMineWinTest() throws Exception {
		System.out.println("======= Testing ExistingMineWinTest() =======");
		Board OnebyOneBoard = Board.createBoard(1, 1, 1);
		OnebyOneBoard.setMine(1, 1, true);
		assertEquals(GameMaster.checkStatus(OnebyOneBoard), WIN);
	}

	@Test
	public void NoMineWinTest() throws Exception {
		System.out.println("======= Testing NoMineWinTest() =======");
		Board OneByOneBoard = Board.createBoard(1, 1, 0);
		OneByOneBoard.setMine(1, 1, false);
		OneByOneBoard.setShow(1, 1, true);
		assertEquals(GameMaster.checkStatus(OneByOneBoard), WIN);
	}

	@Test
	public void FlagTest() throws Exception {
		System.out.println("======= Testing FlagTest() =======");
		Board OneByOneBoard = Board.createBoard(1, 1, 0);

		OneByOneBoard.calcBoard();
		assertEquals(OneByOneBoard.getNumofFlagedBlocks(), 0);

		OneByOneBoard.setFlag(1, 1, true);

		OneByOneBoard.calcBoard();
		assertEquals(OneByOneBoard.getNumofFlagedBlocks(), 1);
	}
}
