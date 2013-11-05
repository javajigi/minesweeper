import Minesweeper.*;
import org.junit.*;

import static junit.framework.Assert.*;
import static Minesweeper.GameMaster.GameStatus.*;

public class PrintTest {
	@Test
	public void OneByOneMinePrintTest() {
		Board OneByOneBoard = Board.createBoard(1, 1, 1);
		System.out.println(BoardConsolePrinter.printBoard(OneByOneBoard));
	}

	@Test
	public void OneByOneNoMinePrintTest() {
		Board OneByOneBoard = Board.createBoard(1, 1, 0);
		System.out.println(BoardConsolePrinter.printBoard(OneByOneBoard));
	}

	@Test
	public void TenByTenPrintTest() {
		Board TenByTenBoard = Board.createBoard(9, 9, 10);
		System.out.println(BoardConsolePrinter.printBoard(TenByTenBoard));
	}
}
