import Minesweeper.*;
import org.junit.*;

import static junit.framework.Assert.*;
import static Minesweeper.GameMaster.GameStatus.*;

public class TwoByTwoBoardTest {
	@Test
	public void MineBombLoseTest() throws Exception {
		System.out.println("======= Testing MineBombLoseTest() =======");
		Board TwoByTwoBoard = Board.createBoard(2, 2, 1);
		TwoByTwoBoard.setMine(1, 1, true);
		TwoByTwoBoard.setShow(1, 1, true);
		TwoByTwoBoard.calcBoard();
		assertEquals(GameMaster.checkStatus(TwoByTwoBoard), LOSE);
	}
}
