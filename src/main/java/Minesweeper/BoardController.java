package Minesweeper;

public interface BoardController {

	void setMine (int xNum, int yNum, boolean mine);
	void setFlag (int xNum, int yNum, boolean flag);
	void setShow (int xNum, int yNum, boolean show);

	int getNumofInvisibleBlocks();
	int getNumofFlagedBlocks();
	int getNumofMines();
	int getNumofBlocks();

	boolean isBomb();

	void calcBoard();



}
