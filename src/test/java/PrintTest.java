import Minesweeper.*;
import org.junit.*;

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
	public void NineByNinePrintTest() {
		Board NineByNineBoard = Board.createBoard(9, 9, 10);
		System.out.println(BoardConsolePrinter.printBoard(NineByNineBoard));
	}

	@Test
	public void mineShowTest() {
		Board NineByNineBoard = Board.createBoard(9, 9, 10);
		NineByNineBoard.openBlock(3, 4);
		NineByNineBoard.openBlock(4, 7);
		NineByNineBoard.openBlock(8, 2);
		NineByNineBoard.openBlock(7, 5);
		NineByNineBoard.getBlock(4, 5).setFlag(true);
		NineByNineBoard.getBlock(4, 6).setFlag(true);
		NineByNineBoard.getBlock(4, 7).setFlag(true);
		NineByNineBoard.getBlock(4, 8).setFlag(true);

		System.out.println(GameMaster.checkStatus(NineByNineBoard));
		System.out.println(BoardConsolePrinter.printBoard(NineByNineBoard));
	}

	@Test
	public void _20x_20PrintTest() {
		Board _20x20Board = Board.createBoard(20, 20, 10);
		System.out.println(BoardConsolePrinter.printBoard(_20x20Board));
	}
}
