import Minesweeper.*;
import org.junit.*;

import static junit.framework.Assert.*;
import static Minesweeper.GameMaster.GameStatus.*;

public class TwoByTwoBoardTest {
	@Test
	public void MineBombLoseTest() throws Exception {
		System.out.println("======= Testing MineBombLoseTest() =======");
		Board TwoByTwoBoard = Board.createBoard(2, 2, 0);
		TwoByTwoBoard.setMine(1, 1, true);
		TwoByTwoBoard.setShow(1, 1, true);
		TwoByTwoBoard.calcBoard();
		assertEquals(GameMaster.checkStatus(TwoByTwoBoard), LOSE);
	}

	@Test
	public void CheckNearMineONETest() throws Exception {
		System.out.println("======= Testing CheckNearMineONETest() =======");
		Board TwoByTwoBoard = Board.createBoard(2, 2, 0);
		TwoByTwoBoard.setMine(1, 1, true);
		assertEquals(TwoByTwoBoard.getNumofNearMines(1, 2), 1);
	}

	@Test
	public void CheckNearMineTWOTest() throws Exception {
		System.out.println("======= Testing CheckNearMineTWOTest() =======");
		Board TwoByTwoBoard = Board.createBoard(2, 2, 0);
		TwoByTwoBoard.setMine(1, 1, true);
		TwoByTwoBoard.setMine(1, 2, true);
		assertEquals(TwoByTwoBoard.getNumofNearMines(2, 1), 2);
	}

	@Test
	public void CheckNearMineTHREETest() throws Exception {
		System.out.println("======= Testing CheckNearMineTHREETest() =======");
		Board TwoByTwoBoard = Board.createBoard(2, 2, 0);
		TwoByTwoBoard.setMine(1, 1, true);
		TwoByTwoBoard.setMine(1, 2, true);
		TwoByTwoBoard.setMine(2, 1, true);
		assertEquals(TwoByTwoBoard.getNumofNearMines(2, 2), 3);
	}

//	@Test
//	public void CheckIfYouLoseOpenAllMines() throws Exception {
//		System.out.println("======= Testing CheckIfYouLoseOpenAllMines() =======");
//		Board TwoByTwoBoard = Board.createBoard(2, 2, 0);
//		TwoByTwoBoard.setMine(1, 1, true);
//		TwoByTwoBoard.setMine(1, 2, true);
//		TwoByTwoBoard.setShow(1, 1, true);
//		GameMaster.checkStatus(TwoByTwoBoard); // Win, Lose, Gaming이 결정됨.
//		assertEquals(TwoByTwoBoard.getBlock(1, 2).isShow(), true);
//	}
}
