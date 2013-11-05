import Minesweeper.*;
import org.junit.*;

import static junit.framework.Assert.*;
import static Minesweeper.GameMaster.GameStatus.*;

public class FourByFourBoardTest {
	@Test
	public void RandomMineExistingTest() throws Exception {
		System.out.println("======= Testing RandomMineExistingTest() =======");
		Board FourByFourBoard = Board.createBoard(4, 4, 5);
	}
}
